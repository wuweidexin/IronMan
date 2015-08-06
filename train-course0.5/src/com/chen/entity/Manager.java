package com.chen.entity;



/**
 * Manager entity. @author MyEclipse Persistence Tools
 */

public class Manager  implements java.io.Serializable {


    // Fields    

     private Integer MId;
     private String MNumber;
     private String MName;
     private String MPwd;
     private String column5;
     private String column6;
     private String column7;


    // Constructors

    /** default constructor */
    public Manager() {
    }

    
    /** full constructor */
    public Manager(String MNumber, String MName, String MPwd, String column5, String column6, String column7) {
        this.MNumber = MNumber;
        this.MName = MName;
        this.MPwd = MPwd;
        this.column5 = column5;
        this.column6 = column6;
        this.column7 = column7;
    }

   
    // Property accessors

    public Integer getMId() {
        return this.MId;
    }
    
    public void setMId(Integer MId) {
        this.MId = MId;
    }

    public String getMNumber() {
        return this.MNumber;
    }
    
    public void setMNumber(String MNumber) {
        this.MNumber = MNumber;
    }

    public String getMName() {
        return this.MName;
    }
    
    public void setMName(String MName) {
        this.MName = MName;
    }

    public String getMPwd() {
        return this.MPwd;
    }
    
    public void setMPwd(String MPwd) {
        this.MPwd = MPwd;
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
   








}