package skypro.cours2_hw8;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewEmployeeServis {
    private final EmployeeServise servise;

    public NewEmployeeServis(EmployeeServise servise) {
        this.servise = servise;
    }

    public Optional<Employee> findMaxSalaryByDepartment(Double departmentId) {
        return Optional.of(servise.getEmployee().values().stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .max(Comparator.comparingDouble(employee -> employee.getSalary()))
                .orElseThrow());
    }

    public Optional<Employee> findMinSalaryByDepartment(Double departmentId) {
        return Optional.of(servise.getEmployee().values().stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .min(Comparator.comparingDouble(employee -> employee.getSalary()))
                .orElseThrow());
    }

    public List<Employee> showAllEmployeeOfDepartment(Double departmentId) {
        if (departmentId > 5) {
            throw new NotFoundException();
        }
        return servise.getEmployee().values().stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .collect(Collectors.toList());
    }

    public String showAllEmployeesByDepartment() {
        String department = new String();
        for (Double i = Double.valueOf(0); i < 5; i++) {
            department = department + showAllEmployeeOfDepartment(i);
        }
        return department;
    }


}
