package pro.sky.ListsSets.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.ListsSets.model.Employee;
import pro.sky.ListsSets.service.EmployeeService;

import java.util.Collection;

@RestController

public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping("/employee/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName){
        return service.add(firstName, lastName);
    }
    @GetMapping("/employee/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName){
        return service.remove(firstName, lastName);
    }
    @GetMapping("/employee/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName){
        return service.find(firstName, lastName);
    }
    @GetMapping ("/employee")
    public Collection<Employee> printAllEmployee(){
        return service.printAll();
    }
}
