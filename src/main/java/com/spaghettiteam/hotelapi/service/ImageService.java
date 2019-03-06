package com.spaghettiteam.hotelapi.service;

import com.spaghettiteam.hotelapi.exception.RoomNotFoundException;
import com.spaghettiteam.hotelapi.model.Image;
import com.spaghettiteam.hotelapi.model.Room;
import com.spaghettiteam.hotelapi.repository.image.ImageRepository;
import com.spaghettiteam.hotelapi.repository.room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private RoomRepository roomRepository;

    public Image savePhoto(Image newImage) {
        roomRepository.findById(newImage.getRoomId()).orElseThrow(RoomNotFoundException::new);
        imageRepository.save(newImage);
        return newImage;
    }
}
