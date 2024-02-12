package pro.sky.ListsSets.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.ListsSets.model.Employee;
import pro.sky.ListsSets.service.DepartmentServise;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentServise departmentServise;

    public DepartmentController(DepartmentServise departmentServise) {
        this.departmentServise = departmentServise;
    }

    @GetMapping ("{id}/salary/max")
    public Employee EmployeeWithMaxSalaryFromDepartmentID (@PathVariable int departmentID){
        return departmentServise.printEmployeeWithMaxSalaryFromDepartmentID(departmentID);
    }
    @GetMapping("{id}/salary/min")
    public Employee EmployeeWithMinSalaryFromDepartmentID (@PathVariable int departmentID){
        return departmentServise.printEmployeeWithMinSalaryFromDepartmentID(departmentID);
    }
    @GetMapping ("/employees")
    public Map<Integer, List<Employee>> allEmployeeFromEachDepartmentID(){
        return departmentServise.printEmployeeFromEachDepartments();
    }
    @GetMapping ("{id}/employees")
    public Collection<Employee> allEmployeeFromDepartmentID (@PathVariable int departmentID){
        return departmentServise.printEmployeeFromDepartment(departmentID);
    }
    @GetMapping ("{id}/salary/sum")
    public Integer allSalarySumFromDepartment (@PathVariable int departmentID){
        return departmentServise.salarySumFromDepartment(departmentID);
    }
}
