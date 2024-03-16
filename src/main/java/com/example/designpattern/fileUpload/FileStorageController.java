package com.example.designpattern.fileUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping
public class FileStorageController {

	@Autowired
    private FileStorageService fileStorageService;
//
//	 @PostMapping("/upload-single-file")
//	    public UploadFileResponse uploadSingleFile(@RequestParam("file") MultipartFile file) {
//	        String fileName = fileStorageService.storeFile(file);
//
//	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//	                .path("/download-file/")
//	                .path(fileName)
//	                .toUriString();
//
//	        return new UploadFileResponse(fileName, fileDownloadUri,
//	                file.getContentType(), file.getSize());
//	    }
//
//	 @PostMapping("/upload-multiple-files")
//	    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//	        return Arrays.asList(files)
//	                .stream()
//	                .map(file -> uploadSingleFile(file))
//	                .collect(Collectors.toList());
//	    }
//
//	    @GetMapping("/download-file/{fileName:.+}")
//	    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
//	        // Load file as Resource
//	        Resource resource = fileStorageService.loadFileAsResource(fileName);
//
//	        // Try to determine file's content type
//	        String contentType = null;
//	        try {
//	            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//	        } catch (IOException ex) {
//	            System.out.print("Could not determine file type.");
//	        }
//
//	        // Fallback to the default content type if type could not be determined
//	        if(contentType == null) {
//	            contentType = "application/octet-stream";
//	        }
//
//	        return ResponseEntity.ok()
//	                .contentType(MediaType.parseMediaType(contentType))
//	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//	                .body(resource);
//	    }

	@PostMapping("/a")
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {

		System.out.println("File get successfully");
		fileStorageService.storeFile(file);
//		redirectAttributes.addFlashAttribute("message",
//				"You successfully uploaded " + file.getOriginalFilename() + "!");

		return "redirect:/";
	}
}
