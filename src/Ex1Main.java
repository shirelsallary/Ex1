import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit))
        {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (num1.equals("quit"))                                                                   //Checks if the given number  is in a valid format
            {
               break;                                                                                   //Get out of the loop
            }

            if( !Ex1.isNumber(num1))                                                                   //Checks if the given number  is in a valid format
            {
                System.out.println("The number is not in the valid format");
            continue;                                                                                  //Eror- start over the loop
            }
            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next();
            if (num2.equals("quit"))
            {
                break;                                                                                  //Get out of the loop
            }
            if(!Ex1.isNumber(num2))                                                                     //Checks if the given number  is in a valid format
            {
                System.out.println("The number is not in the valid format");
            continue;                                                                                  //Eror- start over the loop
            }
            System.out.println("Enter a base for output: (a number [2,16]");                          //if both are in the given number
            String newBase = sc.next();
            String a=Ex1.add(num1,num2,newBase);
            String m=Ex1.multi(num1,num2,newBase);
            String[] arr={num1,num2,a,m};
                int maxIndex=Ex1.maxIndex(arr);
                   System.out.println(" Max number over ["+num1+","+num2+","+a+","+m+"] is: "+arr[maxIndex]);


        }
        System.out.println("quiting now...");
    }
}




























