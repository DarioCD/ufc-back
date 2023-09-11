package com.ufc.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFilesService {

	public static String DIRECTORIO_UPLOAD = "uploads";

	public Path getPath(String photoName) {
		return Paths.get(DIRECTORIO_UPLOAD).resolve(photoName).toAbsolutePath();
	}

	public Path getStaticPath(String photoName) {
		return Paths.get("src/main/resources/static/images").resolve(photoName).toAbsolutePath();
	}

	public Resource load(String photoName) throws MalformedURLException {
		Path filePath = getPath(photoName);
		System.out.println("Path-----" + filePath.toString());

		Resource resource = new UrlResource(filePath.toUri());

		if (!resource.exists() && !resource.isReadable()) {
			filePath = Paths.get("src/main/resources/static/images").resolve("Default.png").toAbsolutePath();
			resource = new UrlResource(filePath.toUri());
			System.out.println("Error al cargar imagen-----" + photoName);
		}
		return resource;
	}

	public String copy(MultipartFile file) throws IOException {
		String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replace(" ", "");

		Path filePath = getPath(fileName);
		System.out.println(filePath.toString());

		Files.copy(file.getInputStream(), filePath);
		return fileName;
	}

	public Boolean delete(String photoName) {
		if (photoName != null && photoName.length() > 0) {
			Path lastPhotoPath = Paths.get("uploads").resolve(photoName).toAbsolutePath();
			File lastPhotoFile = lastPhotoPath.toFile();
			if (lastPhotoFile.exists() && lastPhotoFile.canRead()) {
				lastPhotoFile.delete();
				return true;
			}
		}
		return false;
	}
}
