package org.example;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";

        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);

        double totalBalance = org.example.TransactionAnalyzer.calculateTotalBalance(transactions);
        org.example.TransactionReportGenerator.printBalanceReport(totalBalance);

        String monthYear = "01-2024";
        int transactionsCount = org.example.TransactionAnalyzer.countTransactionsByMonth(transactions, monthYear);
        org.example.TransactionReportGenerator.printTransactionsCountByMonth(monthYear, transactionsCount);

        List<Transaction> topExpenses = org.example.TransactionAnalyzer.findTopExpenses(transactions);
        org.example.TransactionReportGenerator.printTopExpensesReport(topExpenses);
    }
}