package com.expensetracker.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "budget_summary")
public class BudgetSummary {
    @Column(name = "total_budget")
    private double totalBudget;

    @Column(name = "total_expenses")
    private double totalExpenses;

    @Column(name = "savings")
    private double savings;

    @Column(name = "is_under_budget")
    private boolean isUnderBudget;
}
