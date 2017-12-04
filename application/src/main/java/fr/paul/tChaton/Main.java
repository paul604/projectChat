package fr.paul.tChaton;

import fr.paul.tChaton.api.entity.AConstant;
import fr.paul.tChaton.application.api.ConversationMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.InvalidParameterException;
import java.util.Arrays;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
@SpringBootApplication(scanBasePackages = { "fr.paul.tChaton.application.api" })
public class Main {

    private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) {
        try {
            if(args.length!=4){
                throw new InvalidParameterException("type, name, url, port");
            }
            AConstant.TYPE_DB = args[0];
            AConstant.NAME_DB = args[1];
            AConstant.URL_DB = args[2];
            AConstant.PORT_DB = args[3];
            SpringApplication.run(Main.class, args);

        }catch (Exception e){
            LOGGER.error(e.getLocalizedMessage());
            LOGGER.error(Arrays.stream(e.getStackTrace())
                    .map(stackTraceElement -> stackTraceElement.toString()+"\n")
                    .reduce((s, s2) -> s+s2)
                    .get());
        }
    }

}