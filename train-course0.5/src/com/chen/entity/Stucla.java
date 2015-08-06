package com.chen.entity;



/**
 * Stucla entity. @author MyEclipse Persistence Tools
 */

public class Stucla  implements java.io.Serializable {


    // Fields    

     private Integer sclaId;
     private Classes classes;
     private Student student;
     private String column4;
     private String column5;


    // Constructors

    /** default constructor */
    public Stucla() {
    }

    
    /** full constructor */
    public Stucla(Classes classes, Student student, String column4, String column5) {
        this.classes = classes;
        this.student = student;
        this.column4 = column4;
        this.column5 = column5;
    }

   
    // Property accessors

    public Integer getSclaId() {
        return this.sclaId;
    }
    
    public void setSclaId(Integer sclaId) {
        this.sclaId = sclaId;
    }

    public Classes getClasses() {
        return this.classes;
    }
    
    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }

    public String getColumn4() {
        return this.column4;
    }
    
    public void setColumn4(String column4) {
        this.column4 = column4;
    }

    public String getColumn5() {
        return this.column5;
    }
    
    public void setColumn5(String column5) {
        this.column5 = column5;
    }
   








}