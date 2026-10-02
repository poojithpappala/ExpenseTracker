package com.example.expense_tracker.controller;
import java.util.List;
import com.example.expense_tracker.entity.Expense;

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

//importing Expense services
import com.example.expense_tracker.services.ExpenseService;

//importing @Valid
import jakarta.validation.Valid;

@RestController
public class ExpenseController{
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }
    //GET
    @GetMapping("/")
    public String returnHomepage(){
        return "Sup bro! welcome!";
    }

    @GetMapping("/api/expenses")
    public List<Expense> getExpenses(){
        return expenseService.getExpenses();
    }
    
    @GetMapping("/api/expenses/{id}")
    public Expense getExpense(@PathVariable long id){
        return expenseService.getExpense(id);    
    }


    //POST
    @PostMapping("/api/expenses")
    @ResponseStatus(HttpStatus.CREATED)
    public Expense postExpenses(@Valid @RequestBody Expense expense){
        System.out.println("a new post has been made");
        return expenseService.postExpense(expense);
    }

    //DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/api/expenses/{id}")
    public void deleteExpense(@PathVariable long id){
        expenseService.deleteExpense(id);;
    }

    //PUT/UPDATE
    @PutMapping("/api/expenses/{id}")
    public Expense updateExpense(@Valid @RequestBody Expense expense, @PathVariable long id){
        return expenseService.updateExpense(expense, id);
    }
    
}
