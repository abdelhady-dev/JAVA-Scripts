package inherit;

public class student extends person {
	String year, academicYear;
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	int marks(int ar, int math) {
		return ar + math;
	}
	
	void print() {
		super.print();
		System.out.println("========================");
		System.out.println("student");
		System.out.println("full name is : " + fName + " " + lName);
		System.out.println("gender : " + gender);
		System.out.println("age  : " + age);
		System.out.println("========================");
	}

}
