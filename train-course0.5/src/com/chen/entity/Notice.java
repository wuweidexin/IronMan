package com.chen.entity;



/**
 * Notice entity. @author MyEclipse Persistence Tools
 */

public class Notice  implements java.io.Serializable {


    // Fields    

     private Integer NId;
     private String NNumber;
     private String NTitle;
     private String NContent;
     private String NTime;
     private String column6;
     private String column7;
     private String column8;


    // Constructors

    /** default constructor */
    public Notice() {
    }

    
    /** full constructor */
    public Notice(String NNumber, String NTitle, String NContent, String NTime, String column6, String column7, String column8) {
        this.NNumber = NNumber;
        this.NTitle = NTitle;
        this.NContent = NContent;
        this.NTime = NTime;
        this.column6 = column6;
        this.column7 = column7;
        this.column8 = column8;
    }

   
    // Property accessors

    public Integer getNId() {
        return this.NId;
    }
    
    public void setNId(Integer NId) {
        this.NId = NId;
    }

    public String getNNumber() {
        return this.NNumber;
    }
    
    public void setNNumber(String NNumber) {
        this.NNumber = NNumber;
    }

    public String getNTitle() {
        return this.NTitle;
    }
    
    public void setNTitle(String NTitle) {
        this.NTitle = NTitle;
    }

    public String getNContent() {
        return this.NContent;
    }
    
    public void setNContent(String NContent) {
        this.NContent = NContent;
    }

    public String getNTime() {
        return this.NTime;
    }
    
    public void setNTime(String NTime) {
        this.NTime = NTime;
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

    public String getColumn8() {
        return this.column8;
    }
    
    public void setColumn8(String column8) {
        this.column8 = column8;
    }
   








}