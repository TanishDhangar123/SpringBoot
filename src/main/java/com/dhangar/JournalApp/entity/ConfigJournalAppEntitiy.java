package com.dhangar.JournalApp.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "config_journal_app")
@Getter
@Setter
@NoArgsConstructor

public class ConfigJournalAppEntitiy {

    private String key;
    private String value;

}
