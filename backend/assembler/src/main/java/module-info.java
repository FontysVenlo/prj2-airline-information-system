/**
 * Module assembler_module.
 */
module assembler_module {

    requires datarecords_module;

    requires persistence_api_module;
    requires persistence_module;

    requires businesslogic_api_module;
    requires businesslogic_module;

    requires restapi_module;

    requires java.logging;
}