package com.clinpride.pdf_maker.generator;

import com.clinpride.pdf_maker.document.RequestGenerator;
import com.clinpride.pdf_maker.mapper.RequestMapper;
import com.clinpride.pdf_maker.model.RequestModel;
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

import java.util.Base64;

@RestController
@AllArgsConstructor
public class RequestDocument {
    private RequestGenerator requestGenerator;
    private SpringTemplateEngine springTemplateEngine;
    private RequestMapper requestMapper;

    @PostMapping(value = "/generate/mydocument")
    public ResponseEntity<String> generateDocument(@RequestBody RequestModel requestModel) {

        // Generate the document content
        Context dataContext = requestMapper.setData(requestModel);
        String finalHtml = springTemplateEngine.process("template", dataContext);

        // Convert HTML to PDF bytes
        byte[] pdfBytes = requestGenerator.htmlToPdf(finalHtml);

        if (pdfBytes != null) {
            // Encode PDF bytes to Base64
            String base64Pdf = Base64.getEncoder().encodeToString(pdfBytes);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            return new ResponseEntity<>(base64Pdf, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
