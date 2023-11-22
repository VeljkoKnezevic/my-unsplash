package com.veljkoknezevic.myunsplashed.respositories;

import com.veljkoknezevic.myunsplashed.entities.Gallery;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GalleryRepository extends CrudRepository<Gallery,Integer> {
    Optional<Gallery> findByLabel(String label);
}
