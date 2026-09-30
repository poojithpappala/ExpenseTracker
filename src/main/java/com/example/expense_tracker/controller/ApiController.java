package com.example.expense_tracker.controller;
import java.util.List;
import com.example.expense_tracker.entity.Expense;
import com.example.expense_tracker.repository.ExpenseRepository;

import org.springframework.web.bind.annotation.RestController;
//import java.math.BigDecimal;

//imports for get
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//imports for post
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

//imports for delete
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class ApiController{

    private final ExpenseRepository expenseRepository;
    public ApiController(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }


    //GET
    @GetMapping("/")
    public String returnHomepage(){
        return "Sup bro! welcome!";
    }

    @GetMapping("/api/expenses")
    public List<Expense> getExpenses(){
        return expenseRepository.findAll();
    }
    @GetMapping("/api/expenses/{id}")
    public Expense getExpense(@PathVariable long id){
        return expenseRepository.findById(id).orElseThrow();    
    }


    //POST
    @PostMapping("/api/expenses")
    @ResponseStatus(HttpStatus.CREATED)
    public Expense postExpenses(@RequestBody Expense expense){
        System.out.println("a new post has been made");
        return expenseRepository.save(expense);
    }

    //DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/api/expenses/{id}")
    public void deleteExpense(@PathVariable long id){
        expenseRepository.deleteById(id);
    }

    //PUT/UPDATE

    @PutMapping("/api/expenses/{id}")
    public Expense updateExpense(@PathVariable long id, @RequestBody Expense expense){
        Expense existingExpense = expenseRepository.findById(id).orElseThrow();

        existingExpense.setTitle(expense.getTitle());
        existingExpense.setAmount(expense.getAmount());
        existingExpense.setCategory(expense.getCategory());
        System.out.println("soemthinig happened!");
        return expenseRepository.save(existingExpense);
    }
}
