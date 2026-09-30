package com.example.expense_tracker.entity;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String title;
    private BigDecimal amount;
    private String category;

    public Expense(){}

    public Expense( String title, BigDecimal amount, String category){
        
        this.title = title;
        this.amount = amount;
        this.category = category;
    }

    public long getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    //setters for spring to read the post request and to create java object
    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    //overriding the toString function to print the object
    @Override 
    public String toString(){
        return "New expense: " + title + "of " + amount ;
    }

}
