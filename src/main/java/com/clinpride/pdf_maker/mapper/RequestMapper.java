package com.clinpride.pdf_maker.mapper;

import com.clinpride.pdf_maker.model.Employee;
import com.clinpride.pdf_maker.model.RequestModel;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class RequestMapper {
    public Context setData(RequestModel requestModel) {

        Context context = new Context();

        Map<String, Object> data = new HashMap<>();

        data.put("request", requestModel);

        context.setVariables(data);

        return context;
    }
}
