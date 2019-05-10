/* 
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * Difficulty: Easy
 * Date: May 10, 2019
 * https://leetcode.com/problems/roman-to-integer/submissions/
 */
class RomanToInteger {
    /* Note that in Roman Numeral you'd never put a smaller 
     * char before a bigger char unless you're going to subtract it. 
     */
    public int romanToInt(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int value = getValue(s.charAt(i)); 
            if (i < s.length() - 1 && getValue(s.charAt(i+1)) > value) {
                result -= value;
            } else {
                result += value;
            }
        }
        return result;
    }

    
    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}

