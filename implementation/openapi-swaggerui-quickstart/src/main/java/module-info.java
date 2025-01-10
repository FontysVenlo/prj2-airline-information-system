module restapi_module {
    requires java.base;    
    requires businesslogic_module;
    requires datarecords_module;
    
    requires jakarta.ws.rs;
    requires quarkus.core;
    requires jakarta.cdi;
    
    exports org.acme.openapi.swaggerui;
}
