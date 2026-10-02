package com.example.expense_tracker.repository;

/*
    Spring data JPA gives the run-time implementation  of the JPA repository methods.
    Hibernate generates the SQL to talk with DBs
    JDBC is low-level Java API used to communicate with DB, the sql queries by hibernate are sent by JDBC
*/

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.expense_tracker.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{
    
}
