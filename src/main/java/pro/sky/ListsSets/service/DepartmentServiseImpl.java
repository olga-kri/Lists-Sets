package pro.sky.ListsSets.service;

import pro.sky.ListsSets.exception.EmployeeNotFoundException;
import pro.sky.ListsSets.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class DepartmentServiseImpl implements DepartmentServise {
    private final EmployeeService employeeService;
    private DepartmentServiseImpl(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @Override
    public Employee printEmployeeWithMaxSalaryFromDepartmentID(int departmentID) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartmentID() == departmentID)
                .max(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee printEmployeeWithMinSalaryFromDepartmentID(int departmentID) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartmentID() == departmentID)
                .min(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Map<Integer, List<Employee>> printEmployeeFromEachDepartments() {
        return employeeService
                .findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentID));
    }

    @Override
    public Collection<Employee> printEmployeeFromDepartment(int departmentID) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartmentID() == departmentID)
                .collect(Collectors.toList());
    }

    @Override
    public Integer salarySumFromDepartment(int departmentID) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartmentID() == departmentID)
                .mapToInt(Employee::getSalary)
                .reduce(0,Integer::sum);
    }
}
