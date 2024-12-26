package realWorldJava.analyzer;

import realWorldJava.analyzer.bank.exporter.HTMLExporter;
import realWorldJava.analyzer.bank.exporter.IExporter;
import realWorldJava.analyzer.bank.statement.StatementAnalyzer;
import realWorldJava.analyzer.bank.statement.StatementParser;

public class MainApplication {
    public static void main(final String... args) throws Exception {
        final StatementAnalyzer bankStatementAnalyzer =
                new StatementAnalyzer();

        final StatementParser bankStatementParser =
                new StatementParser();

        final IExporter exporter = new HTMLExporter();

        bankStatementAnalyzer.analyze("Exporter.csv", bankStatementParser, exporter);
    }
}