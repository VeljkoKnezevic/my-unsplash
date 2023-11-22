package com.veljkoknezevic.myunsplashed.respositories;

import com.veljkoknezevic.myunsplashed.entities.Gallery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface GalleryRepository extends CrudRepository<Gallery,Integer> {
    Optional<Gallery> findByLabel(String label);

    @Transactional
    void deleteByLabel(String label);
}
