package com.interview.tpg;
public class StudentInfo{

	private Double studGPA = 0.0;
	private String studName = null;
	private Integer studID = null;
	
	StudentInfo(double studGPA,String studName,int studID){  
		this.studGPA=studGPA;  
		this.studName=studName;  
		this.studID=studID;  
		}  
	
	public Double getStudGPA() {
		return studGPA;
	}
	public void setStudGPA(Double studGPA) {
		this.studGPA = studGPA;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public Integer getStudID() {
		return studID;
	}
	public void setStudID(Integer studID) {
		this.studID = studID;
	}

    @Override
    public String toString() {
        return studName;
    }
}
