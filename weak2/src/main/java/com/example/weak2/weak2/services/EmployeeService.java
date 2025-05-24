package com.example.weak2.weak2.services;

import com.example.weak2.weak2.Dto.EmployeeDto;
import com.example.weak2.weak2.Reposatory.EmployeeRepository;
import com.example.weak2.weak2.entity.EmployeeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.cglib.core.ReflectUtils;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
//package com.example.weak2.weak2.Utils;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper, EmployeeEntity employeeEntity) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public List<EmployeeDto> findAll() {
        List<EmployeeEntity> employeeEntity = employeeRepository.findAll();
        return employeeEntity.stream()
                .map((employeeEntity1 -> modelMapper.map(employeeEntity1, EmployeeDto.class)))
                .collect(Collectors.toList());


    }

    public EmployeeDto findById(long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        //ModelMapper mapper = new ModelMapper(); //THis mapper is used multiple time so we make bean of it
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }

//    public List<EmployeeEntity> findAllEmployee() {
//
//    }

    public EmployeeDto save(EmployeeDto input) {
        EmployeeEntity employeeEntity = modelMapper.map(input, EmployeeEntity.class);
        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);

        return modelMapper.map(savedEmployee, EmployeeDto.class);

    }

    public EmployeeDto updateEmployeeById(EmployeeDto employeeDto, Long EmpId) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
        employeeEntity.setId(EmpId);
        EmployeeEntity savedEmpEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmpEntity, EmployeeDto.class);
    }


    public boolean isExists(Long empId) {
        return employeeRepository.existsById(empId);
    }

    public boolean deleteEmployee(Long empId) {
        boolean exits = isExists(empId);
        if (!exits) return false;
        employeeRepository.deleteById(empId);
        return true;
    }

    public EmployeeDto updatepartialEmpById(Long employeeId, Map<String, Object> updates) {
        boolean exits = isExists(employeeId);
        if (!exits) return null;
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
        });
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDto.class);
    }
}
