/**
 * Module persistence_module.
 */
module persistence_module { 
    requires datarecords_module;
    requires persistence_api_module;
    
    requires java.logging;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires java.naming;
    
    exports io.github.fontysvenlo.ais.persistence;
}
