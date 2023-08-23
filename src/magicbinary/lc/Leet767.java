package magicbinary.lc;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Leet767 {

    public String reorganizeStringPQ(String s) {
        if (s == null || s.length() == 0)
            return "";
        StringBuilder ans = new StringBuilder();
        Map<Character, Long> map = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        PriorityQueue<Character> pq = new PriorityQueue<>(Comparator.comparing(c -> map.get(c)).reversed());
        map.keySet().forEach(x -> pq.offer(x));
        long aval, bval, tempval;
        char achar, bchar, tempchar;
        while (pq.size() > 1) {
            achar = pq.poll();
            aval = map.get(achar);

            bchar = pq.poll();
            bval = map.get(bchar);

            if (aval > 0) {
                ans.append(achar);
                map.put(achar, --aval);
            }
            if (aval > 0)
                pq.offer(achar);

            if (bval > 0) {
                ans.append(bchar);
                map.put(bchar, --bval);
            }
            if (bval > 0)
                pq.offer(bchar);
        }

        if (pq.size() == 1) {
            tempchar = pq.poll();
            tempval = map.get(tempchar);
            if (tempval > 2)
                return "";
            if (tempval == 2) {
                if (ans.charAt(0) != tempchar) {
                    ans.insert(0, tempchar);
                    ans.append(tempchar);
                } else {
                    return "";
                }
            }
            if (tempval < 2) {
                ans.append(tempchar);
            }
        }
        return ans.toString();
    }

    public String reorganizeString(String s) {
        //write with odd even approach
        //instead of hashmap use arr[26];

        if (s == null || s.length() == 0)
        return "";
        char[] ans = new char[s.length()];
        int[] charCounts = new int[26];
        int maxCount = 0;
        char maxChar = 'a';
        for(char x: s.toCharArray()){
            ++charCounts[x-'a'];
            if(charCounts[x-'a']> maxCount){
                maxCount = charCounts[x-'a'];
                maxChar = (char)x;
            }
        }

        if(maxCount> (s.length()+1)/2) return "";

        int i =0;
        while(charCounts[maxChar-'a']>0){
            ans[i] = maxChar;
            i = i+2;
            charCounts[maxChar-'a']--;
        }

        // Place rest of the letters in any order
        for (int j = 0; j < charCounts.length; j++) {
            while (charCounts[j] > 0) {
                if (i >= s.length()) {
                    i = 1;
                }
                ans[i] = (char) (j + 'a');
                i += 2;
                charCounts[j]--;
            }
        }

        return  String.valueOf(ans);
    }

    public static void main(String[] args) {
        Leet767 l767 = new Leet767();
        System.out.println(l767.reorganizeString("aab"));
    }


    
}
