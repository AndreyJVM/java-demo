package realWorldJava.analyzer.bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StatementParser implements IStatementParser {

    private final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public Transaction parserFrom(final String line) {
        final String[] columns = line.split(",");

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new Transaction(date, amount, description);
    }

    @Override
    public List<Transaction> parseLinesFrom(final List<String> lines) {
        final List<Transaction> bankTransactions = new ArrayList<>();

        for (final String line: lines) {
            bankTransactions.add(parserFrom(line));
        }
        return bankTransactions;
    }
}