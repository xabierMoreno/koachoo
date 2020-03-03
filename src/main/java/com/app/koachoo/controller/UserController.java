package com.app.koachoo.controller;

import com.app.koachoo.dto.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({ "/employees" })
public class UserController {

    private List<Employee> employees = createList();

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(produces = "application/json")
    public List<Employee> firstPage() {
        return employees;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = { "/{id}" })
    public Employee delete(@PathVariable("id") int id) {
        Employee deletedEmp = null;
        for (Employee emp : employees) {
            if (emp.getEmpId().equals(id)) {
                employees.remove(emp);
                deletedEmp = emp;
                break;
            }
        }
        return deletedEmp;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        employees.add(employee);
        System.out.println(employees);
        return employee;
    }

    private static List<Employee> createList() {
        List<Employee> tempEmployees = new ArrayList<>();
        Employee emp1 = new Employee();
        emp1.setName("emp1");
        emp1.setDesignation("manager");
        emp1.setEmpId("1");
        emp1.setSalary(3000);

        Employee emp2 = new Employee();
        emp2.setName("emp2");
        emp2.setDesignation("developer");
        emp2.setEmpId("2");
        emp2.setSalary(3000);
        tempEmployees.add(emp1);
        tempEmployees.add(emp2);
        return tempEmployees;
    }
}
