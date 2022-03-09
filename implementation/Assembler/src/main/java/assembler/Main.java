package assembler;

import businesslogic.BusinessLogicAPI;
import businesslogic.BusinessLogicAPIProvider;
import gui.GUIApp;
import persistence.PersistenceAPI;
import persistence.PersistenceAPIProvider;

/**
 *
 * @author m.bonajo@fontys.nl
 */
public class Main {
    
    /**
     * Start the application
     * 
     * Assemble all the parts that are needed for the application and
     * show the GUI
     * @param args 
     */
    public static void main(String[] args) {
        
        PersistenceAPI persistenceAPI = PersistenceAPIProvider.getPersistenceAPI();
        BusinessLogicAPI businessLogicAPI = BusinessLogicAPIProvider.getBusinessLogic(persistenceAPI);
        
        new GUIApp(businessLogicAPI).show();
    }
    
}
