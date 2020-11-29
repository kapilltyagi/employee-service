package com.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;

import com.entity.Employee;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import static org.springframework.data.relational.core.query.Criteria.where;

@RequiredArgsConstructor
@Component

public class EmployeeRepository {
	
	@Autowired
    private final DatabaseClient databaseClient;

    
    public Mono<Employee> findById(int employeeid) {
        return this.databaseClient.select().from(Employee.class)
                .matching(where("employeeid").is(employeeid))
                .fetch().one();
        
    }


}
