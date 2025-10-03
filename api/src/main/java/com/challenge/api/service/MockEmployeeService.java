package com.challenge.api.service;

import com.challenge.api.model.Employee;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class MockeEmployeeService implements EmployeeService {

    private static final Map<UUID, Employee> employeeStore = new ConcurrentHashMap<>();
    private UUID uuid;

    //mock data
    static {

        UUID id1 = UUID.randomUUID();
        employeeStore.put(id1, new Employee(id1, "Michelle", "Yao", "Developer"));
        UUID id2 = UUID.randomUUID();
        employeeStore.put(id2, new Employee(id2, "Selin", "Ciltas", "Personality Hire"));
        UUID id3 = UUID.randomUUID();
        employeeStore.put(id3, new Employee(id3, "Ria", "Saldajeno", "President"));
        UUID id4 = UUID.randomUUID();
        employeeStore.put(id4, new Employee(id4, "Annika", "Singh", "Vice-President"));

    }

    @Override
    public List<Employee> getAllEmployees() {

        return new ArrayList<>(employeeStore.values());
    }

    @Override
    public Employee getEmployeeByUuid(UUID uuid) {

        Employee employee = employeeStore.get(uuid);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with UUID: " + uuid + "can't be found.");
        }
        return employee;
    }

    @Override
    public Employee createEmployee(Employee employee) {

        UUID employeeId = UUID.randomUUID();
        employee.setUuid(employeeId);
        employeeStore.put(employeeId, employee);
        return employee;
    }
}