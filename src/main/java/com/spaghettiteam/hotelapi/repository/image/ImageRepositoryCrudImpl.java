package com.spaghettiteam.hotelapi.repository.image;

import com.spaghettiteam.hotelapi.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ImageRepositoryCrudImpl implements ImageRepository {

    @Autowired
    private ImageCrudRepository imageCrudRepository;

    @Override
    public Image save(Image image) {
        return imageCrudRepository.save(image);
    }

    @Override
    public Optional<Image> findById(long id) {
        return imageCrudRepository.findById(id);
    }
}
