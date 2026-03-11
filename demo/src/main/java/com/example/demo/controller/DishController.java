package com.example.demo.controller;

import com.example.demo.dto.DishDto;
import com.example.demo.service.DishService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DishController {
    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    // CREATE
    @PostMapping("/dish")
    public DishDto createDish(@RequestBody DishDto dishDto) {
        return dishService.save(dishDto);
    }

    // READ ALL
    @GetMapping("/dishAll")
    public List<DishDto> getAllDishes() {
        return dishService.findAll();
    }

    // READ ONE
    @GetMapping("/dish/{id}")
    public DishDto getIdByDish(@PathVariable Long id) {
        return dishService.findById(id);
    }

    // UPDATE
    @PutMapping("/dish/{id}")
    public DishDto updateDish(@PathVariable Long id, @RequestBody DishDto dishDto) {
        return dishService.update(id, dishDto);
    }

    // DELETE
    @DeleteMapping("/dish/{id}")
    public void deleteDish(@PathVariable Long id) {
        dishService.deleteById(id);
    }
}
