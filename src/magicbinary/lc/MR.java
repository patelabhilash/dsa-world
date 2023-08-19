package magicbinary.lc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * MR
 */
public class MR {

    public static void main(String[] args) {
        
        List<String> names = Arrays.asList("a","b","c");

        names.forEach(s -> System.out.println(s));

        // so foreach takes consumer

        Consumer<String> consumer = new Consumer<String>() {

            @Override
            public void accept(String t) {
                System.out.println(t);
            }
            
        };

        names.forEach(consumer);

        // same thing in lambda expression as consumer is a funtional interface

        names.forEach(s -> System.out.println(s));

        //call by method
        // name the method and the method is from which class/ interface

        names.forEach(System.out::println);
    }
}