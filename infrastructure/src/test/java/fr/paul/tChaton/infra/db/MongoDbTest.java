package fr.paul.tChaton.infra.db;

import fr.paul.tChaton.api.entity.AConstant;
import fr.paul.tChaton.api.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class MongoDbTest {

    @Before
    public void setUp() throws Exception {
        AConstant.TYPE_DB = "mongodb";
        AConstant.URL_DB = "localhost";
        AConstant.PORT_DB = "27017";
        AConstant.NAME_DB = "tChatonTest";
    }

    @Test
    public void addOneUser() {
        MongoDb mongoDb = new MongoDb();
        User user = new User(AConstant.DEFAULT_USER_ID, AConstant.DEFAULT_USER_NAME);
        mongoDb.addUser(user);

        User userWithId = mongoDb.getUserWithId(AConstant.DEFAULT_USER_ID);
        assertTrue("add One User", user.equals(userWithId));

    }
}