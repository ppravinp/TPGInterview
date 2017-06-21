package com.interview.tpg;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TimeMeasuringTool {
	
	public static void main(String[] args) {
		List<String[]> params = new ArrayList<String[]>();
		
		//Add a new param object for a new class and method name
		String[] param1 = new String[]{"com.interview.tpg.TimeMeasuringData", "runFor10Seconds"};
		String[] param2 = new String[]{"com.interview.tpg.TimeMeasuringData", "runFor20Seconds"};
		String[] param3 = new String[]{"com.interview.tpg.TimeMeasuringData", "runFor30Seconds"};
		params.add(param1);
		params.add(param2);
		params.add(param3);
		
		findMethodExecTime(params);
	}
	
	/**
	 * Parameter values are iterated and called launchProcess method
	 * @param params
	 */
	private static void findMethodExecTime(List<String[]> params){
		for(String[] currentParam: params){
			String className  = currentParam[0];
			String methodName  = currentParam[1];
			Class<?>[] argsTypes = {};
			Object[] methArgs = {};   
			try {
				long exceutionTime = launchProcess(className, methodName, argsTypes, methArgs);
				System.out.println("Exceution of method "+methodName+" taken "+exceutionTime+" milliseconds");
			} catch (Exception exception) {
				System.out.println("Exception in findMethodExecTime "+exception.getMessage());
			}
		}
	}
	
	/**
	 * External method is called using reflections
	 * @param className
	 * @param methodName
	 * @param argsTypes
	 * @param methodArgs
	 * @return
	 * @throws Exception
	 */
	public static long launchProcess(String className, String methodName, Class<?>[] argsTypes, Object[] methodArgs)
			throws Exception {
		Class<?> processClass = Class.forName(className);
		Object process = processClass.newInstance();
		Method aMethod = process.getClass().getMethod(methodName, argsTypes);
		long startTime = System.currentTimeMillis();
		Object res = aMethod.invoke(process, methodArgs);
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	
}
