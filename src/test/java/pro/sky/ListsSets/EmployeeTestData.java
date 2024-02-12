package pro.sky.ListsSets;

import pro.sky.ListsSets.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeTestData {
    public static final String firstName = "Daenerys";
    public static final String firstName2 = "Jon";
    public static final String lastName = "Targaryen";
    public static final String lastName2 = "Snow";
    public static final int minSalary = 10000;
    public static final int maxSalary = 1000000;
    public static final int departmentID = 1;
    public static final int otherDepartmentID = 2;
    public static final Employee employeeWithMaxSalary = new Employee(firstName,lastName, maxSalary, departmentID);
    public static final Employee employeeWithMinSalary = new Employee(firstName2,lastName2, minSalary, departmentID);
    public static final Employee employeeFromOtherDepartment = new Employee(firstName,lastName,maxSalary,otherDepartmentID);
    public static final Set<Employee> EMPLOYEE_SET = Set.of(employeeWithMinSalary, employeeWithMaxSalary);
    public static final Set<Employee> employeesWithDifferentDepartmentID = Set.of(employeeWithMinSalary, employeeFromOtherDepartment);
    public static final Map<Integer, List<Employee>> employeesGroupingByDepartmentID = employeesWithDifferentDepartmentID.stream()
            .collect(Collectors.groupingBy(Employee::getDepartmentID));
    public static Integer salarySumInEmployees = employeeWithMinSalary.getSalary()+employeeWithMaxSalary.getSalary();



}
