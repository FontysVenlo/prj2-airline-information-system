package gui;

import businesslogic.BusinessLogicAPI;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.application.Platform;
import javafx.util.Callback;


/**
 * Main GUI App. Gets Business Logic injected. Delegates the switching of scenes
 * to the SceneManager. The controllerFactory takes care of instantiating the
 * controllers. This enables you to use parameterized constructors and to inject
 * (as in the example below regarding the CustomerController) a link to the 
 * business logic layer. Invocation / initialization of this JavaFX app has been 
 * slightly adapted compared to a default generated JavaFX app. See documentation 
 * above show() method.
 * 
 * @author Informatics Fontys Venlo
 */
public class GUIApp extends Application {

    private BusinessLogicAPI businessLogicAPI;
    private SceneManager sceneManager;
    private static final String INITIAL_VIEW = "customerView";

    private final Callback<Class<?>, Object> controllerFactory = (Class<?> c)
            -> {

        switch (c.getName()) {
            case "gui.CustomerController":
                return new CustomerController(this::getSceneManager, businessLogicAPI.getCustomerManager());
            case "gui.PrimaryController":
                return new PrimaryController(this::getSceneManager);
            case "gui.SecondaryController":
                return new SecondaryController(this::getSceneManager);
            case "gui.ErrorController":
                return new ErrorController(this::getSceneManager);
            default:
                return null;
        }
    };

    public GUIApp(BusinessLogicAPI businessLogicAPI) {
        this.businessLogicAPI = businessLogicAPI;
    }

    /**
     * Normally, a JavaFX application has a main method that invokes the
     * launch() method. Since we want to instantiate the GUIApp ourselves,
     * in order to be able to inject a link to the Business Logic, we have to
     * rewrite the initialization process. This method is meant for invocation
     * from the assembler. It will trigger the initialization of the JavaFX 
     * Toolkit. From a GUI test context, typically the init() method will be 
     * invoked with 'false' as parameter, since the JavaFXToolkit doesn't need
     * to be initialized in that case.
     * 
     * @return GUIApp 
     */
    public GUIApp show() {
        return init(true);
    }

    GUIApp init(boolean startJavaFXToolkit) {

        if (startJavaFXToolkit) {

            Platform.startup(() -> {
            });

            initializeSceneManager();

            Platform.runLater(() -> {
                Stage stage = new Stage();
                try {
                    start(stage);
                } catch (IOException ex) {
                    throw new IllegalStateException(ex);
                }
            });

        } else {
            initializeSceneManager();
        }

        return this;
    }

    private void initializeSceneManager() {
        sceneManager = new SceneManager(controllerFactory, INITIAL_VIEW);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Demo Airline Information System");
        sceneManager.displayOn(stage, 640, 480);
    }

    public SceneManager getSceneManager() {
        return sceneManager;
    }
}
