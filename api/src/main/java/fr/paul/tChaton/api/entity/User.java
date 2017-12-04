package fr.paul.tChaton.api.entity;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class User {

    private String id;
    private String nom;

    public User(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return id.equals(user.id);
    }
}
