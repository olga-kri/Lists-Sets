package pro.sky.ListsSets.service;

import org.springframework.stereotype.Service;
import pro.sky.ListsSets.exception.EmployeeAlreadyAddedException;
import pro.sky.ListsSets.exception.EmployeeNotFoundException;
import pro.sky.ListsSets.model.Employee;

import javax.xml.validation.Validator;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Map <String, Employee> employees;
    private EmployeeService employeeService;

    public EmployeeServiceImpl() {
      employees = new HashMap<>() ;
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int departmentID) {
        Employee employee = new Employee(firstName, lastName,salary, departmentID);
        if (employees.containsKey(employee.getFullName())){
           throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, int salary, int departmentID) {
        Employee employee = new Employee(firstName, lastName, salary, departmentID);
        if (employees.containsKey(employee.getFullName())){
            return (Employee)  employees.remove(employee.getFullName());

        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
            if (employees.containsKey(firstName +" "+ lastName)) {
                return employees.get(firstName +" "+ lastName);
            } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Collection <Employee> findAll() {
            return Collections.unmodifiableCollection(employees.values());
        }


    @Override
    public Collection<Object> printAll() {
        return Collections.unmodifiableCollection(employees.values());
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
    public Map <Integer, List<Employee>> printEmployeeFromEachDepartments() {
        return employeeService
                .findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentID));
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


}
