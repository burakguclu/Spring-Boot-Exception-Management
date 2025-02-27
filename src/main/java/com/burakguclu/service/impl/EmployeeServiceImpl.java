package com.burakguclu.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burakguclu.dto.DtoDepartment;
import com.burakguclu.dto.DtoEmployee;
import com.burakguclu.exception.BaseException;
import com.burakguclu.exception.ErrorMessage;
import com.burakguclu.model.Department;
import com.burakguclu.model.Employee;
import com.burakguclu.repository.EmployeeRepository;
import com.burakguclu.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public DtoEmployee findEmployeeById(Long id) {
		DtoEmployee dtoEmployee = new DtoEmployee();
		DtoDepartment dtoDepartment = new DtoDepartment();

		Optional<Employee> opt = employeeRepository.findById(id);
		if (opt.isEmpty()) {
			throw new BaseException(
					new ErrorMessage(com.burakguclu.exception.MessageType.NO_RECORD_EXIST, id.toString()));
		}

		Employee employee = opt.get();
		Department department = employee.getDepartment();

		BeanUtils.copyProperties(employee, dtoEmployee);
		BeanUtils.copyProperties(department, dtoDepartment);

		dtoEmployee.setDepartment(dtoDepartment);

		return dtoEmployee;
	}

}
