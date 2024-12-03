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
    public static int number2Int(String num)
    {
       if(isNumber(num)==true)
           return (Integer.parseInt(int2Number(splitNum(num),splitBase(num))));
       return -1;
    }
    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a)
    {
        if(a==null)
            return false;
        boolean b=false;
        for(int i=0;i<a.length();i++)
        {
            if (a.charAt(i) == 'b')
                b = true;
        }

        if(b==false)
            return false;
        int base=splitBase(a);
        String num= (String.valueOf(splitNum(a))) ;
        if((String.valueOf(base)==null)|| (num==null))
        if( (base>16) || (base<0) )  // checks the last character
            return false;

        if (a.charAt(a.length() - 2) != 'b')
            return false;

        for(int i=0;i<num.length();i++)
        {
            if (num.charAt(i)>base)
                return false;
        }

        return true;



    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
       double convertNunber=0;
        while (num>0)
        {
            for(int i=0;i<String.valueOf(num).length();i++)
            {
                convertNunber+=( (num%10) * (Math.pow(base,i) ) );
                num=num/10;
            }
        }
        return String.valueOf(convertNunber);
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        // add your code here

        ////////////////////
        return ans;
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
        int ans = 0;
        // add your code here

        ////////////////////
        return ans;
    }

    // get a string and returns the number
    public static int splitNum(String num)
    {

        String[] parts = num.split("b");
        return Integer.parseInt(parts[0]);
    }

    public static int splitBase(String num)
    {
        String[] parts = num.split("b");
        return Integer.parseInt(parts[1]);
    }




}