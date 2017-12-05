package fr.paul.tChaton.marketing.service.conversation;

import fr.paul.tChaton.api.entity.User;
import fr.paul.tChaton.api.exception.UserIdNotFound;
import fr.paul.tChaton.api.repo.IDb;

import javax.annotation.Resource;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class History {

    @Resource
    private IDb db;

    public fr.paul.tChaton.api.entity.History serviceHistory(String id) throws UserIdNotFound {

        User user = db.getUserWithId(id);
        if (user == null){
            throw new UserIdNotFound("id null ou non valid");
        }

        fr.paul.tChaton.api.entity.History history = new fr.paul.tChaton.api.entity.History(user);

        history.setMessages(db.getHistoryOf(user.getId()));

        return history;
    }

    //-----------------------------
    //          Get & Set
    //-----------------------------

    public IDb getDb() {
        return db;
    }

    public void setDb(IDb db) {
        this.db = db;
    }
}
