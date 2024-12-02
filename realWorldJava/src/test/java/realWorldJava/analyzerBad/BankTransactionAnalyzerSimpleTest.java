package realWorldJava.analyzerBad;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankTransactionAnalyzerSimpleTest {

    private static Path path;

    @BeforeAll
    static void setUp() throws IOException {
        path = Paths.get("src/main/resources/records.csv");
        // Создание или обновление файла testFile.txt с данными для тестирования
    }

    @Test
    void testReadFile() throws IOException {
        List<String> lines = Files.readAllLines(path);
        List<Object> expectedLines = List.of();
        assertEquals(expectedLines.size(), lines.size()); // Проверка количества строк
        for (String line : lines) {
            // Дополнительные проверки содержания строк
        }
    }
}