package com.interview.tpg;
import java.util.Comparator;

public class StudentSortingComparator implements Comparator<StudentInfo>{

	public int compare(StudentInfo studentInfo1, StudentInfo studentInfo2) {
		 
        int compareStudGPA = studentInfo2.getStudGPA().compareTo(studentInfo1.getStudGPA());
        int compareStudName = studentInfo1.getStudName().compareTo(studentInfo2.getStudName());
        int compareStudID = studentInfo1.getStudID().compareTo(studentInfo2.getStudID());
 
        if(compareStudGPA == 0) {
            return ((compareStudName == 0) ? compareStudID : compareStudName);
        }
        else {
            return compareStudGPA;
        }
    }
}
