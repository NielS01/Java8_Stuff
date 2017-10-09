package com.niels.tute.lambda;

public class Person {
	private String name;
	private Integer age;
	private String job;
	
	private static final Integer UNKNOWN_AGE = -1;
	
	Person(String line, String separator)
	{
		if (line != null) {
			String[] fields = line.split(separator);
			
			name = fields[0].replace("-", "");
			setAge(fields[1]);			
			job = fields[2].replace("\"", ""); // remove double quotes 

		}

	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setAge(String age) {
		try {
			this.age = Integer.parseInt(age);
		} catch (NumberFormatException e) {
			this.age = UNKNOWN_AGE;
		}
		
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
}
