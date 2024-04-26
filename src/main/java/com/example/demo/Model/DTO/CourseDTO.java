package com.example.demo.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private int id;
    private String lesson;
    private String description;
    private String term;
    private CategoryDTO category;
    private LanguageDTO language;
    private LevelDTO level;
}
