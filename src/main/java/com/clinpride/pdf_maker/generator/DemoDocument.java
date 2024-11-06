package com.clinpride.pdf_maker.generator;

import com.clinpride.pdf_maker.document.DocumentGenerator;
import com.clinpride.pdf_maker.mapper.DataMapper;
import com.clinpride.pdf_maker.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.List;

@RestController
@AllArgsConstructor
public class DemoDocument {

    private DocumentGenerator documentGenerator;
    private SpringTemplateEngine springTemplateEngine;
    private DataMapper dataMapper;

    @PostMapping(value = "/generate/document")
    public ResponseEntity<byte[]> generateDocument(@RequestBody List<Employee> employeeList) {

        Context dataContext = dataMapper.setData(employeeList);
        String finalHtml = springTemplateEngine.process("template", dataContext);

        byte[] pdfBytes = documentGenerator.htmlToPdf(finalHtml);

        if (pdfBytes != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("inline", "employee_document.pdf");

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
