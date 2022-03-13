package assembler;

import businesslogic.BusinessLogicAPI;
import businesslogic.BusinessLogicFactory;
import gui.GUIApp;
import persistence.PersistenceAPI;
import persistence.PersistenceFactory;

/**
 * Assembler to setup layers and start the GUI.
 * @author Richard van den Ham / Martijn Bonajo
 */
public class Assembler {

    public static void main(String[] args) {
        
        PersistenceAPI persistenceAPI = PersistenceFactory.getImplementation();
        BusinessLogicAPI businesslogicAPI = BusinessLogicFactory.getImplementation( persistenceAPI );
        
        new GUIApp( businesslogicAPI ).show();
    }
}
