package hady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class print {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * car m = new car(); m.hello();
		 */
		InputStreamReader str = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(str);
		String userName = br.readLine();
		System.out.println("the user name is : " + userName);
		

	}

}
