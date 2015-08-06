package com.cissst.entity;

/**
 * TbProblemAudit entity. @author MyEclipse Persistence Tools
 */

public class TbProblemAudit implements java.io.Serializable {

	// Fields

	private Integer paId;
	private TbUser tbUser;
	private TbProblem tbProblem;
	private String paTime;
	private String paComplaint;
	private String paDel;
	private String col1;
	private String col2;
	private String col3;

	// Constructors

	/** default constructor */
	public TbProblemAudit() {
	}

	/** full constructor */
	public TbProblemAudit(TbUser tbUser, TbProblem tbProblem, String paTime,
			String paComplaint, String paDel, String col1, String col2,
			String col3) {
		this.tbUser = tbUser;
		this.tbProblem = tbProblem;
		this.paTime = paTime;
		this.paComplaint = paComplaint;
		this.paDel = paDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
	}

	// Property accessors

	public Integer getPaId() {
		return this.paId;
	}

	public void setPaId(Integer paId) {
		this.paId = paId;
	}

	public TbUser getTbUser() {
		return this.tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public TbProblem getTbProblem() {
		return this.tbProblem;
	}

	public void setTbProblem(TbProblem tbProblem) {
		this.tbProblem = tbProblem;
	}

	public String getPaTime() {
		return this.paTime;
	}

	public void setPaTime(String paTime) {
		this.paTime = paTime;
	}

	public String getPaComplaint() {
		return this.paComplaint;
	}

	public void setPaComplaint(String paComplaint) {
		this.paComplaint = paComplaint;
	}

	public String getPaDel() {
		return this.paDel;
	}

	public void setPaDel(String paDel) {
		this.paDel = paDel;
	}

	public String getCol1() {
		return this.col1;
	}

	public void setCol1(String col1) {
		this.col1 = col1;
	}

	public String getCol2() {
		return this.col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2;
	}

	public String getCol3() {
		return this.col3;
	}

	public void setCol3(String col3) {
		this.col3 = col3;
	}

}