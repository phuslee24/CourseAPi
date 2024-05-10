package com.example.demo.Model.Request;

import org.springframework.web.multipart.MultipartFile;

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
    public String lesson;
    @Nullable
    public String description;
    @Nullable
    public String term;

    @Nullable
    public MultipartFile file;

    @Nullable
    public int language_id;
    @Nullable
    public int level_id;
    @Nullable
    public int category_id;

    
}
