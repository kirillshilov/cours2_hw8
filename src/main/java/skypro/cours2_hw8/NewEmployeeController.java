package skypro.cours2_hw8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class NewEmployeeController {
    private final NewEmployeeServis service;

    private NewEmployeeController(NewEmployeeServis service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public Optional<Employee> maxSalaryByDepartment(@RequestParam Double departmentId) {
        return service.findMaxSalaryByDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Optional<Employee> minSalaryByDepartment(@RequestParam Double departmentId) {
        return service.findMinSalaryByDepartment(departmentId);
    }

    @GetMapping("/all")
    public String employeeByDepartment(@RequestParam (required = false) Double departmentId) {
        if (departmentId != null) {return service.showAllEmployeeOfDepartment(departmentId).toString();

    }
    else {
        return service.showAllEmployeesByDepartment();
    }
}}
