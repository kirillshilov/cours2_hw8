package skypro.cours2_hw8;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;


@Service
public class EmployeeServise {

    private final Map<String, Employee> employee = new HashMap<>() {
    };

    public Employee addEmployee(String firstName, String lastName, Double salary, Double department) {
        checkData(firstName, lastName);
        if (employee.containsKey(conkatinate(firstName, lastName))) {
            throw new AlreadyHasException();
        }
        employee.put(conkatinate(firstName, lastName), new Employee(firstName, lastName, salary, department));
        return employee.get(conkatinate(firstName, lastName));
    }

    public Employee deleteEmployee(String firstName, String lastName) {
        checkData(firstName, lastName);
        if (employee.containsKey(conkatinate(firstName, lastName))) {
            Employee employee1 = employee.get(conkatinate(firstName, lastName));
            employee.remove(conkatinate(firstName, lastName));
            return employee1;
        }
        throw new NotFoundException();
    }

    private void checkData(String firstName, String lastName) {
        if (StringUtils.contains(firstName, null) &&
                StringUtils.contains(lastName, null) &&
                StringUtils.isAlpha(firstName) == false &&
                StringUtils.isAlpha(lastName) == false) {
            throw new AlreadyHasException();
        }
    }


    public Employee findEmployee(String firstName, String lastName) {
        checkData(firstName, lastName);
        if (employee.containsKey(conkatinate(firstName, lastName))) {
            return employee.get(conkatinate(firstName, lastName));
        }
        throw new NotFoundException();
    }

    public Map listOfEmployee() {
        return employee;
    }

    private String conkatinate(String firstName, String lastName) {
        firstName = trim(firstName);
        lastName = trim(lastName);
        return capitalize(firstName) + capitalize(lastName);
    }

    public Map<String, Employee> getEmployee() {
        return employee;
    }
}












