package realWorldJava.analyzer.bank.statement;

import realWorldJava.analyzer.bank.transaction.Transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class StatementAnalyzer {

    private static final String RESOURCES = "src/main/resources";

    public void analyze(final String fileName, final StatementParser bankStatementParser)
            throws IOException {

        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<Transaction> bankTransactions =
                bankStatementParser.parseLinesFrom(lines);

        final StatementProcessor bankStatementProcessor =
                new StatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(StatementProcessor bankStatementProcessor) {

        System.out.println("The total for all transactions is " +
                bankStatementProcessor.calculateTotalAmount());

        System.out.println("The total transactions in January is " +
                bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total transactions in February is " +
                bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));

        System.out.println("The total salary received is " +
                bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}