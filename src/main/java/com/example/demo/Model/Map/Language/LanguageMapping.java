package com.example.demo.Model.Map.Language;

import com.example.demo.Model.Language;
import com.example.demo.Model.DTO.LanguageDTO;

public class LanguageMapping {
        public static LanguageDTO getlanguage(Language c) {
                LanguageDTO languageDTO = new LanguageDTO();
                languageDTO.setId(c.getId());
                if (c.getName() != null) {
                        languageDTO.setName(c.getName());
                }
                if (c.getDescription() != null) {
                        languageDTO.setDescription(c.getDescription());
                }
                return languageDTO;
        }
}
