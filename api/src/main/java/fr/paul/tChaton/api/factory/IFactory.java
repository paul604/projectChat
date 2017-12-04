package fr.paul.tChaton.api.factory;

import fr.paul.tChaton.api.repo.IDb;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public interface IFactory {

    IDb createDb();

}
