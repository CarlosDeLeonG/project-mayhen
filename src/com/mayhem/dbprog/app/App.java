/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mayhem.dbprog.app;

import com.mayhem.dbprog.app.data.dao.*;
import com.mayhem.dbprog.app.data.entities.Student;
import com.mayhem.dbprog.messages.*;
import com.mayhem.dbprog.messages.concrete.*;
import com.mayhem.dbprog.messages.util.MessageHandler;
import java.util.Date;
import java.util.logging.*;



/**
 *
 * @author Carlos
 */
public class App implements MessageProducer {
    private MessageHandler handler;
    private MessageEntityListener entityReceiver;
   
    public App(String path) {
        handler = new MessageHandler();
        entityReceiver = new MessageEntityListener();
        
        this.addListener(entityReceiver);
        
        TestDao test = new TestDao();
        Student s = test.testDao();
        if (s.getId() != null)
            sendMessage(new Message(MessageType.TEST, new Object[] {s, "Student Created"}));
    }
    
    public static void main(String[] args) {
        try {
            new App(args[0]);
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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

class TestDao {
    protected Student testDao() {
        StudentDao dao = DaoFactory.getStudentDao(DaoType.JPA);
        Student s = dao.createStudent("Gónzalo", "Iguaín", new Date());
        return s;    
    }
}

class MessageEntityListener implements MessageListener {

    @Override
    public void messageReceived(Message message) {
        Object entityMessage[] = (Object[])message.getBody();
        Object entity = entityMessage[0];
        String text = (String)entityMessage[1];
        System.out.println("Message: " + text + " " + entity);
    }
    
}