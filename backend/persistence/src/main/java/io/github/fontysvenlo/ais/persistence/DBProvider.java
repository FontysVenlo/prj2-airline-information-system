package io.github.fontysvenlo.ais.persistence;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;

/**
 * Provides DataSources for the database connection.
 */
public class DBProvider {
    /**
     * Private constructor to prevent instantiation.
     */
    private DBProvider() {}

    static Map<String, DataSource> cache = new HashMap<>();

    static DataSource getDataSource(final DBConfig config) {
        return cache.computeIfAbsent(config.namespace(), namespace -> {
                PGSimpleDataSource source = new PGSimpleDataSource();

                String[] serverNames = {config.host()};
                source.setServerNames(serverNames);

                int[] portNumbers = {config.port()};
                source.setPortNumbers(portNumbers);
                source.setUser(config.username());
                source.setDatabaseName(config.name());
                source.setPassword(config.password());
                source.setCurrentSchema(config.schema());

                return source;
            }
        );
    }
}
