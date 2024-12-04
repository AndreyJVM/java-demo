package realWorldJava.analyzer.bank.statement;

import realWorldJava.analyzer.bank.transaction.Transaction;

import java.util.List;

/** Добавление интерфейса для парсинга банковских операций*/
public interface IStatementParser {
    Transaction parserFrom(String line);
    List<Transaction> parseLinesFrom(List<String> lines);
}
