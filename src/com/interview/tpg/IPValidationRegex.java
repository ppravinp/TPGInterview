package com.interview.tpg;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class IPValidationRegex {
	private static final String FILENAME = "/src/ipaddress.txt";

	public static void main(String[] args) {
		BufferedReader bufferedReader = null;
		String currentIpAddress = null;
		int index = 0;
		boolean validation = true;
		try {
			String filePath = new File("").getAbsolutePath();
			bufferedReader = new BufferedReader(new FileReader(filePath + FILENAME));
			String sCurrentLine;
			while ((sCurrentLine = bufferedReader.readLine()) != null) {
				currentIpAddress = sCurrentLine;
				if(currentIpAddress.contains(".")){
					StringTokenizer stringTokenizer = new StringTokenizer(currentIpAddress,".");
					index = 0;
					validation = true;
					while (stringTokenizer.hasMoreTokens()) {  
						if(!validateIpAddress(currentIpAddress,  stringTokenizer.nextToken())){
							validation = false;
							break;
						}
						//To count the no of values in each ipaddress block
						index++;
					}
				}else{
					System.out.println("The IP Address: "+currentIpAddress+" is invalid as it is not in the form A.B.C.D");
				}
				if(validation && index != 4){
					System.out.println("The IP Address: "+currentIpAddress+" is invalid as it is not in the form A.B.C.D");
				}
			}

		} catch (IOException e) {
			System.out.println("Exception during accessing the file");
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
			} catch (IOException ex) {
				System.out.println("Exception during closing the file resources");
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * Method to find a string value is numeric
	 * @param value
	 * @return
	 */
	public static boolean isNumeric(String value) {
		try {
			double doubleVale = Double.parseDouble(value);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	/**
	 * Method to check the length of the given value
	 * @param value
	 * @return
	 */
	public static boolean checkLength(String value){
		if(value.length() < 4){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Method to check the maximum value is 255
	 * @param value
	 * @return
	 */
	public static boolean checkMaxValue(String value){
		try {
			double doubleVal = Double.parseDouble(value);
			if(doubleVal > 255){
				return false;	
			}
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	/**
	 * Validation of each number in an IP Address
	 * @param ipAddress
	 * @param value
	 * @return
	 */
	public static boolean validateIpAddress(String ipAddress, String value){
		boolean validateIpAddress = false;
		try{
			if(isNumeric(value)){
				if(checkLength(value)){
					if(checkMaxValue(value)){
						validateIpAddress = true;
					}else{
						System.out.println("The IP Address: "+ipAddress+" is invalid as range is greater than 255");
					}
				}else{
					System.out.println("The IP Address: "+ipAddress+" is invalid as its length is greater than 3");
				}
			}else{
				System.out.println("The IP Address: "+ipAddress+" is invalid as it has Non-numeric value");
			}
		}catch(Exception exception){
			System.out.println("Exception occured in validateIpAddress "+exception.getMessage());
		}
		return validateIpAddress;
	}
}
