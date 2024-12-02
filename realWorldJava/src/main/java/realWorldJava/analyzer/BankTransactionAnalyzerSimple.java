package realWorldJava.analyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Задачи поставленные перед классом:
 */
// - Какова общая сумма начислений и списаний по списку операций? (Отрицательная или положительная?)
// - Сколько транзакций было в конкретном месяце?
// - Десять самых затратных операций
// - На что было потрачено больше всего денег?

public class BankTransactionAnalyzerSimple {

    private static final String RESOURCES = "src/main/resources";

    public static void main(final String... args) throws IOException {

        final Path path = Paths.get(RESOURCES + args[0]);
        final List<String> lines = Files.readAllLines(path);
        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        double total = 0d;

        // Вычисление суммы операций
        for (final String line : lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transactions is " + total);

        // Вычисление за Январь
        for (final String line : lines) {
            final String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);

            if (date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);
                total += amount;
            }
        }

        System.out.println("The total for all transactions is " + total);
    }
}