package com.google.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.google.entity.EmployeeEntity;
@Repository
public interface EmployeeRepository
        extends PagingAndSortingRepository<EmployeeEntity, Long> {

}


//import java.util.List;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import com.google.entity.EmployeeEntity;
//
//@Repository
//public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {
//
//	List<EmployeeEntity> findAll();
//
//	@Query(nativeQuery = true,value = "select * from employee where empId > 10")
//	List<EmployeeEntity> findEmployee();
//	
//}