package magicbinary.lc;

import java.util.ArrayList;
import java.util.List;

public class LongestTwoDistinct {

    public static void main(String[] args) {
       // String input = "eceba";
        String input  = "aaba aabbbbcb c bbbbab";
        System.out.println(new LongestTwoDistinct().getSizeLongestSubstringTwoDistinctCharacters(input));
    }

    // aaa bbbb
    // a b a b a b
    // aaba aabbbbcb c bbbbab
    // a2 b1 a3 b3 c1 b1 c1 b4 a1 b1

    // current

    //This is good but sliding window solution is more simpler and less space taking
    int getSizeLongestSubstringTwoDistinctCharacters(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1 || s.length() == 2)
            return s.length();

        ArrayList<int[]> arrlist = new ArrayList<>();
        int count = 1;

      
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    arrlist.add(new int[]{s.charAt(i),1});
                }
                continue;
            }
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                arrlist.add(new int[]{s.charAt(i),count});
                count = 1;
            }
        }

        for (int i = 0; i < arrlist.size(); i++) {
            System.out.println(arrlist.get(i)[1]);
        }

        if (arrlist.size() <= 2) {
            int shortAnswer = 0;
            for (int i = 0; i < arrlist.size(); i++) {
                shortAnswer += arrlist.get(i)[1];
            }
            return shortAnswer;
        }

        List<Integer> twoDistinctLetters = new ArrayList<>();
        int localCount = 0;
        int maxCount = 0;
        for (int i = 1; i < arrlist.size(); i++) {
            if (twoDistinctLetters.contains(arrlist.get(i)[0])) {
                localCount += arrlist.get(i)[1];
            } else {
                twoDistinctLetters.clear();
                twoDistinctLetters.add(arrlist.get(i)[0]);
                twoDistinctLetters.add(arrlist.get(i - 1)[0]);
                localCount = arrlist.get(i)[1] + arrlist.get(i - 1)[1];
            }

            if (localCount > maxCount)
                maxCount = localCount;
        }

        return maxCount;
    }
}
