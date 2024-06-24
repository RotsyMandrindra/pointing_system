package hei.school.pointingsystem;

import java.util.ArrayList;
import java.util.List;

public class PointingSystem {
    private List<Employee> employees;

    public PointingSystem() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> addEmployee(Employee employee) {
        for (Employee existingEmployee : employees) {
            if (existingEmployee.getRegistrationNumber() == employee.getRegistrationNumber()) {
                throw new IllegalArgumentException("An employee with the same registration number already exists.");
            }
        }
        employees.add(employee);
        return employees;
    }


}
