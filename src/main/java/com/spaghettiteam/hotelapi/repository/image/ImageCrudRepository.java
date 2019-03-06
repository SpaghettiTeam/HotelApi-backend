package com.spaghettiteam.hotelapi.repository.image;

import com.spaghettiteam.hotelapi.model.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageCrudRepository extends CrudRepository<Image, Long> {
}
