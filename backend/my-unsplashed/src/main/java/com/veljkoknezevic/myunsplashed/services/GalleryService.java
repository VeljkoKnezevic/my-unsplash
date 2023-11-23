package com.veljkoknezevic.myunsplashed.services;

import com.veljkoknezevic.myunsplashed.entities.Gallery;
import com.veljkoknezevic.myunsplashed.respositories.GalleryRepository;
import com.veljkoknezevic.myunsplashed.util.ImageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
public class GalleryService {

    private final GalleryRepository galleryRepository;

    public GalleryService(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    public List<Gallery> getAllImages() {
        Iterable<Gallery> galleries = galleryRepository.findAll();
        List<Gallery> galleryList = new ArrayList<>();
        galleries.forEach(gallery -> {
            try {
                gallery.setImage(ImageHelper.decompressImage(gallery.getImage()));
                galleryList.add(gallery);
            } catch (DataFormatException | IOException e) {
                throw new RuntimeException(e);
            }
        });
        return galleryList;
    }

    public Gallery findGalleryByLabel(String label) {
        Optional<Gallery> galleryOptional = galleryRepository.findByLabel(label);
        Gallery gallery = galleryOptional.orElse(null);

        try {
            assert gallery != null;
            gallery.setImage(ImageHelper.decompressImage(gallery.getImage()));
        } catch (DataFormatException | IOException e) {
            throw new RuntimeException(e);
        }

        return gallery;

    }

    public Gallery uploadGallery(String label, MultipartFile file) {
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

    public void deleteGallery(String label) {
        galleryRepository.deleteByLabel(label);
    }

}
