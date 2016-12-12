package com.test;

import com.model.EMP;

public class ClassDescription {

	public ClassDescription() {
	}

	public static void main(String args[]) {
		ClassDescription description = new ClassDescription();

		EMP employee = new EMP();
		employee.setDeptno(1);
		employee.setEmpno(10);
		employee.setJob("Manager");

		description.testString();
		//description.DescriptionMapper(employee);
	}
		
	public void testString(){
		String str="key =? and key=? and";	
		str.lastIndexOf("and");
		str = str.substring(0,str.lastIndexOf("and"));
		System.out.println(str);
	}
	/**
	 * for select
	 * @param obj
	 */
	public void DescriptionMapper(Object resource) {
		SQLMapper mapper = new SQLMapper(resource);
		
		String s="aaa";

	}
}
