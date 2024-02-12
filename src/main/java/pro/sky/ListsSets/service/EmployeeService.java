package pro.sky.ListsSets.service;

import pro.sky.ListsSets.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Collection<Employee> findAll();

    Collection<Object> printAll();

    Collection<Employee> printEmployeeFromDepartment(int departmentID);

    Map<Integer, List<Employee>> printEmployeeFromEachDepartments();

    Employee printEmployeeWithMaxSalaryFromDepartmentID(int departmentID);

    Employee printEmployeeWithMinSalaryFromDepartmentID(int departmentID);

    Employee add(String firstName, String lastName, int salary, int departmentID);

    Employee remove(String firstName, String lastName, int salary, int departmentID);

    Employee find(String firstName, String lastName);
}
