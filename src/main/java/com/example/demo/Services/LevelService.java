package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Level;
import com.example.demo.Model.DTO.LevelDTO;
import com.example.demo.Repository.LevelRepo;
import com.example.demo.Services.IRepositoryServices.ILevelRepo;
import com.example.demo.Utils.HttpException;
import com.example.demo.Utils.Variable;

@Service
public class LevelService implements ILevelRepo {

    @Autowired
    LevelRepo _LevelRepo;

    @Override
    public List<LevelDTO> GetAll() {
        List<Level> levels = _LevelRepo.findAll();
        List<LevelDTO> levelDTOs = new ArrayList<>();

        for (Level l : levels) {
            LevelDTO levelDTO = new LevelDTO();
            levelDTO.setId(l.getId());
            if (l.getName()!=null) {
                levelDTO.setName(l.getName());
            }
            if (l.getSign()!=null) {
                levelDTO.setSign(l.getSign());
            }
            levelDTOs.add(levelDTO);
        }
        if (levels.size() < 1) {
            throw new HttpException(404, Variable.DatabaseNull);
        }
        return levelDTOs;
    }

}
