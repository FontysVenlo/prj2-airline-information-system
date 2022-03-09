module gui {
    
    requires transitive javafx.fxml;
    requires transitive javafx.controls;
    requires java.logging;
    requires java.base;
    
    requires transitive businesslogic;
        
    opens gui to javafx.fxml;
    
    exports gui;
    
}
