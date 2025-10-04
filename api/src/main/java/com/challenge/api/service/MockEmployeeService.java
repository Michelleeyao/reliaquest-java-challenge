package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service
public class MockEmployeeService implements EmployeeService {

    private static final Map<UUID, Employee> employeeStore = new ConcurrentHashMap<>();

    static {
        UUID id1 = UUID.randomUUID();
        employeeStore.put(id1, new EmployeeModel(id1, "Michelle", "Yao", "Software Engineer"));

        UUID id2 = UUID.randomUUID();
        employeeStore.put(id2, new EmployeeModel(id2, "Ria", "Saldejeno", "Product Manager"));

        UUID id3 = UUID.randomUUID();
        employeeStore.put(id3, new EmployeeModel(id3, "Annika", "Singh", "Tech Consultant"));

        UUID id4 = UUID.randomUUID();
        employeeStore.put(id4, new EmployeeModel(id4, "Selin", "Ciltas", "President"));

        UUID id5 = UUID.randomUUID();
        employeeStore.put(id5, new EmployeeModel(id5, "Lee", "Gallivan", "Environmental Scientist"));
    }

    @Override
    public List<Employee> getAllEmployees() {

        return new ArrayList<>(employeeStore.values());
    }

    @Override
    public Employee getEmployeeByUuid(UUID uuid) {

        Employee employee = employeeStore.get(uuid);
        if (employee == null) {
//            throw new EmployeeNotFoundException("Employee with UUID: " + uuid + "can't be found.");
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
