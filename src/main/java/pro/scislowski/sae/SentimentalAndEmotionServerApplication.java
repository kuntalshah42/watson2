package pro.scislowski.sae;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.LanguageSelection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pro.scislowski.sae.alchemy.AlchemyLanguageService;

@SpringBootApplication
public class SentimentalAndEmotionServerApplication {

    @Value("${sae.alchemyLanguage.apiKey}")
    private String alchemyLanguageApiKey;

    public static void main(String[] args) {
        SpringApplication.run(SentimentalAndEmotionServerApplication.class, args);
    }

    @Bean
    public AlchemyLanguage alchemyLanguage() {
        AlchemyLanguage alchemyLanguage = new AlchemyLanguage();
        alchemyLanguage.setApiKey(alchemyLanguageApiKey);
        alchemyLanguage.setLanguage(LanguageSelection.ENGLISH);
        return alchemyLanguage;
    }

    @Bean
    public AlchemyLanguageService alchemyLanguageService() {
        return new AlchemyLanguageService(alchemyLanguage());
    }

}
