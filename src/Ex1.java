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
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        if (isNumber(num)) {   // Check if the input is a valid number format
            if (!num.contains("b")) { //If the number is not 10 base
                return Integer.parseInt(num);
            }
            String[] arr = num.split("b");  // Split number and base
            int base = baseSwitch(arr[1]);         // Get the base value
            if (base==10)
                return Integer.parseInt(arr[0]);
            int numR = 0;
            int countPow = 0;
            String n = arr[0];
            while(!n.isEmpty()) {
                numR += ( (numSwitch(String.valueOf(n.charAt(n.length()-1)))) * ( Math.pow(base, countPow) ) );
                n=n.substring(0,n.length()-1);
                countPow++;
            }
            return numR;
        }
        return -1; // If the number is not in the valid format
    }
    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        if (a.isEmpty()) {
            return false;          // Input should not be empty
        }

        if (!a.contains("b"))   //10 base
        {
            return checkDigit(a);// Return if a is only digits
        }
        String[] nums = a.split("b");
        if (nums.length != 2)// If there are values on both sides of b
        {
            return false; // If not
        }
        if (baseSwitch(nums[1])==10)
            return true;
        if (a.charAt(a.length() - 2) == 'b') // Check if "b" is correctly positioned
        {

            if ((nums[0].isEmpty()) )// Number part must not be empty
            {return false;}


            int base2;
            int num2;
            if (!checkDigit(nums[1])){ //If contains only digit
                base2 = baseSwitch(nums[1]);
            }

            else{
                base2 = Integer.parseInt(nums[1]);
                if((base2>10)||(base2<2))
                    return false;
            }

            if ((base2 == -1))
                return false; // Invalid base


            for (int i = 0; i < nums[0].length(); i++)//Check if the number is posibble depending on the base
            {
                num2 = (numSwitch(String.valueOf(nums[0].charAt(i))));
                if (num2 == -1 || num2 >= base2)
                    return false;  //if one of them is bigger/equals-not good
            }
            return true;
        }
        return false;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     *
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String Convert = "";
        if((num>=0)&&(base>1)&&(base<17)){

                while (num >0)  //The loop create the num in the given base
                {
                    if (base > 9)
                    {
                        if (num % base == 10) {
                            Convert = "A" + Convert;
                            num = num / base;
                            continue;
                        }
                        if (num % base == 11) {
                            Convert = "B" + Convert;
                            num = num / base;
                            continue;
                        }
                        if (num % base == 12) {
                            Convert = "C" + Convert;
                            num = num / base;
                            continue;
                        }
                        if (num % base == 13) {
                            Convert = "D" + Convert;
                            num = num / base;
                            continue;
                        }
                        if (num % base == 14) {
                            Convert = "E" + Convert;
                            num = num / base;
                            continue;
                        }
                        if (num % base == 15) {
                            Convert = "F" + Convert;
                            num = num / base;
                            continue;
                        }

                    }
                    Convert = (numSwitch(String.valueOf(num % base))) + Convert;
                    num = num / base;
                }
            String b2= String.valueOf(base);
            if (base>9)
            {
                if(base==10) b2 = "A";
                else if(base==11) b2 = "B";
                else if(base==12) b2 = "C";
                else if(base==13) b2 = "D";
                else if(base==14) b2 = "E";
                else if(base==15) b2 = "F";
                else if(base==16) b2 = "G";
            }
            if (Convert.equals("")) Convert = "0";
            return Convert+"b"+b2;
        }
        return Convert;
    }

    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        return number2Int(n1) == number2Int(n2);
    }

    /*   /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (number2Int(arr[i]) > max)//If the current value is bigger than the max
            {
                max = number2Int(arr[i]);//Put it as the max
                maxIndex = i;
            }
        }
        return maxIndex;
    }

// Checks if all the chars in the string are digits
    public static boolean checkDigit(String n) {
        for (int i = 0; i < n.length(); i++) { //Checks for every char in the string
            if (!Character.isDigit(n.charAt(i)))
                return false;//If it finds a char that isn't a digit
        }
        return true;
    }
   // Return the numeric value, or -1 if invalid
    public static int numSwitch(String num) {
        int n = -1;

        if (num.equals("0")) return 0;
        if (num.equals("1")) return 1;
        if (num.equals("2")) return 2;
        if (num.equals("3")) return 3;
        if (num.equals("4")) return 4;
        if (num.equals("5")) return 5;
        if (num.equals("6")) return 6;
        if (num.equals("7")) return 7;
        if (num.equals("8")) return 8;
        if (num.equals("9")) return 9;
        if(num.equals("10")) return 10;
        if (num.equals("A")) return 10;
        if (num.equals("B")) return 11;
        if (num.equals("C")) return 12;
        if (num.equals("D")) return 13;
        if (num.equals("E")) return 14;
        if (num.equals("F")) return 15;

        return n;
    }
    // return the numeric value of the base, or -1 if invalid
    public static int baseSwitch(String num) {
        int n = -1;
        if (num.equals("2")) return 2;
        if (num.equals("3")) return 3;
        if (num.equals("4")) return 4;
        if (num.equals("5")) return 5;
        if (num.equals("6")) return 6;
        if (num.equals("7")) return 7;
        if (num.equals("8")) return 8;
        if (num.equals("9")) return 9;
        if(num.equals("10")) return 10;

        if (num.equals("A")) return 10;
        if (num.equals("B")) return 11;
        if (num.equals("C")) return 12;
        if (num.equals("D")) return 13;
        if (num.equals("E")) return 14;
        if (num.equals("F")) return 15;
        if (num.equals("G")) return 16;

        return n;

    }

    // Multiplies two numbers (n1 and n2) and represents the result in the specified base.
    public static String multi(String n1, String n2, String base) {
        String m = String.valueOf(number2Int(n1) * number2Int(n2));// Multiply in decimal
        return int2Number(Integer.parseInt(m),Integer.parseInt(base));    }

    //Adds two numbers (n1 and n2) and represents the result in the specified base.
    public static String add(String n1, String n2, String base) {
        String c = String.valueOf(number2Int(n1) + number2Int(n2));// Add in decimal
        return int2Number(Integer.parseInt(c),Integer.parseInt(base));
    }


}



