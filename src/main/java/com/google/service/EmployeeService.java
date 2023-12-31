package com.google.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.google.exception.RecordNotFoundException;
import com.google.entity.EmployeeEntity;
import com.google.repository.EmployeeRepository;
 
@Service
public class EmployeeService {
     
    @Autowired
    EmployeeRepository repository;
     
    public List<EmployeeEntity> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<EmployeeEntity> pagedResult = repository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<EmployeeEntity>();
        }
    }
     
    public EmployeeEntity getEmployeeById(Long empId) throws RecordNotFoundException
    {
        Optional<EmployeeEntity> employee = repository.findById(empId);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws RecordNotFoundException
    {
        Optional<EmployeeEntity> employee = repository.findById(entity.getEmpId());
         
        if(employee.isPresent())
        {
            EmployeeEntity newEntity = employee.get();
            newEntity.setJobTitle(entity.getJobTitle());
            newEntity.setEmail(entity.getEmail());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
            newEntity.setContactNo(entity.getContactNo());
            newEntity.setEmail(entity.getAddress());
            newEntity.setEmail(entity.getExperience());
            newEntity.setTypeOfEmployee(entity.getTypeOfEmployee());
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    }
     
    public void deleteEmployeeById(Long empId) throws RecordNotFoundException
    {
        Optional<EmployeeEntity> employee = repository.findById(empId);
         
        if(employee.isPresent())
        {
            repository.deleteById(empId);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}