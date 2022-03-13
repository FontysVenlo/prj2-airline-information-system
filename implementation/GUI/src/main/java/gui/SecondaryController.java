package gui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


/**
 * Just for demo purposes, Controller of other view (secondary.fxml).
 * 
 * @author Richard van den Ham / Martijn Bonajo
 */
public class SecondaryController implements Initializable{
    
    @FXML
    private Button secondaryButton;

    @FXML
    private Label prevLabel;
    
    private final Supplier<SceneManager> sceneManagerSupplier;

    public SecondaryController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }
    
    @FXML
    private void switchToPrimary() {
        sceneManagerSupplier.get().changeScene("customerView");
    }
    
    public void setPreviousView(String view){
        //prevLabel.setText(view);
        System.out.println("VIEW IS " + view);
    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("INITIALIZED!!!");
        //String prev = (String)sceneManagerSupplier.get().getScene().getWindow().getUserData();
        //prevLabel.setText(prev);
    }
}