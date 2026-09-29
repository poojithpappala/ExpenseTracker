package com.example.expense_tracker.controller;

import com.example.expense_tracker.entity.Expense;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import org.springframework.boot.webmvc.error.ErrorController;
import org.springframework.http.HttpStatus;
//importing get annotation
import org.springframework.web.bind.annotation.GetMapping;

//importing post annotation
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//normal requests
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class ApiController implements ErrorController{
    
    @RequestMapping("/error")
    public ResponseEntity<Map<String,Object>> handleError(HttpServletRequest request){

    }


    @GetMapping("/")
    public String returnHomepage(){
        return "Sup bro! welcome!";
    }

    @GetMapping("/api/expenses")
    public Expense getExpenses(){
        return new Expense(
            1L,
            "Puzzles",
            new BigDecimal("420.69"),
            "Sport"
        );
    }

    @PostMapping("/api/expenses")
    @ResponseStatus(HttpStatus.CREATED)
    public Expense postExpenses(@RequestBody Expense expense){
        System.out.println("a new post has been made");
        return expense;
    }
}
