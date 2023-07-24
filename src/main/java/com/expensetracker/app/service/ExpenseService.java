package com.expensetracker.app.service;

import com.expensetracker.app.model.BudgetSummary;
import com.expensetracker.app.model.Expense;
import com.expensetracker.app.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    public BudgetSummary calculateBudgetSummary(double totalBudget) {
        List<Expense> allExpenses = getAllExpenses();

        double totalExpenses = allExpenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();

        double savings = totalBudget - totalExpenses;
        boolean isUnderBudget = savings >= 0;

        BudgetSummary budgetSummary = new BudgetSummary(totalBudget, totalExpenses, savings, isUnderBudget);
        return budgetSummary;
    }
}
