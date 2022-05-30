package skypro.cours2_hw8;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private Double salary;
    private Double departmentId;

    public Employee(String firstName, String lastName, Double salary, Double department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentId = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\''  +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", department=" + departmentId +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public Double getDepartmentId() {
        return departmentId;
    }
}

