package com.veljkoknezevic.myunsplashed.controllers;

import com.veljkoknezevic.myunsplashed.entities.Gallery;
import com.veljkoknezevic.myunsplashed.services.GalleryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class GalleryController {

    private final GalleryService galleryService;
    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadImage(@RequestParam("label") String label,
                                               @RequestParam("image")MultipartFile file) {
        Gallery gallery = galleryService.uploadImage(label, file);

        return ResponseEntity.ok(gallery);
    }

}
