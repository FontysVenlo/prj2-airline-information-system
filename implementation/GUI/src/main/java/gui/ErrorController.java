package gui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Informatics Fontys Venlo
 */
class ErrorController implements Initializable {

    private final Supplier<SceneManager> sceneManagerSupplier;

    public ErrorController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
