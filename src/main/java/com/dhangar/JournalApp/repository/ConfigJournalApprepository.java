package com.dhangar.JournalApp.repository;

import com.dhangar.JournalApp.entity.ConfigJournalAppEntitiy;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.User;

public interface ConfigJournalApprepository extends MongoRepository<ConfigJournalAppEntitiy, ObjectId> {

}
