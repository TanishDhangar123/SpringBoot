package com.dhangar.JournalApp.service;

import com.dhangar.JournalApp.entity.JournalEntry;
import com.dhangar.JournalApp.entity.Users;
import com.dhangar.JournalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository; //This is an example of implementation of an Interface

    @Autowired
    private UserService userService;


    @Transactional
    public void SaveEntry(JournalEntry journalEntry, String userName){
        Users user = userService.findbyuserName(userName);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved = journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.saveUser(user);

    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    //Optional is like a box where we can either return a value or we can return nothing i.e null
    public Optional<JournalEntry> findByid(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void deletebyId(ObjectId id, String userName){
        Users user = userService.findbyuserName(userName);
        boolean remove = user.getJournalEntries().removeIf(x -> x.getId().equals(id));

        if(remove){
            userService.saveUser(user);
            journalEntryRepository.deleteById(id);

        }

    }


}
