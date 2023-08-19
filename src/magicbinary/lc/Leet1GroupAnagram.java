package magicbinary.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Leet1GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null) return null;
        if (strs.length == 0) return new ArrayList<>();
        
        List<Map<Integer,Long>> input =
        Arrays.stream(strs).map(e -> e.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())))
                .collect(Collectors.toList());

        
        
        Map<Map<Integer, Long>, List<String>> map = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            if(map.containsKey(input.get(i))){
                map.get(input.get(i)).add(strs[i]);
            }else{
                map.put(input.get(i), new ArrayList<String>(Arrays.asList(strs[i])));
            }
        }
        return map.values().stream().collect(Collectors.toList());
    }

    boolean checkIfBothAnagram(String str1, String srt2){
        Set set1 = str1.chars().boxed().collect(Collectors.toSet());
        // Set set2 = 
        return false;
    }
}
