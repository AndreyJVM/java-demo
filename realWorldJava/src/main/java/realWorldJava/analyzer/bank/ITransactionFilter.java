package realWorldJava.analyzer.bank;

@FunctionalInterface
public interface ITransactionFilter {
    boolean test(Transaction transaction);
}