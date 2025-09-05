package com.workshop.godclass.service;

import com.workshop.godclass.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class PersistanceService {
    public boolean save(Order order, double total) {
        try {
            Path p = Paths.get("orders", order.id()+".txt");
            Files.createDirectories(p.getParent());
            Files.writeString(p, order.id()+","+total+","+ LocalDateTime.now());
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}
