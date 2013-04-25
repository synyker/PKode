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
import java.util.List;
import org.h2.engine.Database;
import ohtu.miniprojekti.domain.Reference;
import org.springframework.stereotype.Component;

/**
 * ReferenceRepositoru handles database connections.
 * 
 * There are methods for example for adding a reference and listing all added references.
 * 
 * @author jonne, krista, markus
 */

@Component
public class ReferenceRepository {
    private EbeanServer server;

    
    public enum Database {
        H2, SQLite
    }
    
    /**
     * If no parameter is given for the constructor, Database is initialised as SQLite
     */
    public ReferenceRepository() {
        this.server = initializeDatabase(true, Database.SQLite);
    }
    
    /**
     * This constructor takes as a parameter the type of Database(H2 or SQLite)
     * @param dropAndCreateDatabase boolean whether to drop and create the database
     * @param db 
     */
    public ReferenceRepository(boolean dropAndCreateDatabase, Database db) {
        this.server = initializeDatabase(dropAndCreateDatabase, db);
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
    
//    public void reInitialise(boolean dropAndCreateDatabase, Database db) {
//        this.server = initializeDatabase(dropAndCreateDatabase, db);
//    }
    
    /**
     * Adds a Reference to the Databsae
     * @param reference 
     */
    public void addArticle(Reference reference) {
        reference = checkThatTextidUnique(reference);
        server.save(reference);
    }
    
    /**
     * Deletes a Reference from the Database
     * @param reference 
     */
    public void deleteArticle(String id) {
        List<Reference> reference = server.find(Reference.class).where().like("id", id).findList();
        server.delete(reference);
    }
    
    /**
     * Checks that the textid set for a reference is unique.
     * 
     * If it is not unique, a letter (a, b, c..) is added into the end to make
     * it unique.
     * 
     * @param reference to be checked
     * @return reference with unique textid
     */
    private Reference checkThatTextidUnique(Reference reference) {
        int amount = 0;
        List<Reference> allreferences = getList();
        for (Reference ref : allreferences) {
            if (ref.getTextid().startsWith(reference.getTextid())) {
                amount++;
            }
        }
        if (amount != 0) {
            char c = (char) (96+amount);
            reference.setTextid(reference.getTextid().concat(""+c));
        }
        return reference;
    }
    
    /**
     * returns a list containing all the references in the database
     * @return 
     */
    public List<Reference> getList() {
        return this.server.find(Reference.class).findList();
    }
    
    /**
     * returns a list of references where author field includes the given String
     * 
     * @param author string that we are trying to find
     * @return references containing the string in the author field
     */
     public List<Reference> findList(String author) {
        return server.find(Reference.class).where().like("author","%"+author+"%").findList();
    }
    
}
