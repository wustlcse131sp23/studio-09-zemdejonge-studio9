package assignment7;

//TODO: Copy a working Student class from Assignment 7 over this file.
public class Student {

	//instance var
private String firstName;
private String lastName;
private int id;
private int attemptedCredits;
private int passingCredits;
private double totalGradeQualityPoints;
private double bearBucksBalance;

//constructor
public Student(String firstName, String lastName, int id)
{
	this.firstName = firstName;
	this.lastName = lastName;
	this.id = id;
}

//returns fullName of student
public String getFullName()
{
	return this.firstName + " " + this.lastName;
}

//sets fullName
public void setFullName(String firstName, String lastName)
{
	this.firstName = firstName;
	this.lastName = lastName;
}

//gets id
public int getId()
{
	return this.id;
}



//gets attemp creds
public int getAttemptedCredits() {
	return attemptedCredits;
}

//sets attemp creds
public void setAttemptedCredits(int attemptedCredits) {
	this.attemptedCredits = attemptedCredits;
}

//gets passing creds
public int getPassingCredits() {
	return passingCredits;
}

//sets passing creds
public void setPassingCredits(int passingCredits) {
	this.passingCredits = passingCredits;
}

//calculated GPA = totalGradeQualityPoints / attemptedCredits
public double calculateGradePointAverage()
{
	return totalGradeQualityPoints / attemptedCredits;
	
}

//adds new course grade to gpa
public void submitGrade(double grade, int credits)
{
	attemptedCredits = attemptedCredits + credits;
	if (grade >= 1.7)
	{
		passingCredits += credits;
	}
	
	double newGQP =  grade * credits;
	totalGradeQualityPoints =  totalGradeQualityPoints + newGQP;
	
	}

//gets year of student using passing creds
public String getClassStanding()
{
	if (passingCredits < 30)
	{
		return "First Year";
	}
	else if (passingCredits >= 30 && passingCredits < 60)
	{
		return "Sophomore";
	}
	else if (passingCredits >= 60 && passingCredits <90)
	{
		return "Junior";
	}
	else
	{
		return "Senior";
	}
}

//used GPA and atempted credits to decide eligibility for PhiBetaKappa
public boolean isEligibleForPhiBetaKappa()
{
	if (calculateGradePointAverage() >= 3.6 && attemptedCredits >= 98)
	{
		return true;
	}
	else if (calculateGradePointAverage() >= 3.8 && attemptedCredits >= 75)
	{
		return true;
	}
	else
		return false;
}


//gets BearBucksBalance
public double getBearBucksBalance() {
	return bearBucksBalance;
}

//sets BearBucksBalance
public void setBearBucksBalance(double bearBucksBalance) {
	this.bearBucksBalance = bearBucksBalance;
}

//adds deposited bear bucks to BearBucksBalance
public void depositBearBucks(double amount)
{
	bearBucksBalance += amount;
}

//subtracts deducted bear bucks from BearBucksBalance
public void deductBearBucks(double amount)
{
	bearBucksBalance -= amount;
}

// cashes out bear bucks
// subtracts $10 administrative fee
public double cashOutBearBucks()
{
	if(bearBucksBalance <= 10)
	{
		bearBucksBalance = 0;
		return 0;
	}
	else
	{
		double tempBal = bearBucksBalance;
		bearBucksBalance = 0;
		return tempBal - 10;
	}
	
}

//creates new legacy student
//adds cashed out bear buck balance from parents
//last name is either just from this.student or a hyphenated combo of this.student and otherParent.student
 public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id)
 {
	 Student legacy = new Student(firstName, lastName, id);
	 
	 if(isHyphenated)
	 {
		legacy.lastName = this.lastName + "-" + otherParent.lastName;
	 }
	 else
	 {
		 legacy.lastName = this.lastName;
	 }
	 
	 legacy.bearBucksBalance = this.cashOutBearBucks() + otherParent.cashOutBearBucks();
	 return legacy;
	 
 }
//converts student to string
public String toString()
{
	return firstName + " " + lastName + " " + id;

}

}



