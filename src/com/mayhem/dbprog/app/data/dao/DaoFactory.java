/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mayhem.dbprog.app.data.dao;

import com.mayhem.dbprog.app.data.dao.jpa.StudentDaoJPA;

/**
 *
 * @author Carlos
 */
public class DaoFactory {
    /**
     * Gets a DAO for the entity Student.
     * @param type
     * @return
     */
    public static StudentDao getStudentDao(DaoType type) {
        switch(type) {
            case JPA :
                return new StudentDaoJPA();
        }
        return null;
    }
}
