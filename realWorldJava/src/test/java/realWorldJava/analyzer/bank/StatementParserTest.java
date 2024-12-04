package realWorldJava.analyzer.bank;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatementParserTest {

    private final IStatementParser statementParser =
            new StatementParser();

    @Test
    public void shouldParseOneCorrectLineTest() throws Exception {
        final String line = "30-01-2017,-50,Tesco";

        final Transaction result = statementParser.parserFrom(line);

        final Transaction expected = new
                Transaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        final double tolerance = 0.0d;

        assertEquals(expected.getDate(), result.getDate());
        assertEquals(expected.getAmount(), result.getAmount());
        assertEquals(expected.getDescription(), result.getDescription());
    }
}