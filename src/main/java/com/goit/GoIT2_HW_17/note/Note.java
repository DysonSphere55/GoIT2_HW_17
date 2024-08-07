package com.goit.GoIT2_HW_17.note;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "note")
@Entity
@Data
public class Note {
    @Id
    private int id;
    private String title;
    private String content;
}
