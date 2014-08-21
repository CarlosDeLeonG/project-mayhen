/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mayhem.dbprog.app.data.dao.jpa;


import com.mayhem.dbprog.app.data.dao.StudentDao;
import com.mayhem.dbprog.app.data.entities.Student;
import com.mayhem.dbprog.app.data.entities.jpa.StudentJPA;
import com.mayhem.dbprog.messages.MessageListener;
import com.mayhem.dbprog.messages.concrete.Message;
import com.mayhem.dbprog.messages.concrete.MessageType;
import java.util.Date;

/**
 *
 * @author Carlos
 */
public class StudentDaoJPA extends DaoJPA implements StudentDao{
    
    public StudentDaoJPA() {
        super();
    }
    
    @Override
    public Student createStudent(String name, String lastName, Date birthday){
        Student student = new StudentJPA(name, lastName, birthday);
        begin();
        try {
            em.persist(student);
            commit();
        } catch (Exception e) {
            rollback();
        } 
        return student;
    }

    @Override
    public void addListener(MessageListener listener) {
        handler.addListener(listener);
    }

    @Override
    public void removeListener(MessageListener listener) {
            handler.removeListener(listener);
    }

    @Override
    public void sendMessage(Message message) {
        handler.sendMessage(message);
    }
    
    
}
