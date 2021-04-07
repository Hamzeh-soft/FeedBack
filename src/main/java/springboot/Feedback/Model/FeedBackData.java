/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springboot.Feedback.Model;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GeneratorType;

/*Postman JSON Request
{
    "name":"hamzeh",
    "topic":"First attempt sending email",
    "message":"hello hamzeh",
    "email":"target email"
}

 */
/**
 *
 * @author User
 */
@Entity
public class FeedBackData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(length = 32, columnDefinition = "varchar(32) default 'Anonymous'")
    String name;
    @NotNull
    @NotBlank
    String topic;
    @NotBlank
    @NotNull
    String message;
    @NotNull
    @NotBlank
    @Email
    String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
