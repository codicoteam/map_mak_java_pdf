package com.clinpride.pdf_maker.mapper;


import com.clinpride.pdf_maker.model.Employee;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataMapper {

    public Context setData(List<Employee> empolyeeList) {

        Context context = new Context();

        Map<String, Object> data = new HashMap<>();

        data.put("employees", empolyeeList);

        context.setVariables(data);

        return context;
    }
}