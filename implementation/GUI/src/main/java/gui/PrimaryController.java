package gui;

import java.io.IOException;
import java.util.function.Supplier;
import javafx.fxml.FXML;

/**
 * Just for demo purposes, Controller of other view (primary.fxml).
 * 
 * @author Informatics Fontys Venlo
 */
class PrimaryController {
    
    private final Supplier<SceneManager> sceneManagerSupplier;

    public PrimaryController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }
        
    @FXML
    private void switchToSecondary() throws IOException {
        sceneManagerSupplier.get().changeScene("secondary");
    }
}
