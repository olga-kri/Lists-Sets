package pro.sky.ListsSets.service;

import pro.sky.ListsSets.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentServise {
    Employee printEmployeeWithMaxSalaryFromDepartmentID(int departmentID);

    Employee printEmployeeWithMinSalaryFromDepartmentID(int departmentID);

    Map<Integer, List<Employee>> printEmployeeFromEachDepartments();

    Collection<Employee> printEmployeeFromDepartment(int departmentID);

    Integer salarySumFromDepartment(int departmentID);
}
