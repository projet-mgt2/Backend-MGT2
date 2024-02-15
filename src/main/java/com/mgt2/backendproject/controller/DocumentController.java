package com.mgt2.backendproject.controller;

import com.mgt2.backendproject.model.entity.Document;
import com.mgt2.backendproject.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping("/Documents")
    public List<Document> getAllDocument() throws IOException {
        return documentService.getAllDocuments();
    }

    @GetMapping("/Document/{id}")
    public Optional<Document> getDocumentById(@PathVariable Integer id){
        return documentService.getDocumentById(id);
    }

    @PostMapping("/Document")
    public ResponseEntity<Document> createDocument(@RequestParam("file") MultipartFile document) {
        Document createdDocument = documentService.createDocument(document);
        return ResponseEntity.ok().body(createdDocument);
    }

    @PutMapping("/Document/update/{id}")
    public Document updateDocument(@PathVariable Integer id, @RequestBody Document updateDocument) {
        return documentService.updateDocument(id, updateDocument);
    }

    @DeleteMapping("/Document/Delete/{id}")
    public void deleteDocumentById(@PathVariable Integer id) {
        documentService.deleteDocumentById(id);
    }
}
