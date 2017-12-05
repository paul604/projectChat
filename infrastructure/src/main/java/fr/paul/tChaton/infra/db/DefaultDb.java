package fr.paul.tChaton.infra.db;

import fr.paul.tChaton.api.entity.AConstant;
import fr.paul.tChaton.api.entity.Message;
import fr.paul.tChaton.api.entity.User;
import fr.paul.tChaton.api.entity.comparator.ComparatorMessageSendDate;
import fr.paul.tChaton.api.repo.IDb;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class DefaultDb implements IDb {

    private List<User> userList;
    private List<Message> messageList;

    public DefaultDb() {
        setDbUser();
        setDbMessage();

        addUser(new User(AConstant.DEFAULT_USER_ID, AConstant.DEFAULT_USER_NAME));
    }

    @Override
    public boolean setDbUser() {
        this.userList = new ArrayList<>();
        return true;
    }

    @Override
    public boolean addUser(User user) {
        return this.userList.add(user);
    }

    @Override
    public boolean upUser(User user) {
        boolean ret = false;
        User userChage = this.userList.stream()
                .filter(user1 -> user1.getId().equals(user.getId()))
                .findFirst()
                .get();
        if (userChage!=null){
            this.userList.remove(userChage);
            this.userList.add(user);
            ret = true;
        }
        return ret;
    }

    @Override
    public boolean delUser(User user) {
        return this.userList.remove(user);
    }

    @Override
    public User getUserWithId(String id) {
        Optional<User> userFind = this.userList.stream().filter(user -> user.getId().equals(id)).findFirst();
        return userFind.orElse(null);
    }


    //MESSAGE
    @Override
    public boolean setDbMessage() {
        this.messageList = new ArrayList<>();
        return true;
    }

    @Override
    public boolean addMessage(Message message) {
        return this.messageList.add(message);
    }

    @Override
    public boolean upMessage(Message message) {
        // nop
        return false;
    }

    @Override
    public boolean delMessage(Message message) {
        return this.messageList.remove(message);
    }

    @Override
    public List<Message> getHistoryOf(String userId) {
        List<Message> collect = this.messageList.stream()
                .filter(message -> message.getFrom().getId().equals(userId) || message.getForUser().getId().equals(userId))
                .collect(Collectors.toList());
        collect.sort(new ComparatorMessageSendDate());
        return collect;
    }

    //-----------------------------
    //          get & set
    //-----------------------------

    public List<User> getUserList() {
        return userList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }
}
