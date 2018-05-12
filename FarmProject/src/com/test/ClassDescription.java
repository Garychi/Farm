package com.test;


import com.it.utils.SQLMapper;


public class ClassDescription {
//	private final static Logger log = Logger.getLogger(ClassDescription.class);
	public ClassDescription() {
	}

	public static void main(String args[]) {
		ClassDescription description = new ClassDescription();
//		log.info("aa");
//		EMP employee = new EMP();
//		employee.setDeptno(1);
//		employee.setEmpno(10);
//		employee.setJob("Manager");

//		description.testString();
		//description.DescriptionMapper(employee);
	}
	
	public static void test(){
		
		
	}
	
	public void testString(){
		String str="key =? and key=? and";	
		str.lastIndexOf("and");
		str = str.substring(0,str.lastIndexOf("and"));
		System.out.println(str);
	}
	/**
	 * for select
	 * @param resource
	 */
	public void DescriptionMapper(Object resource) {
		SQLMapper mapper = new SQLMapper(resource);
		
		String s="aaa";

	}
}
