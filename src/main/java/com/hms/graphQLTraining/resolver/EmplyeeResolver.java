package com.hms.graphQLTraining.resolver;

import com.hms.graphQLTraining.domain.emplyee.Employee;
import com.hms.graphQLTraining.domain.emplyee.Manager;
import com.hms.graphQLTraining.repository.EmployeeRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class EmployeeQueryResolver implements GraphQLQueryResolver {

    private final EmployeeRepository employeeRepository;

    public EmployeeQueryResolver(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<? extends Employee> findEmployeeList() {
        return employeeRepository.getLinkList();
    }
}


@Component
class EmployeeMutationResolver implements GraphQLMutationResolver {

    private final EmployeeRepository employeeRepository;

    public EmployeeMutationResolver(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Boolean saveManager(Long id) {
        return employeeRepository.saveManager(new Manager(id));
    }
}