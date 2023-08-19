package magicbinary.lc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Eight {
	static List<Employee> employeeList = new ArrayList<Employee>();

	public static void main(String[] args) {

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		// Query 1 : How many male and female employees are there in the organization?
		method1();
		System.out.println("\n");
		// Query 2 : Print the name of all departments in the organization?
		method2();
		System.out.println("\n");
		// Query 3 : What is the average age of male and female employees?
		method3();
		System.out.println("\n");
		// Query 4 : Get the details of highest paid employee in the organization?
		method4();
		System.out.println("\n");
		// Query 5 : Get the names of all employees who have joined after 2015?
		method5();
		System.out.println("\n");
		// Query 6 : Count the number of employees in each department?
		method6();
		System.out.println("\n");
		// Query 7 : What is the average salary of each department?
		method7();
		System.out.println("\n");
		// Query 8 : Get the details of youngest male employee in the product
		// development department?
		method8();
		System.out.println("\n");
		// Query 9 : Who has the most working experience in the organization?
		method9();
		System.out.println("\n");
		// Query 10 : How many male and female employees are there in the sales and
		// marketing team?
		method10();
		System.out.println("\n");
		// Query 11 : What is the average salary of male and female employees?
		method11();
		System.out.println("\n");
		// Query 12 : List down the names of all employees in each department?
		method12();
		System.out.println("\n");
		// Query 13 : What is the average salary and total salary of the whole
		// organization?
		method13();
		System.out.println("\n");
		// Query 14 : Separate the employees who are younger or equal to 25 years from
		// those employees who are older than 25 years.
		method14();
		System.out.println("\n");
		// Query 15 : Who is the oldest employee in the organization? What is his age
		// and which department he belongs to?
		method15();

	}

	public static void method1() {
		System.out.println("Query 1 : How many male and female employees are there in the organization?");
        Map<String, List<Employee>> mapByGender = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender));
        Map<String, Integer> mapByGenderFollowingCount = new HashMap<>();
        mapByGender.forEach((k,v)-> mapByGenderFollowingCount.put(k, v.size()));

        //or

        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		
	}

	public static void method2() {
		System.out.println("Query 2 : Print the name of all departments in the organization?");
		employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());

        //or remove duplicate
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList())).forEach((k,v)-> System.out.println(v.get(0)));;
	}

	public static void method3() {
		System.out.println("Query 3 : What is the average age of male and female employees?");
		Map<String, Double> averageAgeOfMaleAndFemaleEmployee = null;
        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		System.out.println(averageAgeOfMaleAndFemaleEmployee);
	}

	public static void method4() {
		System.out.println("Query 4 : Get the details of highest paid employee in the organization?");
		employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get();
	}

	public static void method5() {
		System.out.println("Query 5 : Get the names of all employees who have joined after 2015?");
		
	}

	public static void method6() {
		System.out.println("Query 6 : Count the number of employees in each department?");
		
	}

	public static void method7() {
		System.out.println("Query 7 : What is the average salary of each department?");
		
	}

	public static void method8() {
		System.out
				.println("Query 8 : Get the details of youngest male employee in the product development department?");
		  
	}

	public static void method9() {
		System.out.println("Query 9 : Who has the most working experience in the organization?");
		
	}

	public static void method10() {
		
	}

	public static void method11() {
		System.out.println("Query 11 : What is the average salary of male and female employees?");
		
	}

	public static void method12() {
		System.out.println("Query 12 : List down the names of all employees in each department?");
        Map <String, List<String>> mapByDepartmentFollowingEmpName = new HashMap<>();
		Map <String, List<Employee>> mapByDepartmentFollowingEmp = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        mapByDepartmentFollowingEmp.forEach((k,v)-> {mapByDepartmentFollowingEmpName.put(k, v.stream().map(Employee::getName).collect(Collectors.toList()));});

        //or the print alternative is:
        mapByDepartmentFollowingEmp.forEach((k,v)-> {System.out.println(k);v.stream().map(Employee::getName).forEach(System.out::println);});

        //or toMap
        
    
	}

	public static void method13() {
		System.out.println("Query 13 : What is the average salary and total salary of the whole organization?");
		DoubleSummaryStatistics dss =  employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        dss.getAverage(); dss.getSum();
	}

	public static void method14() {
		System.out.println(
				"Query 14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.");
		
	}

	public static void method15() {
		System.out.println(
				"Query 15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?");
		
    }

    public static void method16() {
        List<Employee> personListFiltered = employeeList.stream() 
  .filter(distinctByKey(p -> p.getName())) 
  .collect(Collectors.toList());

  
    }

    public static <T> Predicate<T> distinctByKey(
    Function<? super T, ?> keyExtractor) {
  
    Map<Object, Boolean> seen = new ConcurrentHashMap<>(); 
    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null; 
}
}

class Employee {
	int id;

	String name;

	int age;

	String gender;

	String department;

	int yearOfJoining;

	double salary;

	public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getDepartment() {
		return department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Id : " + id + ", Name : " + name + ", age : " + age + ", Gender : " + gender + ", Department : "
				+ department + ", Year Of Joining : " + yearOfJoining + ", Salary : " + salary;
	}
}