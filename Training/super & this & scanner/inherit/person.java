/**
 * by : hadys
 */
package inherit;

/**
 * @author abdelhady
 *
 */
public class person {
	String fName, lName, gender;
	double age;
	/**
	 * 
	 */
	public person() {
		// TODO Auto-generated constructor stub
		System.out.println("welcome from parent");
	}
	
	public person(String fName, String lName, String gender, double age) {
		// TODO Auto-generated constructor stub
		this.fName = fName ;
		this.lName = lName ;
		this.gender = gender ;
		this.age = age ;
	}

	void print() {
		System.out.println("========================");
		System.out.println("person");
		System.out.println("full name is : " + fName + " " + lName);
		System.out.println("gender : " + gender);
		System.out.println("age  : " + age);
		System.out.println("========================");
	}
	
}
