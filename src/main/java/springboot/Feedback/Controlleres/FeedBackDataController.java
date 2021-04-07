/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springboot.Feedback.Controlleres;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.Feedback.Model.FeedBackData;
import springboot.Feedback.Serviecs.FeedBackServices;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(value = "/Feedback")
public class FeedBackDataController {

    @Autowired
    FeedBackServices feedBackServices;

    @PostMapping(value = "/SaveAndSend")
    public String SaveAndSendEmail(@RequestBody @Valid FeedBackData feedBackData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Wrong Input Data";
        } else {
            if (feedBackData.getName().isEmpty() || feedBackData.getName().equals(null)) {
                feedBackData.setName("Anonymous");
            }
            feedBackServices.addFeedBackData(feedBackData);
            return feedBackServices.sendEmail(feedBackData);
        }

    }

    @GetMapping(value = "/allFeedbackData")
    public List<FeedBackData> getAllFeedback() {
        return feedBackServices.getAllFeedback();
    }

    @GetMapping(value = "/getAllMessage")
    public List<String> getAllMessage() {
        return feedBackServices.getAllMessage();
    }

    @GetMapping(value = "/getAllMessageByTopic")
    public Map<String, List<String>> getAllMessageByTopic() {
        return feedBackServices.getAllMessageByTopic();
    }

}
