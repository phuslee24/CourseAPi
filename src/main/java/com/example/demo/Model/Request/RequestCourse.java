package com.example.demo.Model.Request;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestCourse {
    @Nullable
    private String lesson;
    @Nullable
    private String description;
    @Nullable
    private String term;

    @Nullable
    private int language_id;
    @Nullable
    private int level_id;
    @Nullable
    private int category_id;

    
}
