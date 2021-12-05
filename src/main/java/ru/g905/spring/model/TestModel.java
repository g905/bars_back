/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.g905.spring.model;

import javax.persistence.*;

/**
 *
 * @author zharnikov
 */
@Entity
@Table(name = "models")
public class TestModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "cool")
    private boolean cool;
    
    @Column(name = "created_at")
    private long created_at;
    
    @Column(name = "updated_at")
    private long updated_at;
    
    @Column(name = "number")
    private String number;

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

    public boolean getCool() {
        return cool;
    }

    public void setCool(boolean cool) {
        this.cool = cool;
    }
    
    public void setCreated_at(long time) {
        this.created_at = time;
    }
    
    public long getCreated_at() {
        return this.created_at;
    }
    
    public void setUpdated_at(long time) {
        this.updated_at = time;
    }
    
    public long getUpdated_at() {
        return this.updated_at;
    }
    
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
