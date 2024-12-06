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
       if(isNumber(num)==true)                                           //if the number is in the valid format
           return (Integer.parseInt(splitNum(num),splitBase(num)));      //return the number as his decimal representation
       return -1;                                                        //if the number isn't in the valid format
    }
    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a)
    {
        if(equals(a,""))                                                  //check if not empty
            return false;
        if (equals(a,"1")||equals(a,"0"))                                 //check two possible ways to enter not like the format
            return true;

        boolean b=false;
        if( !equals( String.valueOf(a.charAt(a.length() - 2) ) ,"b"))     // check if it in the format
            return false;
        else
            b=true;

        int base=splitBase(a);
        String num= (String.valueOf(splitNum(a))) ;
        if((base==0)|| (num==""))                                         // check if there are values in the number & base
            return false;

        if( (base>16) || (base<2) )                                    // checks the base
            return false;

        for(int i=0;i<num.length();i++)                               //check if the number is posibble depending on the base
        {
            if (num.charAt(i)>=base)                                   //if one of them is bigger/equals-not good
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
      if((num<0)||(base>16)||(base<2))                  //check the base and the number
          return "";
        String Convert="";
        while (num>0)                                         //The loop create the num in the given base
        {
            Convert = (String.valueOf(num%base))+Convert;     //add the next number
            num=num/base;
        }

        return BuildNum(Convert,base);                          //return as: <number>b<base>
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        if (n1.equals(n2))
            return true;
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
        return Math.max(max1,max2);
    }

    // get a string and returns the number
    public static String splitNum(String num)
    {
        String[] parts = num.split("b");
        return parts[0];
    }

    public static int splitBase(String num)
    {
        String[] parts = num.split("b");
       return Integer.parseInt(parts[1]);
    }



//bulding a string that represent as needed the number and it base
    public static String BuildNum(String num,int base)
    {
        if(base==10)
            return String.valueOf(num);
        String s= num+"b"+base;
        return s;
    }
//multification of the two numbers
    public static String multi(String n1,String n2,String base) {
       String m= String.valueOf(number2Int(n1)*number2Int(n2));
       return int2Number(Integer.parseInt(m),Integer.parseInt(base));
    }

    //Connection result of the two numbers
    public static String add (String n1,String n2,String base) {
        String c= String.valueOf(number2Int(n1)+number2Int(n2));
        return int2Number(Integer.parseInt(c),Integer.parseInt(base));
    }

}