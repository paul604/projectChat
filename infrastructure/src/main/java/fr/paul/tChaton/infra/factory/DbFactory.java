package fr.paul.tChaton.infra.factory;

import fr.paul.tChaton.api.entity.AConstant;
import fr.paul.tChaton.api.factory.IFactory;
import fr.paul.tChaton.api.repo.IDb;
import fr.paul.tChaton.infra.db.MongoDb;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class DbFactory implements IFactory {

    @Override
    public IDb createDb() {
        IDb db = null;
        if (AConstant.TYPE_DB.equalsIgnoreCase("mongodb")) {
            db = new MongoDb();
        }
        return db;
    }

}
