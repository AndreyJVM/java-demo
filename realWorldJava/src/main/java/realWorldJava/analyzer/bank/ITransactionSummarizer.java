package realWorldJava.analyzer.bank;

@FunctionalInterface
public interface ITransactionSummarizer {
    double summarizer(double accumulator, Transaction transaction);
}