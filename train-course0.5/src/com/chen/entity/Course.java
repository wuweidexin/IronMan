package com.chen.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course  implements java.io.Serializable {


    // Fields    

     private Integer CId;
     private String CNumber;
     private String CName;
     private String CTime;
     private String column5;
     private String column6;
     private String column9;
     private Set teachers = new HashSet(0);
     private Set selectcourses = new HashSet(0);


    // Constructors

    /** default constructor */
    public Course() {
    }

    
    /** full constructor */
    public Course(String CNumber, String CName, String CTime, String column5, String column6, String column9, Set teachers, Set selectcourses) {
        this.CNumber = CNumber;
        this.CName = CName;
        this.CTime = CTime;
        this.column5 = column5;
        this.column6 = column6;
        this.column9 = column9;
        this.teachers = teachers;
        this.selectcourses = selectcourses;
    }

   
    // Property accessors

    public Integer getCId() {
        return this.CId;
    }
    
    public void setCId(Integer CId) {
        this.CId = CId;
    }

    public String getCNumber() {
        return this.CNumber;
    }
    
    public void setCNumber(String CNumber) {
        this.CNumber = CNumber;
    }

    public String getCName() {
        return this.CName;
    }
    
    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCTime() {
        return this.CTime;
    }
    
    public void setCTime(String CTime) {
        this.CTime = CTime;
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

    public String getColumn9() {
        return this.column9;
    }
    
    public void setColumn9(String column9) {
        this.column9 = column9;
    }

    public Set getTeachers() {
        return this.teachers;
    }
    
    public void setTeachers(Set teachers) {
        this.teachers = teachers;
    }

    public Set getSelectcourses() {
        return this.selectcourses;
    }
    
    public void setSelectcourses(Set selectcourses) {
        this.selectcourses = selectcourses;
    }
   








}