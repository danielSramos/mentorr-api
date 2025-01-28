package br.com.unifap.mentorr.util;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Service
public class ImageConverterService {

    public byte[] convertImageToBytes(String imagePath) throws IOException {
        Path path = Paths.get(imagePath);
        return Files.readAllBytes(path);
    }

    public String encodeImage(byte[] imageBytes) throws IOException {
        return Base64.getEncoder().encodeToString(imageBytes);
    }

}
