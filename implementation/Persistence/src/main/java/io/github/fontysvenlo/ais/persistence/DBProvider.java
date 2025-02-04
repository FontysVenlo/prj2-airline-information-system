package io.github.fontysvenlo.ais.persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;

/**
 * Provides DataSources for the database connections.
 */
public class DBProvider {
    /**
     * Private constructor to prevent instantiation.
     */
    private DBProvider() {}

    static Map<String, DataSource> cache = new HashMap<>();

    static DataSource getDataSource(final String sourceName) {

        return cache.computeIfAbsent(sourceName,
                (s) -> {
                    Properties props = properties("application.properties");

                    PGSimpleDataSource source = new PGSimpleDataSource();

                    String prefix = sourceName + ".";

                    String[] serverNames = {props.getProperty(prefix + "dbhost")};
                    source.setServerNames(serverNames);

                    int[] portNumbers = {Integer.parseInt(props.getProperty(prefix + "port"))};
                    source.setPortNumbers(portNumbers);

                    source.setUser(props.getProperty(prefix + "username"));
                    source.setDatabaseName(props.getProperty(prefix + "dbname"));
                    source.setPassword(props.getProperty(prefix + "password"));
                    source.setCurrentSchema(props.getProperty(prefix + "schema"));

                    return source;
                }
        );
    }

    static Properties properties(String propFileName) {

        System.out.println("The USER DIR is " + System.getProperty("user.dir"));


        // Preferred way to do it. No issues with working dir.
        // Uses the default location of resources (in src/main/java/resources dir)
        // getClassLoader() is still necessary!
        Properties p = new Properties();
        try (InputStream dbProperties = DBProvider.class.getClassLoader().getResourceAsStream("db.properties");) {
            p.load(dbProperties);
            String property = p.getProperty("aisdb.username");
            System.out.println("property = " + property);
        } catch (IOException ex) {
            Logger.getLogger(DBProvider.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Alternative way, but issues with path. Relative path works if root of
        // Assembler project is working directory. In this case application.properties
        // must be in same folder as pom.xml file of Persistence project.
        // Better not to use.
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("../Persistence/" + propFileName);) {
            properties.load(fis);
        } catch (IOException ignored) {
            Logger.getLogger(DBProvider.class.getName()).log(
                    Level.INFO,
                    "attempt to read file from well known location failed'",
                    ignored);
        }
        return properties;
    }
}
