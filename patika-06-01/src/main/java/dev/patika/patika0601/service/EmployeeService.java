package dev.patika.patika0601.service;

import dev.patika.patika0601.model.Employee;
import dev.patika.patika0601.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public void addEmployee(Employee employee) {
        // TO-DO check if employee exists???
        repository.findEmployeeByEmail(employee.getEmail()).orElseThrow(() -> new RuntimeException("An Employee with this e-mail already exists."));
        repository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        // TO-DO check if employee exists with given ID???
        repository.findById(employeeId).orElseThrow(() -> new EntityNotFoundException("No Employee found on database with id: " + employeeId));
        repository.deleteById(employeeId);

    }
}
