package com.hbo.secretmanagement.secretmanagement.web;

import com.hbo.secretmanagement.secretmanagement.dto.SecretDto;
import com.hbo.secretmanagement.secretmanagement.entity.Album;
import com.hbo.secretmanagement.secretmanagement.repository.AlbumRepository;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SecretController {

    @Value("${secret.management.value}") private String secret;

    @Value("${custom.config.from.vault}") private String anotherSecret;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private MongoDbFactory mongoFactory;

    @ResponseBody
    @RequestMapping(value = "secret", method= RequestMethod.GET, produces = "application/json")
    public SecretDto secret() {
        return new SecretDto(secret);
    }

    @ResponseBody
    @RequestMapping(value = "secret2", method= RequestMethod.GET, produces = "application/json")
    public SecretDto secret2() {
        return new SecretDto(anotherSecret);
    }


    @ResponseBody
    @RequestMapping(value = "albums", method= RequestMethod.GET, produces = "application/json")
    public List<Album> albums() {
        return albumRepository.findAll();
    }

}
