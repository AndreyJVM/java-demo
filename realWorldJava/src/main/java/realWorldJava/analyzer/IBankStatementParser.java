package realWorldJava.analyzer;

import java.util.List;

/** Добавление интерфейса для парсинга банковских операций*/
public interface IBankStatementParser {
    BankTransaction parserFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
