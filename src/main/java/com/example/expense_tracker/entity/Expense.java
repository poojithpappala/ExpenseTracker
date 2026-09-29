package com.example.expense_tracker.entity;
import java.math.BigDecimal;

public class Expense {
    private long id;
    private String title;
    private BigDecimal amount;
    private String category;

    public Expense(){}

    public Expense(long id, String title, BigDecimal amount, String category){
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
    }

    public long getid(){
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

}
