package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Language;
import com.example.demo.Model.DTO.LanguageDTO;
import com.example.demo.Model.Map.Language.LanguageMapping;
import com.example.demo.Repository.LanguageRepo;
import com.example.demo.Services.IRepositoryServices.ILanguageRepo;
import com.example.demo.Utils.HttpException;
import com.example.demo.Utils.Variable;

@Service
public class LanguageService implements ILanguageRepo {

    @Autowired
    LanguageRepo _LanguageRepo;

    @Override
    public List<LanguageDTO> GetAll() {
        List<Language> languages = _LanguageRepo.findAll();
        List<LanguageDTO> languageDTOs = new ArrayList<>();
        if (languages.size() < 1) {
            throw new HttpException(404, Variable.DatabaseNull);
        }
        for (Language c : languages) {
            languageDTOs.add(LanguageMapping.getlanguage(c));
        }
        return languageDTOs;
    }

}
