package com.chen.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student  implements java.io.Serializable {


    // Fields    

     private Integer SId;
     private String SNumber;
     private String SName;
     private String SPwd;
     private String SSex;
     private String SPhone;
     private String SEducation;
     private String column10;
     private String column11;
     private String column12;
     private Set stuclas = new HashSet(0);
     private Set selectcourses = new HashSet(0);


    // Constructors

    /** default constructor */
    public Student() {
    }

    
    /** full constructor */
    public Student(String SNumber, String SName, String SPwd, String SSex, String SPhone, String SEducation, String column10, String column11, String column12, Set stuclas, Set selectcourses) {
        this.SNumber = SNumber;
        this.SName = SName;
        this.SPwd = SPwd;
        this.SSex = SSex;
        this.SPhone = SPhone;
        this.SEducation = SEducation;
        this.column10 = column10;
        this.column11 = column11;
        this.column12 = column12;
        this.stuclas = stuclas;
        this.selectcourses = selectcourses;
    }

   
    // Property accessors

    public Integer getSId() {
        return this.SId;
    }
    
    public void setSId(Integer SId) {
        this.SId = SId;
    }

    public String getSNumber() {
        return this.SNumber;
    }
    
    public void setSNumber(String SNumber) {
        this.SNumber = SNumber;
    }

    public String getSName() {
        return this.SName;
    }
    
    public void setSName(String SName) {
        this.SName = SName;
    }

    public String getSPwd() {
        return this.SPwd;
    }
    
    public void setSPwd(String SPwd) {
        this.SPwd = SPwd;
    }

    public String getSSex() {
        return this.SSex;
    }
    
    public void setSSex(String SSex) {
        this.SSex = SSex;
    }

    public String getSPhone() {
        return this.SPhone;
    }
    
    public void setSPhone(String SPhone) {
        this.SPhone = SPhone;
    }

    public String getSEducation() {
        return this.SEducation;
    }
    
    public void setSEducation(String SEducation) {
        this.SEducation = SEducation;
    }

    public String getColumn10() {
        return this.column10;
    }
    
    public void setColumn10(String column10) {
        this.column10 = column10;
    }

    public String getColumn11() {
        return this.column11;
    }
    
    public void setColumn11(String column11) {
        this.column11 = column11;
    }

    public String getColumn12() {
        return this.column12;
    }
    
    public void setColumn12(String column12) {
        this.column12 = column12;
    }

    public Set getStuclas() {
        return this.stuclas;
    }
    
    public void setStuclas(Set stuclas) {
        this.stuclas = stuclas;
    }

    public Set getSelectcourses() {
        return this.selectcourses;
    }
    
    public void setSelectcourses(Set selectcourses) {
        this.selectcourses = selectcourses;
    }
   








}