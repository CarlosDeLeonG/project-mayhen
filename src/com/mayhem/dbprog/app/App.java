/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mayhem.dbprog.app;

import com.mayhem.dbprog.app.data.dao.DaoFactory;
import com.mayhem.dbprog.app.data.dao.DaoType;
import com.mayhem.dbprog.app.data.dao.StudentDao;
import com.mayhem.dbprog.app.data.entities.Student;
import com.mayhem.dbprog.app.data.entities.jpa.StudentJPA;
import com.mayhem.dbprog.messages.*;
import com.mayhem.dbprog.messages.concrete.*;
import com.mayhem.dbprog.messages.util.MessageHandler;
import java.io.*;
import java.util.Date;
import java.util.logging.*;
import javax.persistence.*;



/**
 *
 * @author Carlos
 */
public class App implements MessageProducer {
    private MessageHandler handler;
    private MessageEntityListener entityReceiver;
    private File file;
    
    public App(String path) throws FileNotFoundException {
        handler = new MessageHandler();
        entityReceiver = new MessageEntityListener();
        
        this.addListener(entityReceiver);
    }
    
    public static void main(String[] args) {
        try {
            new App(args[0]);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        Student s = testDao();
        
    }
    
    private static Student testDao() {
        StudentDao dao = DaoFactory.getStudentDao(DaoType.JPA);
        Student s = dao.createStudent("Sammy", "Khedyra", new Date());
        return s;    
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

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseprojectPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
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