package fr.paul.tChaton;

import fr.paul.tChaton.api.factory.IFactory;
import fr.paul.tChaton.infra.factory.DbFactory;
import fr.paul.tChaton.marketing.service.conversation.Chat;
import fr.paul.tChaton.marketing.service.conversation.History;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "fr.paul.tChaton")
public class AppConfig {

	private static final Logger LOG = Logger.getLogger(AppConfig.class);

    @Bean
    public IFactory getFactoy(){
        return new DbFactory();
    }

	@Bean("chat")
	public Chat getChat() {
		return new Chat();
	}

    @Bean("history")
	public History getHyHistory(){
        return new History();
    }
}