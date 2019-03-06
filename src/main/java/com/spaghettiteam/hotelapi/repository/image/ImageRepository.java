package com.spaghettiteam.hotelapi.repository.image;
import com.spaghettiteam.hotelapi.model.Image;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository {
    Optional<Image> findById(long id);
    Image save(Image image);
}
