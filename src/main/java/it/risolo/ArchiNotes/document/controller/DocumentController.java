package it.risolo.ArchiNotes.document.controller;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.risolo.ArchiNotes.document.dto.DocumentDto;
import it.risolo.ArchiNotes.document.service.DocumentService;
import it.risolo.ArchiNotes.user.utils.UserUtils;

@RestController
@RequestMapping("/documentService")
public class DocumentController {

	private static final Logger logger = Logger.getLogger(DocumentController.class);
	
	@Autowired
	private DocumentService docService;
	
	@Autowired
	private UserUtils userUtils;
	
	@PostMapping(path="/insertDoc", produces="application/json;charset=UTF-8")
	public void insertDocument(@RequestBody DocumentDto document) {
		docService.insertDocument(document);
	}
	
	@GetMapping(path="/getDocs", produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<DocumentDto> getDocumentsByUser() {
	
		List<DocumentDto> docs = new ArrayList<>();
		try {
			String currentUserName = userUtils.getCurrentUsername();
			docs.addAll(docService.getDocumentsByUser(currentUserName));
		} catch (Exception e) {
			logger.error(e);
		}
		return docs;
		
	}
	
	@GetMapping(path="/getDoc", produces="application/json;charset=UTF-8")
	@ResponseBody
	public DocumentDto getDocumentByUser(@RequestParam String id) {
	
		DocumentDto doc = null;
		try {
			String currentUserName = userUtils.getCurrentUsername();
			 doc = docService.findByIdAndUsername(id, currentUserName);
		} catch (Exception e) {
			logger.error(e);
		}
		return doc;
		
	}
	
}
