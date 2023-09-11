package com.ufc.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ufc.entity.Fight;
import com.ufc.entity.Fighter;
import com.ufc.service.FighterService;
import com.ufc.service.UploadFilesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ufc/v1")
public class FighterController {

	@Autowired
	FighterService fighterService;
	
	@Autowired
	UploadFilesService uploadFilesService;
	
	@PostMapping("/fighter")
	public ResponseEntity<?> addFighter(@RequestBody Fighter fighter){
		try {
			return new ResponseEntity<>(fighterService.addFighter(fighter), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/fighter")
	public List<Fighter> getAllFighters(){
		return fighterService.getAllFighters();
	}
	
	@GetMapping("/fighter/{id}")
	public Fighter getFighterById(@PathVariable Long id){
		return fighterService.getFighterById(id);
	}
	
	@GetMapping("/fighter/fight/{id}")
	public Set<Fight> getAllFights(@PathVariable Long id){
		return fighterService.getAllFights(id);
	}
	
	@GetMapping("/fighter/name/{name}/nickname/{nickname}")
	public List<Fighter> getFighterByNameAndNickname(@PathVariable String name, @PathVariable String nickname){
	    return fighterService.getFighterByNameAndNickname(name, nickname);
	}
	
	@PostMapping("/fighter/upload")
	public ResponseEntity<?> uploadPhoto(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {
		HashMap<String, Object> response = new HashMap<>();
		System.out.println("id-------"+id);
		Fighter fighter = fighterService.getFighterById(id);
		
		if (!file.isEmpty()) {
			String fileName = null;
			try {
				fileName = uploadFilesService.copy(file);
			} catch (IOException e) {
				response.put("message", "Error al subir la imagen del cliente");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			System.out.println("cliente------");
			System.out.println(fighter);
			String lastPhotoName = fighter.getFighterPhoto();
			uploadFilesService.delete(lastPhotoName);
			
			fighter.setFighterPhoto(fileName);
			fighterService.addFighter(fighter);
			
			//Fighter newClientWithoutPassword = new Client();
			//BeanUtils.copyProperties(fighter, newClientWithoutPassword, "password");
			
			response.put("client", fighter);
			response.put("message", "Has subido correctamente la imagen ".concat(fileName));
		}
		
		return new ResponseEntity<HashMap<String, Object>>(response , HttpStatus.CREATED);
	}
	
	@GetMapping("/uploads/img/{photoName:.+}")
	public ResponseEntity<Resource> viewPhoto(@PathVariable String photoName) {
		
		Resource resource = null;
		
		try {
			 resource = uploadFilesService.load(photoName);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + resource.getFilename() + "\"");
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}

}
