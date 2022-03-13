package gui;

import java.io.IOException;
import java.net.URL;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * Responsible for loading scenes (from fxml) and switching between scenes.
 * 
 * @author Informatics Fontys Venlo
 */
class SceneManager {

    private final Scene scene;
    private final Callback<Class<?>, Object> controllerFactory;
    
    public SceneManager(Callback<Class<?>, Object> controllerFactory, String initialView ) {
        this.controllerFactory = controllerFactory;
        scene = new Scene( loadScene( initialView, null) ); 
    }

    public Scene getScene() {
        return scene;
    }
    
    
    
    /**
     * Change scene to the new view
     * @param view The name of the view to change the scene to
     */
    public final void changeScene(String view) {
        scene.setRoot(loadScene(view, null));
    }    
    
    /**
     * Change scene to the new view
     * And consume the controller belonging to the view
     * Can be used to interact with the controller,
     * before the scene is changed
     * @param <T> The Controller belonging to the view
     * @param view The view to change the scene to
     * @param consumer Consumer that interacts with the Controller
     */
    public final <T> void changeScene(String view, Consumer<T> consumer) {
        scene.setRoot(loadScene(view, consumer));
    }

    private <T> Parent loadScene(String fxml, Consumer<T> consumer) {
        var fxmlResource = GUIApp.class.getResource(fxml + ".fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlResource);
        fxmlLoader.setControllerFactory(controllerFactory);
        
        try {
            Parent parent = fxmlLoader.load();
            if(consumer != null){
                var controller = (T)fxmlLoader.getController();
                consumer.accept(controller);
            }
            return parent;
        } catch (IOException ex) {  
            Logger.getLogger(SceneManager.class.getName()).log(Level.SEVERE, "Unable to load fxml", ex);
            Logger.getLogger(SceneManager.class.getName()).log(Level.SEVERE, "Unable to load fxml", ex.getCause());
            return createErrorPane(fxmlResource, ex);
        }
    }

    void displayOn(Stage stage, int width, int height) {
        stage.setScene(scene);
        stage.setWidth( width );
        stage.setHeight( height );
        stage.show();
    }

    Parent createErrorPane(URL fxmlResource, IOException ex) {
        var parent =  new VBox();
        var titleLabel = new Label("Unable to load fxml");
        titleLabel.setTextFill(Paint.valueOf("#FF0000"));
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), 32));
        parent.getChildren().add(titleLabel);
        
        var loader = GUIApp.class.getClassLoader();
        var loaderName = loader.getName();
        
        addRow(parent, "File", fxmlResource.toString());
        addRow(parent, "Loader name", loaderName);
        
        addRow(parent, "Cause class", ex.getCause().getClass().toString());
        addRow(parent, "Cause message", ex.getCause().getMessage());
        
        var stackTrace = Stream.of(ex.getStackTrace()).limit(10).map(st -> st.toString()).collect(Collectors.joining("\n"));
        var stLabel = new Label("Stacktrace:");
        stLabel.setStyle("-fx-font-weight: bold;");
        parent.getChildren().add(stLabel);
        parent.getChildren().add(new TextArea(stackTrace));
        return parent;
    }
    
    void addRow(VBox parent, String label, String text){
        var row =  new HBox();
        
        var nameLabel = new Label(label + ": ");
        nameLabel.setStyle("-fx-font-weight: bold;");
        
        var textLabel = new Label(text);
        textLabel.setWrapText(true);
        
        row.getChildren().addAll(
                nameLabel,
                textLabel
        );
        
        parent.getChildren().add(row);
    }

}
