package com.expensetracker.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "budget_summary")
public class BudgetSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_budget")
    private double totalBudget;

    @Column(name = "total_expenses")
    private double totalExpenses;

    @Column(name = "savings")
    private double savings;

    @Column(name = "is_under_budget")
    private boolean isUnderBudget;
}
