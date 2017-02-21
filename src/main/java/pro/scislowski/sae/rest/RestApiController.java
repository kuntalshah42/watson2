package pro.scislowski.sae.rest;

import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentEmotion;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pro.scislowski.sae.alchemy.AlchemyLanguageService;

import javax.inject.Inject;
import java.io.IOException;

/**
 * @author Maciej.Scislowski@gmail.com
 */
@RestController
public class RestApiController {

    @Inject
    private AlchemyLanguageService alchemyLanguageService;

    @PostMapping(value = "/messages", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MessageResponse> messages(@RequestBody MessageRequest messageRequest) throws IOException {
        DocumentEmotion.Emotion result = alchemyLanguageService.process(messageRequest.getMessage());
        MessageResponse messageResponse = new MessageResponse(messageRequest, result);
        return ResponseEntity.ok(messageResponse);
    }

}
