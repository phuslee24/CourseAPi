package com.example.demo.SeedingData.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.Model.Language;

@Component
public class LanguageData {
    public List<Language> Data() {
        List<Language> data = new ArrayList<>();
        data.add(new Language(1, ".NET", "Code BE or MVC with C#", null));
        data.add(new Language(2, "Spring", "Code API with Java", null));
        data.add(new Language(3, "Laravel", "Code with PHP", null));
        return data;
    }
}
