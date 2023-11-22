package com.veljkoknezevic.myunsplashed.controllers;

import com.veljkoknezevic.myunsplashed.entities.Gallery;
import com.veljkoknezevic.myunsplashed.services.GalleryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class GalleryController {

    private final GalleryService galleryService;
    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping("/{label}")
    public ResponseEntity<?> getGalleryBasedOnLabel(@PathVariable String label) {
        Gallery gallery = galleryService.findGalleryByLabel(label);

        return ResponseEntity.ok(gallery);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllImages(){
        return ResponseEntity.ok(galleryService.getAllImages());
    }


    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadGallery(@RequestParam("label") String label,
                                               @RequestParam("image")MultipartFile file) {
        Gallery gallery = galleryService.uploadGallery(label, file);

        return ResponseEntity.ok(gallery);
    }


    @DeleteMapping("/{label}")
    public ResponseEntity<?> deleteGallery(@PathVariable String label) {
        galleryService.deleteGallery(label);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
