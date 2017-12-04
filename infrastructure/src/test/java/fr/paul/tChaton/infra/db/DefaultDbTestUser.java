package fr.paul.tChaton.infra.db;

import fr.paul.tChaton.api.entity.AConstant;
import fr.paul.tChaton.api.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class DefaultDbTestUser {

    @Test
    public void addOneUser() throws Exception {
        DefaultDb db = new DefaultDb();
        User user = new User(AConstant.DEFAULT_USER_ID, AConstant.DEFAULT_USER_NAME);
        db.addUser(user);

        List<User> users = new ArrayList<>();
        users.add(user);

        assertArrayEquals("addOneUser", users.toArray(new User[0]), db.getUserList().toArray(new User[0]));
    }

    @Test
    public void upUser() throws Exception {
        DefaultDb db = new DefaultDb();
        User user = new User(AConstant.DEFAULT_USER_ID, "aaaaaaaaaaaaaaaa");
        db.addUser(user);

        user.setNom(AConstant.DEFAULT_USER_NAME);

        db.upUser(user);

        List<User> users = new ArrayList<>();
        users.add(user);

        assertArrayEquals("addOneUser", users.toArray(new User[0]), db.getUserList().toArray(new User[0]));
    }

    @Test
    public void delUser() throws Exception {

        DefaultDb db = new DefaultDb();
        User user = new User(AConstant.DEFAULT_USER_ID, AConstant.DEFAULT_USER_NAME);
        db.addUser(user);

        db.delUser(user);

        assertTrue(db.getUserList().isEmpty());
    }

    @Test
    public void getUserWithExistingId() throws Exception {
        DefaultDb db = new DefaultDb();
        User user = new User(AConstant.DEFAULT_USER_ID, AConstant.DEFAULT_USER_NAME);
        db.addUser(user);

        assertEquals("get User with existing id", user, db.getUserWithId(AConstant.DEFAULT_USER_ID));
    }

    @Test
    public void getUserWithNotExistingId() throws Exception {
        DefaultDb db = new DefaultDb();
        User user = new User(AConstant.DEFAULT_USER_ID, AConstant.DEFAULT_USER_NAME);
        db.addUser(user);

        assertEquals("get User with not existing id", null, db.getUserWithId("FalseId"));
    }
}