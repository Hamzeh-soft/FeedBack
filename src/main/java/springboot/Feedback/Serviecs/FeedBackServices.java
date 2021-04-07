/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springboot.Feedback.Serviecs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import springboot.Feedback.Dao.FeedbackDao;
import springboot.Feedback.Model.FeedBackData;

/**
 *
 * @author User
 */
@Service
public class FeedBackServices {

    @Autowired
    FeedbackDao feedbackDao;
    @Autowired
    private JavaMailSender javaMailSender;

    public void addFeedBackData(FeedBackData feedBackData) {
        feedbackDao.save(feedBackData);
    }

    public String sendEmail(FeedBackData feedBackData) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("email");
        simpleMailMessage.setTo(feedBackData.getEmail());
        simpleMailMessage.setSubject(feedBackData.getTopic());
        simpleMailMessage.setText(feedBackData.getMessage());
        javaMailSender.send(simpleMailMessage);
        return "Message Send Successfully";
    }

    public List<FeedBackData> getAllFeedback() {
        return feedbackDao.findAll();
    }

    public List<String> getAllMessage() {
        return feedbackDao.findAll()
                .stream()
                .map(FeedBackData::getMessage)
                .collect(Collectors.toList());
    }

    public Map<String, List<String>> getAllMessageByTopic() {
        return feedbackDao.findAll()
                .stream()
                .collect(Collectors.groupingBy(FeedBackData::getTopic, HashMap::new,
                        Collectors.mapping(FeedBackData::getMessage, Collectors.toList())));
    }

}
