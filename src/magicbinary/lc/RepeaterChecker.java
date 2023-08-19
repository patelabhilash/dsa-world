package magicbinary.lc;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.OptionalInt;
import java.util.Set;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeaterChecker {
    
    public static void main(String[] args) {
        String s  = "hqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvs";
        System.out.println(new RepeaterChecker().firstNonRepeat(s));
    }

    //AXA
    char firstNonRepeat(String str){
        if(str == null || str.isEmpty()) return ' ';
        Set<Character> singleSet = new LinkedHashSet<Character>();
        Set<Character> repeaterSet = new HashSet<Character>();
        char c = ' ';
        for(int i=0;i< str.length(); i++){
            if(repeaterSet.contains(str.charAt(i))){
                continue;
            }
            if(singleSet.contains(str.charAt(i))) {
                singleSet.remove(str.charAt(i));
                repeaterSet.add(str.charAt(i));
            }
            if(!singleSet.contains(str.charAt(i)) && !repeaterSet.contains(str.charAt(i))){
                singleSet.add(str.charAt(i));
            }
        }
        return singleSet.iterator().hasNext()? singleSet.iterator().next() : ' ';
    }
}
