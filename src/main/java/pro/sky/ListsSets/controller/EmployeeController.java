package pro.sky.ListsSets.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.ListsSets.model.Employee;
import pro.sky.ListsSets.service.EmployeeService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController

public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping("/employee/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam int departmentID){
        return service.add(firstName, lastName, salary, departmentID);
    }
    @GetMapping("/employee/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName,@RequestParam int salary, @RequestParam int departmentID){
        return service.remove(firstName, lastName, salary, departmentID);
    }
    @GetMapping("/employee/findAll")
    public Collection<Employee> findAllEmployee(){
        return service.findAll();
    }
    @GetMapping("/employee/find")
    public Employee findEmployee(@RequestParam String firstName,@RequestParam String lastName){
        return  service.find(firstName, lastName);
    }
    @GetMapping ("/employee")
    public Collection<Object> printAllEmployee(){
        return service.printAll();
    }

    @GetMapping (path = "/departments/all", params = {"departmentID"})
    public Collection<Employee> allEmployeeFromDepartmentID (@RequestParam int departmentID){
        return service.printEmployeeFromDepartment(departmentID);
    }
   @GetMapping (path = "/departments/all")
    public Map<Integer, List<Employee>> allEmployeeFromEachDepartmentID(){
       return service.printEmployeeFromEachDepartments();
   }

   @GetMapping (path = "/departments/max-salary")
        public Employee EmployeeWithMaxSalaryFromDepartmentID (@RequestParam int departmentID){
        return service.printEmployeeWithMaxSalaryFromDepartmentID(departmentID);
   }
    @GetMapping (path = "/departments/max-salary")
    public Employee EmployeeWithMinSalaryFromDepartmentID (@RequestParam int departmentID){
        return service.printEmployeeWithMinSalaryFromDepartmentID(departmentID);
    }
}
