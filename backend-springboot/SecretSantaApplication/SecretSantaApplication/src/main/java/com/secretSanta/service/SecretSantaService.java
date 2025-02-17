package com.secretSanta.service;

import org.springframework.web.multipart.MultipartFile;

import com.secretSanta.model.SecretSantaAssignment;

import java.io.IOException;
import java.util.List;

public interface SecretSantaService {
    List<SecretSantaAssignment> assignSecretSanta(MultipartFile employeesFile, MultipartFile previousAssignmentsFile) throws IOException;
}
