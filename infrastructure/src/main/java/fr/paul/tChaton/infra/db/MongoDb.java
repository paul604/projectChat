package fr.paul.tChaton.infra.db;

import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.paul.tChaton.api.entity.AConstant;
import fr.paul.tChaton.api.entity.Message;
import fr.paul.tChaton.api.entity.User;
import fr.paul.tChaton.api.repo.IDb;
import org.bson.BsonDocument;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class MongoDb implements IDb {

    Logger LOGGER = LoggerFactory.getLogger(MongoDb.class);

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<User> userCollection;
    private MongoCollection<Message> messageCollection;

    public MongoDb() {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientOptions settings = MongoClientOptions.builder()
                .codecRegistry(pojoCodecRegistry)
                .build();
        //TODO setup MongoClientOptions
        mongoClient = new MongoClient(AConstant.URL_DB+":"+Integer.parseInt(AConstant.PORT_DB), settings);
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

    @Override
    public User getUserWithId(String id) {
        FindIterable<User> users = userCollection.find(eq("id", id));

        return users!=null
                ?users.first()
                :null;
    }


    //MESSAGE
    @Override
    public boolean setDbMessage() {
        messageCollection = database.getCollection("Message", Message.class);
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

    @Override
    public List<Message> getHistoryOf(String userId) {
        return null;
    }

    //-----------------------------
    //             Get
    //-----------------------------

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public MongoCollection<User> getUserCollection() {
        return userCollection;
    }

    public MongoCollection<Message> getMessageCollection() {
        return messageCollection;
    }
}