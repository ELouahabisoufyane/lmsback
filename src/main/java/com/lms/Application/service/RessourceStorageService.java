package com.lms.Application.service;

import com.lms.Application.dao.RessourceRepository;
import com.lms.Application.entities.Ressource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class RessourceStorageService {
    @Autowired
    private RessourceRepository fileDBRepository;
    public Ressource store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Ressource FileDB = new Ressource(fileName, file.getContentType(), file.getBytes());
        return fileDBRepository.save(FileDB);
    }
    public Ressource getFile(String id) {
        return fileDBRepository.findById(id).get();
    }

    public Stream<Ressource> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }
}
