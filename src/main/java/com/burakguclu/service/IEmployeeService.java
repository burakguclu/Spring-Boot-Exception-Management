package com.burakguclu.service;

import com.burakguclu.dto.DtoEmployee;
import com.burakguclu.model.Employee;

public interface IEmployeeService {

	public DtoEmployee findEmployeeById(Long id);
	
}
