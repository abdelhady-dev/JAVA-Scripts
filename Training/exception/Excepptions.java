/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepptions;

/**
 *
 * @author hadys
 */
public class Excepptions {

    /**
     * @param args the command line arguments
     */
    // throw exception
     void checkAge(int age){  
	if(age<18)  
	   throw new ArithmeticException("Not Eligible for voting");  
	else  
	   System.out.println("Eligible for voting");  
    }
    // throws exception
    int division(int a, int b) throws ArithmeticException
    { return a/b; }
    
    public static void main(String[] args) {
        // throw exception
         Excepptions obj = new Excepptions();
         // throw exception
        obj.checkAge(18);

        // throws exception
        try {
            System.out.println(obj.division(5, 0));
        } catch (ArithmeticException e) {
            System.out.println("don't divid by zero!!");
        }
        System.out.println("End Of Program");
    }
    
}
