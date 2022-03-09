package gui;

import businesslogic.BusinessLogicAPI;

/**
 * The main class for the GUI
 * 
 * @author m.bonajo@fontys.nl
 */
public class GUIApp {
    
    private final BusinessLogicAPI businessLogicAPI;

    /**
     * Create a new GUI for the Airline Information System
     * @param businessLogicAPI provider to interact with the business logic
     */
    public GUIApp(BusinessLogicAPI businessLogicAPI) {
        this.businessLogicAPI = businessLogicAPI;
    }
    
    /**
     * By default the GUI will not be visible
     * Show the GUI
     */
    public void show() {
        
    }

}
