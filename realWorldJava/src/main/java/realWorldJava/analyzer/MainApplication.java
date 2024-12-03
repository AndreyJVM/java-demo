package realWorldJava.analyzer;

import java.io.IOException;

public class MainApplication {
    public static void main(final String... args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer =
                new BankStatementAnalyzer();

        final BankStatementParser bankStatementParser =
                new BankStatementParser();

        bankStatementAnalyzer.analyze(args[0], bankStatementParser);
    }
}