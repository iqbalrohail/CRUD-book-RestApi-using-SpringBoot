package com.example.demo.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ImageServices {

    public final String uploadDirectory = "C:\\Users\\R\\Desktop\\BooksRestApis\\src\\main\\resources\\static\\images";

    public ResponseEntity<String> uploadImage(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File is empty");
            }
            Files.copy(file.getInputStream(), Paths.get(uploadDirectory + File.separator + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            return ResponseEntity.ok("File has successfully uploaded");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading your file");
        }
    }
}
