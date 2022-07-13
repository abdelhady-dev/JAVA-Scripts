package inherit;

import java.util.Scanner;

public class home {

	public home() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("enter your frist name : ");
		@SuppressWarnings("resource")
		Scanner s1 = new Scanner(System.in);
		String f = s1.next();
		System.out.println("enter your last name : ");
		@SuppressWarnings("resource")
		Scanner s2 = new Scanner(System.in);
		String l = s2.next();
		System.out.println("enter your gender : ");
		@SuppressWarnings("resource")
		Scanner s3 = new Scanner(System.in);
		String g = s3.next();
		System.out.println("enter yohur age : ");
		@SuppressWarnings("resource")
		Scanner s4 = new Scanner(System.in);
		double a = s4.nextDouble();
		
		person p = new person(f, l, g, a);
		student s = new student();
		s.fName = p.fName;
		s.lName = p.lName;
		s.gender = p.gender;
		s.age = p.age;
		s.print();
	}

}
