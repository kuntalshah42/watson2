package pro.scislowski.sae.rest;

import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentEmotion;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Maciej.Scislowski@gmail.com
 */
@Data
@AllArgsConstructor
public class MessageResponse {

    private MessageRequest messageRequest;
    private DocumentEmotion.Emotion result;

}
