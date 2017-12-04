package fr.paul.tChaton.infra.db;

import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.paul.tChaton.api.entity.AConstant;
import fr.paul.tChaton.api.entity.Message;
import fr.paul.tChaton.api.entity.User;
import fr.paul.tChaton.api.repo.IDb;
import org.bson.BSON;
import org.bson.BSONObject;
import org.bson.BsonDocument;
import org.bson.codecs.BsonObjectIdCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class MongoDb implements IDb {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<User> userCollection;
    private MongoCollection<Message> messageCollection;

    public MongoDb() {

        mongoClient = new MongoClient(AConstant.URL_DB, Integer.parseInt(AConstant.URL_DB));
        database = mongoClient.getDatabase(AConstant.NAME_DB);

        setDbUser();
        setDbMessage();
    }

    private void logError(Exception e){
        LOGGER.error(e.getLocalizedMessage());
        LOGGER.error(Arrays.stream(e.getStackTrace())
                .map(stackTraceElement -> stackTraceElement.toString()+"\n")
                .reduce((s, s2) -> s+s2)
                .get());
    }

    @Override
    public boolean setDbUser() {
        userCollection = database.getCollection("User", User.class);
        return userCollection != null;
    }

    @Override
    public boolean addUser(User user) {
        boolean ret = true;
        try{
            userCollection.insertOne(user);
        }catch (Exception e){
            logError(e);
            ret = false;
        }
        return ret;
    }

    @Override
    public boolean upUser(User user) {
        // TODO
        return false;
    }

    @Override
    public boolean delUser(User user) {
        boolean ret = true;
        try{
            userCollection.deleteOne(BsonDocument.parse(new GsonBuilder().create().toJson(user)));
        }catch (Exception e){
            logError(e);
            ret = false;
        }
        return ret;
    }


    //MESSAGE
    @Override
    public boolean setDbMessage() {
        messageCollection = database.getCollection("User", Message.class);
        return messageCollection != null;
    }

    @Override
    public boolean addMessage(Message message) {
        boolean ret = true;
        try{
            messageCollection.insertOne(message);
        }catch (Exception e){
            logError(e);
            ret = false;
        }
        return ret;
    }

    @Override
    public boolean upMessage(Message message) {
        //TODO
        return false;
    }

    @Override
    public boolean delMessage(Message message) {
        boolean ret = true;
        try{
            userCollection.deleteOne(BsonDocument.parse(new GsonBuilder().create().toJson(message)));
        }catch (Exception e){
            logError(e);
            ret = false;
        }
        return ret;
    }
}