package magicbinary.owncheck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class sum {
    
    public static void main(String[] args) throws IOException {
        sum sum = new sum();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        long x  = Long.valueOf(br.readLine());
        System.out.println(name);
        System.out.println(x);
        br.close();
        sum.caller("1,3,5,7,11,13,20,35,20", 1120);
    }

    void caller(String line, long x){
        boolean flag = true;
        long[] numbers = Arrays.stream(line.split(",")).mapToLong(Long::parseLong).toArray();
        Set<Long> set = Arrays.stream(numbers).boxed().collect(Collectors.toSet());
        for (int i = 0; i < numbers.length; i++) {
            if(set.contains(x-numbers[i])){
                System.out.println(true);
                System.out.println(numbers[i] + "," + (x-numbers[i]));
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.println(false);
        }
    }
}
