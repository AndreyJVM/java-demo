package realWorldJava.analyzer;

import realWorldJava.analyzer.bank.statement.StatementAnalyzer;
import realWorldJava.analyzer.bank.statement.StatementParser;

import java.io.IOException;

public class MainApplication {
    public static void main(final String... args) throws IOException {
        final StatementAnalyzer bankStatementAnalyzer =
                new StatementAnalyzer();

        final StatementParser bankStatementParser =
                new StatementParser();

        bankStatementAnalyzer.analyze(args[0], bankStatementParser);
    }
}