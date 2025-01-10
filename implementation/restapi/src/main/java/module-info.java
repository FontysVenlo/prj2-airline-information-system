module restapi_module {
    requires java.base;
    requires persistence_module;
    requires businesslogic_module;
    requires datarecords_module;

    requires jakarta.ws.rs;
    requires quarkus.core;
    requires jakarta.cdi;
    requires jakarta.inject;

    exports restapi;
}
