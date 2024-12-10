/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1
{
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num)
    {
        if(isNumber(num))
        {
             String[] arr=num.split("b") ;
                if (arr.length==1)
                    return Integer.parseInt(num);//10 base

            int base=baseSwitch(arr[0]);
            int n=numSwitch(arr[1]);
            return Integer.parseInt(String.valueOf(n),base);
        }
        return -1;
    }
    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        if (a == null) {
            return false;          //check if not empty
        }

        if (!a.contains("b"))   //10 base
        {
            if(checkDigit(a)==true)
                return true;
            else return false;

        }
        if (a.charAt(a.length() - 2) == 'b') //if the b is in the right place
        {
            String[] nums = a.split("b");

            if (nums.length !=2)// if there are values on both sides of b
            {
                return false; // if not
            }

            int base2;
            int num2;
            if(!checkDigit(nums[1]))
                base2=baseSwitch(nums[1]);
            else
                base2=Integer.parseInt(nums[1]);

            if((base2==-1))
                return false;

            for(int i=0;i<nums[0].length();i++)                               //check if the number is posibble depending on the base
            {
                num2=(numSwitch(String.valueOf(nums[0].charAt(i))));
                if (num2==-1)
                    return false;
                if(num2>=base2)
                    return false;                                  //if one of them is bigger/equals-not good
            }
            return true;
        }
        return false;
    }

            /**
             * Calculate the number representation (in basis base)
             * of the given natural number (represented as an integer).
             * If num<0 or base is not in [2,16] the function should return "" (the empty String).
             * @param num the natural number (include 0).
             * @param base the basis [2,16]
             * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
             */
            public static String int2Number( int num,int base)
            {
                String Convert = "";
                if (isNumber(String.valueOf(num))) {
                    while (num > 0)                                         //The loop create the num in the given base
                    {
                        Convert = (String.valueOf(num % base)) + Convert;     //add the next number
                        num = num / base;
                    }
                }
                return Convert;
            }

            /**
             * Checks if the two numbers have the same value.
             * @param n1 first number
             * @param n2 second number
             * @return true iff the two numbers have the same values.
             */
            public static boolean equals (String n1, String n2){
            return number2Int(n1)==number2Int(n2);
            }

         /*   /**
             * This static function search for the array index with the largest number (in value).
             * In case there are more than one maximum - returns the first index.
             * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
             * @param arr an array of numbers
             * @return the index in the array in with the largest number (in value).
             *
             */





    public static boolean checkDigit (String n) {
        for (int i = 0; i < n.length(); i++) {
            if (!Character.isDigit(n.charAt(i)))
                return false;
        }
        return true;
    }


    public static int numSwitch(String num) {
        int n = -1;
        if(Character.isDigit(Integer.parseInt(num))) {
            if(num.equals("2")) return 2;
            if(num.equals("3")) return 3;
            if(num.equals("4")) return 4;
            if(num.equals("5")) return 5;
            if(num.equals("6")) return 6;
            if(num.equals("7")) return 7;
            if(num.equals("8")) return 8;
            if(num.equals("9")) return 9;

        }
        if(num.equals("A")) return 10;
        if(num.equals("B")) return 11;
        if(num.equals("C")) return 12;
        if(num.equals("D")) return 13;
        if(num.equals("E")) return 14;
        if(num.equals("F")) return 15;

        return n;
    }

    public static int baseSwitch(String num){
        int n = -1;
        if(num.equals("2")) return 2;
        if(num.equals("3")) return 3;
        if(num.equals("4")) return 4;
        if(num.equals("5")) return 5;
        if(num.equals("6")) return 6;
        if(num.equals("7")) return 7;
        if(num.equals("8")) return 8;
        if(num.equals("9")) return 9;
        if(num.equals("A")) return 10;
        if(num.equals("B")) return 11;
        if(num.equals("C")) return 12;
        if(num.equals("D")) return 13;
        if(num.equals("E")) return 14;
        if(num.equals("F")) return 15;
        if(num.equals("G")) return 16;

        return n;

    }


}



