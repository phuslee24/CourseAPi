package com.example.demo.SeedingData.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.Model.Level;

@Component
public class LevelData {
    public List<Level> Data() {
        List<Level> data = new ArrayList<>();
        data.add(new Level(1, "low", "", null));
        data.add(new Level(2, "high", "", null));
        data.add(new Level(3, "middle", "", null));
        return data;
    }
}
