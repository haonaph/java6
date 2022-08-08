package com.poly.store.rest.controller;

import java.io.File;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.poly.store.entity.product;
import com.poly.store.service.productService;
import com.poly.store.service.uploadService;

@CrossOrigin("**")
@RestController
public class UploadRestController {
	@Autowired
	uploadService uploadService;
	
	@PostMapping("/rest/upload/{folder}")
	public JsonNode upload(@PathParam("files") MultipartFile file,
			@PathVariable("folder") String folder) {
		File savedFile=uploadService.save(file, folder);
		ObjectMapper mapper =new ObjectMapper();
		ObjectNode node =mapper.createObjectNode();
		node.put("name", savedFile.getName());
		node.put("size", savedFile.length());
		return node;
		
	}
	
}
