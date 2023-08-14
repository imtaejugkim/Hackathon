package com.konkuk.hackerthonrelay.pictureupload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageUploadService {

	private final ImageRepository imageRepository;

	public ImageUploadService(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}

	public Image uploadImage(MultipartFile multipartFile) throws IOException {
		// Define the path for the uploaded image
		Path uploadDir = Paths.get("src/main/resources/static/uploads");
		if (!Files.exists(uploadDir)) {
			Files.createDirectories(uploadDir);
		}
		Path destination = Paths.get(uploadDir.toString(), multipartFile.getOriginalFilename());
		multipartFile.transferTo(destination);

		// Save the web-accessible path in the database
		Image image = new Image();
		image.setPath("/uploads/" + multipartFile.getOriginalFilename()); // 변경된 부분
		imageRepository.save(image);

		return image; // Return the Image object instead of a String
	}

}
