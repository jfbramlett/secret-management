package com.hbo.secretmanagement.secretmanagement.repository;

import com.hbo.secretmanagement.secretmanagement.entity.Album;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends MongoRepository<Album, String> {
}
