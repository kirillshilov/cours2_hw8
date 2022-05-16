package skypro.cours2_hw8;


import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class EmployeeServise {

    private final Map<String, Employee> employee = new HashMap<>() {
    };

    public Employee addEmployee(String firstName, String lastName, Double salary, Double department) {
        if (employee.containsKey(conkatinate(firstName, lastName))) {
            throw new AlreadyHasException();
        }
        employee.put(conkatinate(firstName, lastName), new Employee(firstName, lastName, salary, department));
        return employee.get(conkatinate(firstName, lastName));
    }

    public Employee deleteEmployee(String firstName, String lastName) {
        if (employee.containsKey(conkatinate(firstName, lastName))) {
            Employee employee1 = employee.get(conkatinate(firstName, lastName));
            employee.remove(conkatinate(firstName, lastName));
            return employee1;
        }
        throw new NotFoundException();
    }


    public Employee findEmployee(String firstName, String lastName) {
        if (employee.containsKey(conkatinate(firstName, lastName))) {
            return employee.get(conkatinate(firstName, lastName));
        }
        throw new NotFoundException();
    }

    public Map listOfEmployee() {
        return employee;
    }

    private String conkatinate(String firstName, String lastName) {
        return firstName + lastName;
    }

    public Map<String, Employee> getEmployee() {
        return employee;
    }
}












