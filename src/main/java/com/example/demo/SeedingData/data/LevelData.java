package com.example.demo.SeedingData.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.Model.Level;

@Component
public class LevelData {
    public List<Level> Data() {
        List<Level> data = new ArrayList<>();
        data.add(new Level(1, "low", ""));
        data.add(new Level(2, "high", ""));
        data.add(new Level(3, "middle", ""));
        return data;
    }
}
