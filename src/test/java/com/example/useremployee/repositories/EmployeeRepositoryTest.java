package com.example.useremployee.repositories;

import com.example.useremployee.model.Employee;
import com.example.useremployee.model.Gender;
import com.example.useremployee.model.User;
import org.hibernate.JDBCException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void testAtLeastOneJamie() {
        List<Employee> lst = employeeRepository.findEmployeeByName("Jamie");
        assertTrue(lst.size() > 0);
    }

    @Test
    void testDeleteEmployee() {
        List<Employee> lst = employeeRepository.findEmployeeByName("Jamie");
        Employee employee = lst.get(0);
        assertEquals("Jamie", employee.getName());
      //  userRepository.delete(employee.getUser());
        assertThrows(org.springframework.dao.DataIntegrityViolationException.class, () -> userRepository.delete(employee.getUser()));
    }


}