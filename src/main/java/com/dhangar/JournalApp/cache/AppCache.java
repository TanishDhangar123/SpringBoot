package com.dhangar.JournalApp.cache;

import com.dhangar.JournalApp.entity.ConfigJournalAppEntitiy;
import com.dhangar.JournalApp.repository.ConfigJournalApprepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    @Autowired
    private ConfigJournalApprepository configJournalApprepository;

    public Map<String, String> APP_CACHE = new HashMap<>();


    @PostConstruct
    public void init(){
        List<ConfigJournalAppEntitiy> all = configJournalApprepository.findAll();

        for(ConfigJournalAppEntitiy configJournalAppEntitiy : all){
            APP_CACHE.put(configJournalAppEntitiy.getKey(), configJournalAppEntitiy.getValue());
        }
    }
}
