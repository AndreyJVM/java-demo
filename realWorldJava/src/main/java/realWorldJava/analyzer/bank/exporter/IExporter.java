package realWorldJava.analyzer.bank.exporter;

import realWorldJava.analyzer.bank.SummaryStatistics;

public interface IExporter {
    String export (SummaryStatistics summaryStatistics);
}