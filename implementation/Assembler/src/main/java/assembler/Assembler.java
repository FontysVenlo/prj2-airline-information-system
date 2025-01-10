package assembler;

import businesslogic.BusinessLogicAPI;
import businesslogic.BusinessLogicFactory;
//import gui.GUIApp;
import persistence.PersistenceAPI;
import persistence.PersistenceFactory;
import org.acme.openapi.swaggerui.RESTServer;
import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.Quarkus;

/**
 * Assembler to setup layers and start the REST Service.
 * @author Informatics Fontys Venlo
 */
@QuarkusMain
public class Assembler {

    public static void main(String[] args) {
        
        PersistenceAPI persistenceAPI = PersistenceFactory.getImplementation();
        BusinessLogicAPI businesslogicAPI = BusinessLogicFactory.getImplementation( persistenceAPI );
        
        //new RESTServer(businesslogicAPI).start(8889);
        io.quarkus.runtime.Quarkus.run(new String[]{});
        System.out.println("Assembler");
        new RESTServer().start(businesslogicAPI);
    }
}
