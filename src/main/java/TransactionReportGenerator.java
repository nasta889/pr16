package org.example;
import java.util.List;

import static java.lang.System.*;

public abstract class TransactionReportGenerator {
    public static void printBalanceReport(double totalBalance) {
        out.println("Загальний баланс: " + totalBalance);
    }

    public static void printTransactionsCountByMonth(String monthYear, int count) {
        out.println("Кількість транзакцій за " + monthYear + ": " + count);
    }

    public static void printTopExpensesReport(List<Transaction> topExpenses) {
        out.println("10 найбільших витрат:");
        for (Transaction expense : topExpenses) {
            out.println(STR."\{expense.getDescription()}: \{expense.getAmount()}");
        }
    }
}