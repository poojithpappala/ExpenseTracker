package com.example.expense_tracker.services;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.expense_tracker.entity.Expense;
import com.example.expense_tracker.repository.ExpenseRepository;


@Service
public class ExpenseService{
    private final ExpenseRepository expenseRepository;

    ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    //get methods
    public List<Expense> getExpenses(){
        return expenseRepository.findAll();
    }

    public Expense getExpense(long id){
        return expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("there's no expense with this id"));
    }

    //post methods
    public Expense postExpense(Expense expense){
        return expenseRepository.save(expense);
    }

    //delete method
    public void deleteExpense(long id){
        expenseRepository.deleteById(id);
    }

    //put method
    public Expense updateExpense(Expense expense, long id){
        Expense existingExpense = expenseRepository.findById(id).orElseThrow();

        existingExpense.setTitle(expense.getTitle());
        existingExpense.setAmount(expense.getAmount());
        existingExpense.setCategory(expense.getCategory());

        return expenseRepository.save(existingExpense);
    }


    
}
