package com.expensetracker.app.repository;

import com.expensetracker.app.model.Expense;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

  void deleteById(Long id);

    Expense save(Expense expense);

    Optional<Expense> findById(Long id);

    List<Expense> findAll();
}
