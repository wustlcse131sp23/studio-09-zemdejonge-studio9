package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions
	private final Map<String,Student> data;
	
	public UniversityDatabase() {
		Map<String,Student> data = new HashMap<>();
		this.data=data;
	}
	
	public UniversityDatabase(Map<String,Student> data) {
		this.data = data;
	}
	
	
	public void addStudent(String accountName, Student student) {
		data.put(accountName, student);
	}

	public int getStudentCount() {
		return data.size();
	}

	public String lookupFullName(String accountName) {
		if (data.get(accountName)==null) {
			return null;
		}
		else {
		return data.get(accountName).getFullName();
		}
	}

	public double getTotalBearBucks() {
		double bearBucks = 0;
		for (String name : data.keySet()) {
			bearBucks = bearBucks + data.get(name).getBearBucksBalance();
		}
		return bearBucks;
	}
}
