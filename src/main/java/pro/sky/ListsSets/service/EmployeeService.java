package pro.sky.ListsSets.service;

import pro.sky.ListsSets.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName);
    Employee remove (String firstName, String lastName);
    Employee find(String firstName, String lastName);

    Collection<Employee> printAll();
}
