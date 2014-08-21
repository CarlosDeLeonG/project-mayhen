/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mayhem.dbprog.app.data.dao;

import com.mayhem.dbprog.app.data.entities.Student;
import com.mayhem.dbprog.messages.MessageProducer;
import java.util.Date;

/**
 *
 * @author Carlos
 */
public interface StudentDao extends MessageProducer {
    public Student createStudent(String name, String lastName, Date birthday);
}
