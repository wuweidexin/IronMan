package com.chen.entity;



/**
 * Selectcourse entity. @author MyEclipse Persistence Tools
 */

public class Selectcourse  implements java.io.Serializable {


    // Fields    

     private Integer scId;
     private Teacher teacher;
     private Course course;
     private Student student;
     private String column2;
     private String column3;
     private String column7;


    // Constructors

    /** default constructor */
    public Selectcourse() {
    }

    
    /** full constructor */
    public Selectcourse(Teacher teacher, Course course, Student student, String column2, String column3, String column7) {
        this.teacher = teacher;
        this.course = course;
        this.student = student;
        this.column2 = column2;
        this.column3 = column3;
        this.column7 = column7;
    }

   
    // Property accessors

    public Integer getScId() {
        return this.scId;
    }
    
    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }
    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }

    public String getColumn2() {
        return this.column2;
    }
    
    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public String getColumn3() {
        return this.column3;
    }
    
    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    public String getColumn7() {
        return this.column7;
    }
    
    public void setColumn7(String column7) {
        this.column7 = column7;
    }
   








}