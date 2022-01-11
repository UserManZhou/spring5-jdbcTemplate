package com.gec.jdbc.entity;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component(value = "Note")
@Scope(value = "prototype")
public class Note {
    private  int id;
    private String title;
    private String summary;
    private String context;
    private Timestamp createtime;
}
