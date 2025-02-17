package com.secretSanta.controller;
//@CrossOrigin(origins="http://localhost:3000")

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.secretSanta.model.SecretSantaAssignment;
import com.secretSanta.service.SecretSantaService;
import com.secretSanta.utils.CSVUtils;

import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.util.List;

@CrossOrigin(origins="http://localhost:3000")

@RestController
@RequestMapping("/secret-santa")
public class SecretSantaController {

    @Autowired
    private SecretSantaService secretSantaService;

  
    @PostMapping("/assign")
    public ResponseEntity<byte[]> assignSecretSanta(
            @RequestParam("employeesFile") MultipartFile employeesFile,
            @RequestParam("previousAssignmentsFile") MultipartFile previousAssignmentsFile) throws IOException {

       
        List<SecretSantaAssignment> assignments = secretSantaService.assignSecretSanta(employeesFile, previousAssignmentsFile);

      
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        CSVUtils.writeAssignmentsToCSV(assignments, byteArrayOutputStream);

       
        byte[] csvData = byteArrayOutputStream.toByteArray();

       
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=secret_santa_assignments.csv")
                .body(csvData);
    }
}

