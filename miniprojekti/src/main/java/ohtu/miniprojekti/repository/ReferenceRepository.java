/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniprojekti.repository;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.Transaction;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.SQLitePlatform;
import org.h2.engine.Database;

/**
 *
 * @author jonne
 */
public class ReferenceRepository {
    
    public ReferenceRepository() {
        
    }
    
    private static EbeanServer initializeDatabase(boolean dropAndCreateDatabase, Database db) {
        ServerConfig config = new ServerConfig();
        config.setName("beerDb");


        if (db == Database.SQLite) {
            DataSourceConfig sqLite = new DataSourceConfig();
            sqLite.setDriver("org.sqlite.JDBC");
            sqLite.setUsername("mluukkai");
            sqLite.setPassword("mluukkai");
            //sqLite.setUrl("jdbc:sqlite:/home/mluukkai/sqlite/kannat/beer.db");
            sqLite.setUrl("jdbc:sqlite:reference.db");
            config.setDataSourceConfig(sqLite);
            config.setDatabasePlatform(new SQLitePlatform());
            config.getDataSourceConfig().setIsolationLevel(Transaction.READ_UNCOMMITTED);
        }

        config.setDefaultServer(false);
        config.setRegister(false);

        config.addClass(Reference.class);

        if (dropAndCreateDatabase) {
            config.setDdlGenerate(true);
            config.setDdlRun(true);
            //config.setDebugSql(true);
        }
        
        return EbeanServerFactory.create(config);
    }
}
