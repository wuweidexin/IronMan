package com.chen.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Classes entity. @author MyEclipse Persistence Tools
 */

public class Classes  implements java.io.Serializable {


    // Fields    

     private Integer clId;
     private Studylocation studylocation;
     private String clNo;
     private String clNumber;
     private String clName;
     private String column5;
     private String column7;
     private String column8;
     private Set stuclas = new HashSet(0);
     private Set teachers = new HashSet(0);


    // Constructors

    /** default constructor */
    public Classes() {
    }

    
    /** full constructor */
    public Classes(Studylocation studylocation, String clNo, String clNumber, String clName, String column5, String column7, String column8, Set stuclas, Set teachers) {
        this.studylocation = studylocation;
        this.clNo = clNo;
        this.clNumber = clNumber;
        this.clName = clName;
        this.column5 = column5;
        this.column7 = column7;
        this.column8 = column8;
        this.stuclas = stuclas;
        this.teachers = teachers;
    }

   
    // Property accessors

    public Integer getClId() {
        return this.clId;
    }
    
    public void setClId(Integer clId) {
        this.clId = clId;
    }

    public Studylocation getStudylocation() {
        return this.studylocation;
    }
    
    public void setStudylocation(Studylocation studylocation) {
        this.studylocation = studylocation;
    }

    public String getClNo() {
        return this.clNo;
    }
    
    public void setClNo(String clNo) {
        this.clNo = clNo;
    }

    public String getClNumber() {
        return this.clNumber;
    }
    
    public void setClNumber(String clNumber) {
        this.clNumber = clNumber;
    }

    public String getClName() {
        return this.clName;
    }
    
    public void setClName(String clName) {
        this.clName = clName;
    }

    public String getColumn5() {
        return this.column5;
    }
    
    public void setColumn5(String column5) {
        this.column5 = column5;
    }

    public String getColumn7() {
        return this.column7;
    }
    
    public void setColumn7(String column7) {
        this.column7 = column7;
    }

    public String getColumn8() {
        return this.column8;
    }
    
    public void setColumn8(String column8) {
        this.column8 = column8;
    }

    public Set getStuclas() {
        return this.stuclas;
    }
    
    public void setStuclas(Set stuclas) {
        this.stuclas = stuclas;
    }

    public Set getTeachers() {
        return this.teachers;
    }
    
    public void setTeachers(Set teachers) {
        this.teachers = teachers;
    }
   








}