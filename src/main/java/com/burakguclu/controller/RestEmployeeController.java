package com.burakguclu.controller;

import com.burakguclu.dto.DtoEmployee;
import com.burakguclu.model.RootEntity;

public interface RestEmployeeController {

	public RootEntity<DtoEmployee> findDtoEmployee(Long id);
}
