package com.spaghettiteam.hotelapi.rest;

import com.spaghettiteam.hotelapi.model.Image;
import com.spaghettiteam.hotelapi.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/api/image/")
    public Image addImageForRoomId( @RequestBody Image image)
    {
        return imageService.savePhoto(image);
    }
}
