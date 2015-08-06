package com.chen.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher  implements java.io.Serializable {


    // Fields    

     private Integer TId;
     private Classes classes;
     private Course course;
     private String TNumber;
     private String TName;
     private String TSex;
     private String column5;
     private String column6;
     private String column7;
     private Set selectcourses = new HashSet(0);


    // Constructors

    /** default constructor */
    public Teacher() {
    }

    
    /** full constructor */
    public Teacher(Classes classes, Course course, String TNumber, String TName, String TSex, String column5, String column6, String column7, Set selectcourses) {
        this.classes = classes;
        this.course = course;
        this.TNumber = TNumber;
        this.TName = TName;
        this.TSex = TSex;
        this.column5 = column5;
        this.column6 = column6;
        this.column7 = column7;
        this.selectcourses = selectcourses;
    }

   
    // Property accessors

    public Integer getTId() {
        return this.TId;
    }
    
    public void setTId(Integer TId) {
        this.TId = TId;
    }

    public Classes getClasses() {
        return this.classes;
    }
    
    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }

    public String getTNumber() {
        return this.TNumber;
    }
    
    public void setTNumber(String TNumber) {
        this.TNumber = TNumber;
    }

    public String getTName() {
        return this.TName;
    }
    
    public void setTName(String TName) {
        this.TName = TName;
    }

    public String getTSex() {
        return this.TSex;
    }
    
    public void setTSex(String TSex) {
        this.TSex = TSex;
    }

    public String getColumn5() {
        return this.column5;
    }
    
    public void setColumn5(String column5) {
        this.column5 = column5;
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

    public Set getSelectcourses() {
        return this.selectcourses;
    }
    
    public void setSelectcourses(Set selectcourses) {
        this.selectcourses = selectcourses;
    }
   








}