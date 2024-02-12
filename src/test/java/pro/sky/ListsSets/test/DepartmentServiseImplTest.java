package pro.sky.ListsSets.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.ListsSets.exception.EmployeeNotFoundException;
import pro.sky.ListsSets.service.DepartmentServiseImpl;
import pro.sky.ListsSets.service.EmployeeService;

import java.util.Collections;
import java.util.List;

import static pro.sky.ListsSets.EmployeeTestData.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiseImplTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    DepartmentServiseImpl out;

    @Test
    public void findEmployeeWithMinSalaryInDepartment(){
        Mockito.when(employeeService.findAll()).thenReturn(EMPLOYEE_SET);
        Assertions.assertEquals(employeeWithMinSalary,out.printEmployeeWithMinSalaryFromDepartmentID(departmentID));
    }
    @Test
    public void throwExceptionWhenFindMinSalaryWhenEmployeesareEmpty(){
        Mockito.when(employeeService.findAll()).thenReturn(List.of());
        Assertions.assertThrows(EmployeeNotFoundException.class, ()-> out.printEmployeeWithMinSalaryFromDepartmentID(departmentID));
    }
    @Test
    public void throwExceptionWhenFindMinSalaryWhenDepartmentDontExist(){
        Mockito.when(employeeService.findAll()).thenReturn(EMPLOYEE_SET);
        Assertions.assertThrows(EmployeeNotFoundException.class, ()-> out.printEmployeeWithMinSalaryFromDepartmentID(otherDepartmentID));
    }
    @Test
    public void findEmployeeWithMaxSalaryInDepartment(){
        Mockito.when(employeeService.findAll()).thenReturn(EMPLOYEE_SET);
        Assertions.assertEquals(employeeWithMaxSalary,out.printEmployeeWithMaxSalaryFromDepartmentID(departmentID));
    }
    @Test
    public void throwExceptionWhenFindMaxSalaryWhenEmployeesAreEmpty(){
        Mockito.when(employeeService.findAll()).thenReturn(List.of());
        Assertions.assertThrows(EmployeeNotFoundException.class, ()-> out.printEmployeeWithMaxSalaryFromDepartmentID(departmentID));
    }
    @Test
    public void throwExceptionWhenFindMaxSalaryWhenDepartmentDontExist(){
        Mockito.when(employeeService.findAll()).thenReturn(EMPLOYEE_SET);
       Assertions.assertThrows(EmployeeNotFoundException.class,()-> out.printEmployeeWithMinSalaryFromDepartmentID(otherDepartmentID));
    }
    @Test
    public void returnEmployeesFromDepartment(){
        Mockito.when(employeeService.findAll()).thenReturn(employeesWithDifferentDepartmentID);
        Assertions.assertEquals(employeesGroupingByDepartmentID, out.printEmployeeFromEachDepartments());
    }
    @Test
    public void returnEmptyCollectionWhenEmployeesDontExist(){
        Mockito.when(employeeService.findAll()).thenReturn(List.of());
        Assertions.assertEquals(Collections.EMPTY_MAP, out.printEmployeeFromEachDepartments());
    }
    @Test
    public void findSalarySumInDepartment(){
        Mockito.when(employeeService.findAll()).thenReturn(EMPLOYEE_SET);
        Assertions.assertEquals(salarySumInEmployees,out.salarySumFromDepartment(departmentID));
    }
}
