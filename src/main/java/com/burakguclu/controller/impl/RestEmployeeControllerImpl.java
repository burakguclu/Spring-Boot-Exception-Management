package com.burakguclu.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burakguclu.controller.RestEmployeeController;
import com.burakguclu.dto.DtoEmployee;
import com.burakguclu.model.RootEntity;
import com.burakguclu.service.IEmployeeService;

@RestController
@RequestMapping("rest/api/employee")
public class RestEmployeeControllerImpl extends RestBaseController implements RestEmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping("/list/{id}")
	@Override
	public RootEntity<DtoEmployee> findDtoEmployee(@PathVariable(value = "id") Long id) {
		return ok(employeeService.findEmployeeById(id));
	}
}
