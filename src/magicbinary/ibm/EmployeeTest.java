package magicbinary.ibm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeTest {

    public static void main(String[] args) {
        List<Employee> emplist = new ArrayList<>();
        emplist.add(new Employee("abc", 57, 11280));
        emplist.add(new Employee("abdc", 7, 12800));
        emplist.add(new Employee("absc", 67, 125580));
        emplist.add(new Employee("awbc", 74, 12080));
        emplist.add(new Employee("abfc", 5, 1450));
        double average = emplist.stream().filter(e -> e.getAge() > 50)
                .collect(Collectors.averagingDouble(e -> e.getSalary()));
        // System.out.println(average);

        String str = "8555122299";
        System.out.println();
        Map<Character, Long> map = IntStream.range(0, str.length()).boxed().map(x-> str.charAt(x)).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(map);

        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        List<String> stringList = new ArrayList<>(List.of("apple", "banana", "orange"));

    }
}

//lazy loading in java 8
//competable future, future



class Employee {
    String name;
    int age;
    int salary;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
