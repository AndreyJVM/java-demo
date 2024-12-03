package realWorldJava.analyzer;

import java.util.List;

public interface IBankStatementParser {
    BankTransaction parserFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
