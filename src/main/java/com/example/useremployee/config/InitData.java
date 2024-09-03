package com.example.useremployee.config;

import com.example.useremployee.model.Employee;
import com.example.useremployee.model.Gender;
import com.example.useremployee.model.User;
import com.example.useremployee.repositories.EmployeeRepository;
import com.example.useremployee.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setEmail("jamiehye@live.dk");
        user.setPassword("1234");
        userRepository.save(user);

        user.setUserId(0);
        user.setEmail("mafmaf@live.dk");
        user.setPassword("2468");
        userRepository.save(user);

        user.setUserId(0);
        user.setEmail("mifmaf@live.dk");
        user.setPassword("9999");

        userRepository.save(user);




        Employee employee = new Employee();
        employee.setBorn(LocalDateTime.of(1994, 11, 21, 16, 10, 12));
        employee.setName("Jamie");
        employee.setGender(Gender.MALE);
        employee.setVegetarian(true);
        employee.setUser(user);
        employeeRepository.save(employee);

    }
}
