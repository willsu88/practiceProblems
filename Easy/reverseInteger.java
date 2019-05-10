
/* Given a 32-bit signed integer, reverse digits of an integer.
 * Assume we are dealing with an environment which could only store integers 
 * within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose 
 * of this problem, assume that your function returns 0 when the reversed integer 
 * overflows.
 * Difficulty: Easy
 * Date: May 10, 2019
 * https://leetcode.com/problems/reverse-integer/submissions/
 */

class ReverseInteger {
    public int reverse(int x) {
    
        int result = 0;
        int curr = x; // Don't modify input.
        while (curr !=0) {
            int digit = curr % 10; //Pop digit.
            curr = curr / 10;      //Get next iteration.
            
            /* Check for overflows.*/
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && digit > 7)) 
                return 0; //(2^31 - 1 = 2147483647) that's where the 7 comes from.
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && digit < -8)) 
                return 0;  //(-2^31= -2147483648) that's where the -8 comes from.
            
            /* Add digit to our result. */
            result = (result * 10) + digit;
        }
        
        return result;
        
    }
}