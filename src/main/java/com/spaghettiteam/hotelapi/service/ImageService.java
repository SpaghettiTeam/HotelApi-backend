package com.spaghettiteam.hotelapi.service;

import com.spaghettiteam.hotelapi.model.Image;
import com.spaghettiteam.hotelapi.repository.image.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image savePhoto(Image image) {
        return ImageRepository.save(image);
    }
}
