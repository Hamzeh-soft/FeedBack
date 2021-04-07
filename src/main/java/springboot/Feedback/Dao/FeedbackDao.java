/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springboot.Feedback.Dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.Feedback.Model.FeedBackData;

/**
 *
 * @author User
 */
@Repository
public interface FeedbackDao extends CrudRepository<FeedBackData, Integer> {

    @Override
    List<FeedBackData> findAll();
    /*
    The second state includes three one-hour 
    interviews over Skype (or on-site if you are based 
    in one of the cities where their sites are.) Each 
    interview was supposed to include two topics, eventually
    covering architecture, algorhithms + data structures, testing, OOP +
    design patterns, databases, general code quality and problem solving.
    */
}
