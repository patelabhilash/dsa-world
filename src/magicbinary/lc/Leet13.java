package magicbinary.lc;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Leet13
 */
public class Leet13 {

    public int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int indian = 0;
        int toAdd = 0;
        for (int i = 0; i < s.length(); i++) {
            toAdd = 0;
            if (s.charAt(i) == 'I') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {
                    toAdd = 4;
                    i++;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'X') {
                    toAdd = 9;
                    i++;
                } else {
                    toAdd = 1;
                }
            } else if (s.charAt(i) == 'X') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                    toAdd = 40;
                    i++;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'C') {
                    toAdd = 90;
                    i++;
                } else {
                    toAdd = 10;
                }
            } else if (s.charAt(i) == 'C') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                    toAdd = 400;
                    i++;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'M') {
                    toAdd = 900;
                    i++;
                } else {
                    toAdd = 100;
                }
            } else {
                toAdd = map.get(s.charAt(i));
            }

            indian += toAdd;
           
        }
        return indian;
    }

    public static void main(String[] args) {
        System.out.println(
                new Leet13().romanToInt("MCMXCIV"));
                Arrays.binarySearch(null, 0, 0, null, null);
    }
}