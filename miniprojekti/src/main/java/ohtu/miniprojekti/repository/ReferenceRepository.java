/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniprojekti.repository;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.Transaction;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.SQLitePlatform;
import org.h2.engine.Database;
import ohtu.miniprojekti.domain.Reference;
import org.springframework.stereotype.Component;

/**
 *
 * @author jonne
 */

@Component
public class ReferenceRepository {
    private EbeanServer server;
    
    enum Database {
        H2, SQLite
    }
    
    public ReferenceRepository() {
        this.server = initializeDatabase(true, Database.SQLite);
    }
    
    private static EbeanServer initializeDatabase(boolean dropAndCreateDatabase, Database db) {
        ServerConfig config = new ServerConfig();
        config.setName("referenceDB");
        
        if (db == Database.H2) {
            DataSourceConfig hdDB = new DataSourceConfig();
            hdDB.setDriver("org.h2.Driver");
            hdDB.setUsername("test");
            hdDB.setPassword("test");
            hdDB.setUrl("jdbc:h2:mem:tests;DB_CLOSE_DELAY=-1");
            hdDB.setHeartbeatSql("select 1 ");
            config.setDataSourceConfig(hdDB);
        }

        if (db == Database.SQLite) {
            DataSourceConfig sqLite = new DataSourceConfig();
            sqLite.setDriver("org.sqlite.JDBC");
            sqLite.setUsername("reference");
            sqLite.setPassword("reference");
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
    
    public void  addArticle(Reference reference) {
        server.save(reference);     
    }
}
