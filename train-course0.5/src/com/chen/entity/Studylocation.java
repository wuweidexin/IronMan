package com.chen.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Studylocation entity. @author MyEclipse Persistence Tools
 */

public class Studylocation  implements java.io.Serializable {


    // Fields    

     private Integer loId;
     private String loNumber;
     private String loName;
     private Integer loCapacity;
     private Integer loBeuse;
     private String column6;
     private String column7;
     private Set classeses = new HashSet(0);


    // Constructors

    /** default constructor */
    public Studylocation() {
    }

    
    /** full constructor */
    public Studylocation(String loNumber, String loName, Integer loCapacity, Integer loBeuse, String column6, String column7, Set classeses) {
        this.loNumber = loNumber;
        this.loName = loName;
        this.loCapacity = loCapacity;
        this.loBeuse = loBeuse;
        this.column6 = column6;
        this.column7 = column7;
        this.classeses = classeses;
    }

   
    // Property accessors

    public Integer getLoId() {
        return this.loId;
    }
    
    public void setLoId(Integer loId) {
        this.loId = loId;
    }

    public String getLoNumber() {
        return this.loNumber;
    }
    
    public void setLoNumber(String loNumber) {
        this.loNumber = loNumber;
    }

    public String getLoName() {
        return this.loName;
    }
    
    public void setLoName(String loName) {
        this.loName = loName;
    }

    public Integer getLoCapacity() {
        return this.loCapacity;
    }
    
    public void setLoCapacity(Integer loCapacity) {
        this.loCapacity = loCapacity;
    }

    public Integer getLoBeuse() {
        return this.loBeuse;
    }
    
    public void setLoBeuse(Integer loBeuse) {
        this.loBeuse = loBeuse;
    }

    public String getColumn6() {
        return this.column6;
    }
    
    public void setColumn6(String column6) {
        this.column6 = column6;
    }

    public String getColumn7() {
        return this.column7;
    }
    
    public void setColumn7(String column7) {
        this.column7 = column7;
    }

    public Set getClasseses() {
        return this.classeses;
    }
    
    public void setClasseses(Set classeses) {
        this.classeses = classeses;
    }
   








}