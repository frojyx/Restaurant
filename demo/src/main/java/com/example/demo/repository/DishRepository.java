package com.example.demo.repository;

import com.example.demo.entity.Dish;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    @NonNull
    // Решение N+1: выгружаем блюдо сразу с категорией и ингредиентами за 1 запрос
    @EntityGraph(attributePaths = {"category", "ingredients"})
    List<Dish> findAll();

    List<Dish> findByNameIn(List<String> names);

    List<Dish> findByPrice(double price);
}
