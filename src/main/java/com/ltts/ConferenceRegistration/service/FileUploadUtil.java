package com.ltts.ConferenceRegistration.service;

import java.io.*;
import java.nio.file.*;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
		Path uploadPath = Paths.get(uploadDir);

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new IOException("Could not save image file: " + fileName, ioe);
		}
	}

	public static String convertFileIntoBase64String(String fileName) throws IOException {
		File file;
		FileInputStream fileInputStream = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		try {
			String path = "D:\\user-photos\\" + fileName;
			file = new File(path);
			System.out.println(file + "   ---------------");
			fileInputStream = new FileInputStream(file);
			byteArrayOutputStream = new ByteArrayOutputStream();
			int b;
			byte[] buffer = new byte[1024];
			while ((b = fileInputStream.read(buffer)) != -1) {
				byteArrayOutputStream.write(buffer, 0, b);
			}

			byte[] fileBytes = byteArrayOutputStream.toByteArray();
			fileInputStream.close();
			byteArrayOutputStream.close();

			byte[] encoded = Base64.encodeBase64(fileBytes);
			String encodedString = new String(encoded);
			return encodedString;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (byteArrayOutputStream != null) {
				byteArrayOutputStream.close();
			}
			if (fileInputStream != null) {
				fileInputStream.close();
			}
		}
		return new String();
	}
}
