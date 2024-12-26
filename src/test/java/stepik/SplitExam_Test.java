package stepik;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplitExam_Test {

    @Test
    void testReadInput_ValidInput_SplitsCorrectly() {
        // Arrange
        String inputLine = "Hello|World";
        // Act
        String[] result = SplitExam.readInput(inputLine);
        // Assert
        assertArrayEquals(new String[]{"Hello", "World"}, result);
    }

    @Test
    void testReadInput_EmptyInput_ThrowsException() {
        // Arrange
        String emptyInput = "";
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> SplitExam.readInput(emptyInput));
    }

    @Test
    void testReadInput_NullInput_ThrowsException() {
        // Arrange
        String nullInput = null;
        // Act & Assert
        assertThrows(NullPointerException.class, () -> SplitExam.readInput(nullInput));
    }

    @Test
    void testReadInput_SingleWordInput_DoesNotSplit() {
        // Arrange
        String singleWordInput = "Hello";
        // Act
        String[] result = SplitExam.readInput(singleWordInput);
        // Assert
        assertEquals(1, result.length);
        assertEquals("Hello", result[0]);
    }

    @Test
    void testReadInput_MultipleWordsWithSpaces_SplitsCorrectly() {
        // Arrange
        String multiWordInput = "Hello   |  World  |  !";
        // Act
        String[] result = SplitExam.readInput(multiWordInput);
        // Assert
        assertArrayEquals(new String[]{"Hello", "World", "!"}, result);
    }

    @Test
    void testReadInput_MultipleWordsWithEmptySpace_SplitsCorrectly() {
        // Arrange
        String multiWordInputWithEmptySpace = "Hello   |  World  |  ";
        // Act
        String[] result = SplitExam.readInput(multiWordInputWithEmptySpace);
        // Assert
        assertArrayEquals(new String[]{"Hello", "World", ""}, result);
    }
}