package realWorldJava.analyzer.bank;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class StatementProcessor {

    private final List<Transaction> bankTransactions;

    public StatementProcessor(List<Transaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    // Обработка списка транзакций
    public double calculateTotalAmount() {
        double total = 0d;
        for (final Transaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public List<Transaction> selectInMonth(final List<Transaction> bankTransactions, final Month month){

        final List<Transaction> bankTransactionsInMonth = new ArrayList<>();
        for (final Transaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
    }

    public double calculateTotalInMonth(final Month month) {
        double total = 0;
        for (Transaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0;
        for (Transaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
}