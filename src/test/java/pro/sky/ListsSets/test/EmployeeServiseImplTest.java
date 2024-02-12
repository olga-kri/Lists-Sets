package pro.sky.ListsSets.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.ListsSets.exception.EmployeeAlreadyAddedException;
import pro.sky.ListsSets.exception.EmployeeNotFoundException;
import pro.sky.ListsSets.model.Employee;
import pro.sky.ListsSets.service.EmployeeService;
import pro.sky.ListsSets.service.EmployeeServiceImpl;

import java.util.Collection;
import java.util.List;

import static pro.sky.ListsSets.EmployeeTestData.*;

public class EmployeeServiseImplTest {
    private final EmployeeService out = new EmployeeServiceImpl();

    //add
    @Test
    public void addNewEmployee(){
        Employee controlEmployee = new Employee(firstName,lastName,maxSalary,departmentID );
        Assertions.assertEquals(0,out.findAll().size());

        Employee addEmployee = out.add(firstName,lastName,maxSalary,departmentID );
        Assertions.assertEquals(1,out.findAll().size());
        Assertions.assertEquals(controlEmployee, addEmployee);
        Assertions.assertTrue(out.findAll().contains(controlEmployee));
    }
    @Test
    public void addExistEmployeeException(){
        Employee existEmployee = out.add(firstName,lastName,maxSalary,departmentID );
        Assertions.assertTrue(out.findAll().contains(existEmployee));
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, ()->out.add(firstName,lastName,maxSalary,departmentID));
    }
    //find
    @Test
    public void employeeNotFoundException(){
        Assertions.assertEquals(0,out.findAll().size());
        Assertions.assertThrows(EmployeeNotFoundException.class, ()->out.find(firstName,lastName));
    }
    @Test
    public void findExistEmployee(){
        Employee existEmployee = out.add(firstName,lastName,maxSalary,departmentID);
        Employee findEmployee = out.find(firstName, lastName);
        Assertions.assertEquals(existEmployee,findEmployee);
    }
    //remove
    @Test
    public void notFoundExceptionAfterRemoveEmployeeWhichDontExist(){
        Assertions.assertTrue(out.findAll().isEmpty());
        Assertions.assertThrows(EmployeeNotFoundException.class, ()->out.remove(firstName,lastName, maxSalary, departmentID));
    }
    @Test
    public void removeExistEmployee(){
        Employee controlEmployee = out.add(firstName,lastName,maxSalary,departmentID );
        Assertions.assertEquals(1,out.findAll().size());
        Assertions.assertTrue(out.findAll().contains(controlEmployee));

        Employee actualEmployee = out.remove(firstName, lastName, maxSalary, departmentID);
        Assertions.assertTrue(out.findAll().isEmpty());
        Assertions.assertFalse(out.findAll().contains(controlEmployee));
    }
}
