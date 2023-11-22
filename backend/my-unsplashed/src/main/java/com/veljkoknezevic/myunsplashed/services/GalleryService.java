package com.veljkoknezevic.myunsplashed.services;

import com.veljkoknezevic.myunsplashed.entities.Gallery;
import com.veljkoknezevic.myunsplashed.respositories.GalleryRepository;
import com.veljkoknezevic.myunsplashed.util.ImageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class GalleryService {

    private final GalleryRepository galleryRepository;

    public GalleryService(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    public Gallery uploadImage(String label, MultipartFile file) {
        Gallery gallery = new Gallery();

        try {
            gallery.setLabel(label);
            gallery.setImage(ImageHelper.compressImage(file.getBytes()));
            galleryRepository.save(gallery);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return gallery;
    }

}
