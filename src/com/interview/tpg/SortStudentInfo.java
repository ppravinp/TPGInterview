package com.interview.tpg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortStudentInfo {

	public static void main(String[] args) {
		SortStudentInfo sortStudentInfo = new SortStudentInfo();
		sortStudentInfo.loadStudentInfo();
		
	}
	
	private List<StudentInfo> loadStudentInfo(){
		List<StudentInfo> lstStudentInfo = null;
		try{
			lstStudentInfo = new ArrayList<StudentInfo>();
			
			StudentInfo studentInfo1 = new StudentInfo(3.68, "Tina", 33);
			StudentInfo studentInfo2 = new StudentInfo(3.85, "Louis", 85);
			StudentInfo studentInfo3 = new StudentInfo(3.75, "Samil", 56);
			StudentInfo studentInfo4 = new StudentInfo(3.75, "Samar", 19);
			StudentInfo studentInfo5 = new StudentInfo(3.76, "Lorry", 22);
			
			lstStudentInfo.add(studentInfo1);
			lstStudentInfo.add(studentInfo2);
			lstStudentInfo.add(studentInfo3);
			lstStudentInfo.add(studentInfo4);
			lstStudentInfo.add(studentInfo5);
	 
	        Collections.sort(lstStudentInfo, new StudentSortingComparator());
	 
	        //After Sorting
	        System.out.println("\n\n Sample Output\n");
	        for(StudentInfo customer : lstStudentInfo) {
	            System.out.println(customer);
	        }
		}catch(Exception exception){
			System.out.println("Exception in loadStudentInfo "+exception.getMessage());
		}
		return lstStudentInfo;
	}
}
