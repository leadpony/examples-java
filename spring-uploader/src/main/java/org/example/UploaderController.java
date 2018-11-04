package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;

@Controller
public class UploaderController {
    
    @GetMapping("/")
    public String displayForm() {
        return "uploadForm";
    }

    @PostMapping("/")
    public String handleUploadedFile(@RequestPart("file") Part file, Model model) throws IOException {
        storeFile(file);
        model.addAttribute("filename", file.getSubmittedFileName());
        model.addAttribute("size", file.getSize());
        return "uploadResult";
    }
    
    private void storeFile(Part file) throws IOException {
        Path path = Paths.get(System.getProperty("user.home"), file.getSubmittedFileName());
        file.write(path.toString());
    }
}
