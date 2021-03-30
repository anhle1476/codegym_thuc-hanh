package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Arrays;

public class UploadForm {
    private String description;
    private MultipartFile[] files;

    public UploadForm() {
    }

    public UploadForm(String description, MultipartFile[] files) {
        this.description = description;
        this.files = files;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "UploadForm{" +
                "description='" + description + '\'' +
                ", files=" + Arrays.toString(files) +
                '}';
    }
}
