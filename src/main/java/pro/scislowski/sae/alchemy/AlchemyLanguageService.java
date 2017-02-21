package pro.scislowski.sae.alchemy;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentEmotion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maciej.Scislowski@gmail.com
 */
public class AlchemyLanguageService {

    private AlchemyLanguage alchemyLanguage;

    public AlchemyLanguageService(AlchemyLanguage alchemyLanguage) {
        this.alchemyLanguage = alchemyLanguage;
    }

    public DocumentEmotion.Emotion process(String message) {
        Map<String,Object> params = new HashMap<>();
        params.put(AlchemyLanguage.TEXT, message);
        return alchemyLanguage.getEmotion(params).execute().getEmotion();
    }

}
