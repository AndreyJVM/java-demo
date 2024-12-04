package realWorldJava.analyzer.bank.transaction;

@FunctionalInterface
public interface ITransactionSummarizer {
    double summarizer(double accumulator, Transaction transaction);
}