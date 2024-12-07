package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class TransactionAnalyzer {

    // Method for calculating the total balance of all transactions
    public static double calculateTotalBalance(List<Transaction> transactions) {
        return transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    // Method for counting transactions in a specified month (format "MM-yyyy")
    public static int countTransactionsByMonth(List<Transaction> transactions, String monthYear) {
        return (int) transactions.stream()
                .filter(t -> t.getDate().contains(monthYear)) // Check the date for the presence of month and year
                .count();
    }

    // Method for finding the 10 largest expenses (amounts less than 0)
    public static List<Transaction> findTopExpenses(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0) // Only negative amounts
                .sorted(Comparator.comparing(Transaction::getAmount)) // Sort in ascending order (from -large to small)
                .limit(10) // Select only the first 10 elements
                .collect(Collectors.toList());
    }
}