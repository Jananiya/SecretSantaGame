package com.secretSanta.utils;



import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.secretSanta.model.Employee;
import com.secretSanta.model.SecretSantaAssignment;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public static List<Employee> parseEmployees(MultipartFile file) throws IOException {
        List<Employee> employees = new ArrayList<>();
        try (InputStreamReader reader = new InputStreamReader(file.getInputStream());
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {
            for (CSVRecord record : csvParser) {
                String name = record.get("Employee_Name");
                String email = record.get("Employee_EmailID");
                employees.add(new Employee(name, email));
            }
        }
        return employees;
    }


    public static List<SecretSantaAssignment> parseAssignments(MultipartFile file) throws IOException {
        List<SecretSantaAssignment> assignments = new ArrayList<>();
        try (InputStreamReader reader = new InputStreamReader(file.getInputStream());
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {
            for (CSVRecord record : csvParser) {
                String employeeName = record.get("Employee_Name");
                String employeeEmail = record.get("Employee_EmailID");
                String secretChildName = record.get("Secret_Child_Name");
                String secretChildEmail = record.get("Secret_Child_EmailID");
                assignments.add(new SecretSantaAssignment(employeeName, employeeEmail, secretChildName, secretChildEmail));
            }
        }
        return assignments;
    }
    
    public static void writeAssignmentsToCSV(List<SecretSantaAssignment> assignments, OutputStream outputStream) throws IOException{
    	Writer writer = new OutputStreamWriter(outputStream);
    	try(CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Employee Name","Employee Email","Secret Child Name","Secret Child Email"))){
    		for(SecretSantaAssignment assignment : assignments) {
    			csvPrinter.printRecord(assignment.getEmployeeName(),assignment.getEmployeeEmail(),assignment.getSecretChildName(),assignment.getSecretChildEmail());
    			
    		}
    	}
    }
}

