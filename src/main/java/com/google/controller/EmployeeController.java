package com.google.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.entity.EmployeeEntity;
import com.google.repository.EmployeeRepository;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.google.exception.RecordNotFoundException;

import com.google.service.EmployeeService;

@Controller
public class EmployeeController
{
   @Autowired
 EmployeeRepository empRepo;
@Autowired
EmployeeService service;
   
@GetMapping("/listemployee")
    public String listEmployee() {
    	return "ListEmployee";
    }
    @PostMapping("/saveemployee")
	public String saveEmployee(EmployeeEntity employee) {
		empRepo.save(employee);
		return "ListEmployee";
	}
        @GetMapping("/listusers")
	public String listEmployee(Model model) {

		//List<EmployeeEntity> employee = empRepo.findAll();
		//model.addAttribute("employee", employee);
		return "ListEmployee";
	}
    @GetMapping("/newemployee")
    public String newEmployee() {
    	return "Employee";
    }    
   @GetMapping("/deleteemployee")
    public String deleteEmployee(@RequestParam("empId") Long empId) {
    	empRepo.deleteById(empId);
    	return "redirect:/listemployee";
    }
    
//    @PostMapping("/saveEmployee")
//public String saveEmploye(EmployeeEntity employee) {
//		// save employee to database
//		employeeService.saveEmployee(employee);
//		return "redirect:/listemployee";	}
	
//	// display list of employees
////	@GetMapping("/")
////	public String viewHomePage(Model model) {
////		return findPaginated(1, "firstName", "asc", model);		
////	}
//	
//	@GetMapping("/newemployee")
//	public String newEmployee(Model model) {
//		// create model attribute to bind form data
//		EmployeeEntity employee = new EmployeeEntity();
//		model.addAttribute("employee", employee);
//		return "Employee";
//	}
//	
//	@PostMapping("/saveemployee")
//	public String saveEmployee( EmployeeEntity employee) {
//		// save employee to database
//		employeeService.saveEmployee(employee);
//		return "redirect:/";
//	}
//	
//	@GetMapping("/showFormForUpdate/{id}")
//	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
//		
//		// get employee from the service
//		EmployeeEntity employee = employeeService.getEmployeeById(id);
//		
//		// set employee as a model attribute to pre-populate the form
//		model.addAttribute("employee", employee);
//		return "update_employee";
//	}
//	
//	@GetMapping("/deleteEmployee/{id}")
//	public String deleteEmployee(@PathVariable (value = "empId") long empIdd) {
//		
//	// call delete employee method 
//	this.employeeService.deleteEmployeeById(empId);
//	return "redirect:/";
//}
//	
//	
//	@GetMapping("/page/{pageNo}")
//	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
//			@RequestParam("sortField") String sortField,
//			@RequestParam("sortDir") String sortDir,
//			Model model) {
//		int pageSize = 5;
//		
//		Page<EmployeeEntity> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
//		List<EmployeeEntity> listEmployees = page.getContent();
//		
//		model.addAttribute("currentPage", pageNo);
//		model.addAttribute("totalPages", page.getTotalPages());
//		model.addAttribute("totalItems", page.getTotalElements());
//		
//		model.addAttribute("sortField", sortField);
//		model.addAttribute("sortDir", sortDir);
//		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
//		
//		model.addAttribute("listEmployees", listEmployees);
//		return "index";
//	}



 


   
 
    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        @RequestParam(defaultValue = "empId") String sortBy)
    {
        List<EmployeeEntity> list = service.getAllEmployees(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("empId") Long empId)
                                                    throws RecordNotFoundException {
        EmployeeEntity entity = service.getEmployeeById(empId);
 
        return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(EmployeeEntity employee)
                                                    throws RecordNotFoundException {
        EmployeeEntity updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{empId}")
    public HttpStatus deleteEmployeeById(@PathVariable("empId") Long empId)
                                                    throws RecordNotFoundException {
        service.deleteEmployeeById(empId);
        return HttpStatus.FORBIDDEN;
    }
 
}