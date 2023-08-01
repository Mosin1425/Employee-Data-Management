package com.example.repository;

import com.example.entity.Employee;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@N1qlPrimaryIndexed
public interface EmployeeRepository extends CouchbaseRepository<Employee, Integer> {
    void deleteById(String id);
    Employee findById(String id);

    @Override
    Page<Employee> findAll(Pageable pageable);
}
