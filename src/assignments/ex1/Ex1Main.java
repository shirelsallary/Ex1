package assignments.ex1;
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
            if (!num1.equals("quit"))
            {
               break;
            }

            if(isNumber(num1)==-1)
            {
                System.out.println("The number is not in the valid format");
            continue;
            }
            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next();
            if (!num2.equals("quit"))
            {
                break;
            }
            if(isNumber(num2)==-1)
            {
                System.out.println("The number is not in the valid format");
            continue;
            }
System.out.println("Enter a base for output: (a number [2,16]");
            String newBase = "";
            newBase = sc.next();
            String a=add(num1,num2,newBase);
            System m=multi(num1,num2,newBase);
            String[] arr={num1,num2,a,m};
            int max=maxIndex(arr);
                   System.out.println(" Max number over ["+num1+","+num2+","+a+","+m+"] is: "+max);
        }
        System.out.println("quiting now...");
    }
}




























