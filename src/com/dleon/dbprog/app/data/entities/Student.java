/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dleon.dbprog.app.data.entities;

import java.util.Date;

/**
 *
 * @author Carlos
 */
public interface Student {

    public Integer getId();

    public void setId(Integer Id);

    public String getName();

    public void setName(String name);

    public String getLastName();

    public void setLastName(String lastName);

    public Date getBirthday();

    public void setBirthday(Date birthday);
}
