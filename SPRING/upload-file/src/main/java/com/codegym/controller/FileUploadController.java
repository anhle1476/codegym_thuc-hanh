package com.codegym.controller;

import com.codegym.model.UploadForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FileUploadController {
    @GetMapping("/")
    public String showUploadForm(@ModelAttribute UploadForm uploadForm) {
        return "index";
    }

    @GetMapping("/result")
    public String doUpload() {
        return "result";
    }

    @PostMapping("/upload")
    private String doUpload( RedirectAttributes redirectAttributes, @ModelAttribute UploadForm uploadForm) {
        MultipartFile[] files = uploadForm.getFiles();
        Map<File, String> uploadedFiles = new HashMap<>();

        for (MultipartFile file : files) {
            String name = file.getOriginalFilename();
            if (name != null && name.length() > 0 && !file.isEmpty()) {
                try {
                    File serverFile = new File("/mnt/Data/test/upload/" + name);
                    file.transferTo(serverFile);
                    uploadedFiles.put(serverFile, name);
                    System.out.println("Write file: " + serverFile);
                } catch (Exception e) {
                    System.out.println("Error Write file: " + name + ". " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }

        redirectAttributes.addFlashAttribute("description", uploadForm.getDescription());
        redirectAttributes.addFlashAttribute("uploadedFiles", uploadedFiles);
        return "redirect:/result";
    }
}
