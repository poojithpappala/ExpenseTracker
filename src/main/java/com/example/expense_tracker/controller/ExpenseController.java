package com.example.expense_tracker.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.expense_tracker.entity.Expense;


@RestController
public class ExpenseController{
    
    @GetMapping("/api/expenses")
    public Expense getExpenses(){
        return new Expense(
            1L,
            "Lunch",
            new BigDecimal("250.00"),
            "FOOD"  
        );
    }
}