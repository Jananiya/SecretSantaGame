package com.secretSanta.service;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.secretSanta.model.Employee;
import com.secretSanta.model.SecretSantaAssignment;
import com.secretSanta.utils.CSVUtils;

import java.io.IOException;
import java.util.*;

@Service
public class SecretSantaServiceImpl implements SecretSantaService {

    @Override
    public List<SecretSantaAssignment> assignSecretSanta(MultipartFile employeesFile, MultipartFile previousAssignmentsFile) throws IOException {
     
        List<Employee> employees = CSVUtils.parseEmployees(employeesFile);
        List<SecretSantaAssignment> previousAssignments = CSVUtils.parseAssignments(previousAssignmentsFile);


        Collections.shuffle(employees);
        List<SecretSantaAssignment> assignments = new ArrayList<>();

        Set<String> assignedEmployees = new HashSet<>();
        for (Employee employee : employees) {
            String secretChildName = findSecretChild(employee, employees, previousAssignments, assignedEmployees);
            if(secretChildName !=null) {
            String secretChildEmail = getEmployeeEmail(secretChildName, employees);
            assignments.add(new SecretSantaAssignment(employee.getName(), employee.getEmail(), secretChildName, secretChildEmail));
            assignedEmployees.add(secretChildName);
            }else {
            	System.out.println("Error: Could not assign secret santa for"+ employee.getName());
            }
        }
        if(assignedEmployees.size()!=employees.size()) {
        	System.out.println("Not all employees were assignedf secret santa");
        }
        

        return assignments;
    }

    private String findSecretChild(Employee employee, List<Employee> employees, List<SecretSantaAssignment> previousAssignments, Set<String> assignedEmployees) {
        for (Employee potentialChild : employees) {
            if (!employee.getName().equals(potentialChild.getName()) && !assignedEmployees.contains(potentialChild.getName())) {
                
                for (SecretSantaAssignment assignment : previousAssignments) {
                    if (assignment.getEmployeeName().equals(employee.getName()) && assignment.getSecretChildName().equals(potentialChild.getName())) {
                        return null; 
                    }
                }
                return potentialChild.getName();
            }
        }
        return null;
    }

    private String getEmployeeEmail(String name, List<Employee> employees) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee.getEmail();
            }
        }
        return null;
    }
}





