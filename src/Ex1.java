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
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        if(isNumber(num)==true) {
             String[] arr=num.split("b") ;
                if (arr.length==1)
                    return Integer.parseInt(num);
            return (Integer.parseInt(arr[0],Integer.parseInt(arr[1])));      //return the number as his decimal representation
        }
        return -1;
    }
    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        if (a == null)
            return false;          //check if not empty

        if (!a.contains("b"))   //10 base
            return true;
        else if (a.charAt(a.length() - 2) == 'b') //if the b is in the right place
        {
            String[] nums = a.split("b");
            if (nums.length < 3)// if there are values on both sides of b
                return false;// if not
            if (Integer.parseInt(nums[1]) < 0)
                return false;
            if (Integer.parseInt(nums[1]) < 10)// if the base is number
            {
                int base = Integer.parseInt(nums[1]);

                for (int i = 0; i < nums[0].length(); i++)      //check if the number is posibble depending on the base
                {
                    if (nums[0].charAt(i) >= base)        //if one of them is bigger/equals-not good
                        return false;
                }
            } else if (((Integer.parseInt(nums[1]) - 54) < 17) && ((Integer.parseInt(nums[1]) - 54) > 10)) {
                int base = Integer.parseInt(nums[1]) - 54;

                for (int i = 0; i < nums[0].length(); i++)      //check if the number is posibble depending on the base
                {
                    if (nums[0].charAt(i) >= base)        //if one of them is bigger/equals-not good
                        return false;
                }
            } else {
                return false;
            }
            return true;

        }
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base)
        {
            String Convert = "";
            while (num > 0)                                         //The loop create the num in the given base
            {
                Convert = (String.valueOf(num % base)) + Convert;     //add the next number
                num = num / base;
            }
            return Convert;
        }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        if (n1.equals(n2))
            return true;                                    //if they are equals
        return false;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int n1=number2Int(arr[0]);           //converting all the numbers to a decimal representation
        int n2=number2Int(arr[1]);
        int n3=number2Int(arr[2]);
        int n4=number2Int(arr[3]);
        int max1 = Math.max(n1,n2);
        int max2 = Math.max(n3,n4);
        return Math.max(max1,max2);               //return the max value out of the 4 numbers
    }







}

