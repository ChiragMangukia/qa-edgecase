package io.github.chiragmangukia.edgecase.generator;

import io.github.chiragmangukia.edgecase.core.EdgeCase;
import io.github.chiragmangukia.edgecase.core.EdgeCaseCategory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringEdgeCaseGeneratorTest {

    private final StringEdgeCaseGenerator generator =
            new StringEdgeCaseGenerator();

    @Test
    void shouldGenerateExpectedNumberOfEdgeCases() {

        List<EdgeCase<String>> edgeCases =
                generator.generate();

        assertEquals(11, edgeCases.size());
    }

    @Test
    void shouldGenerateEmptyStringCase() {

        List<EdgeCase<String>> edgeCases =
                generator.generate();

        assertTrue(
                edgeCases.stream()
                        .anyMatch(edgeCase ->
                                edgeCase.category() ==
                                        EdgeCaseCategory.EMPTY)
        );
    }

    @Test
    void shouldGenerateWhitespaceCases() {

        List<EdgeCase<String>> edgeCases =
                generator.generate();

        long whitespaceCount =
                edgeCases.stream()
                        .filter(edgeCase ->
                                edgeCase.category() ==
                                        EdgeCaseCategory.WHITESPACE)
                        .count();

        assertEquals(5, whitespaceCount);
    }

    @Test
    void shouldGenerateUnicodeCases() {

        List<EdgeCase<String>> edgeCases =
                generator.generate();

        long unicodeCount =
                edgeCases.stream()
                        .filter(edgeCase ->
                                edgeCase.category() ==
                                        EdgeCaseCategory.UNICODE)
                        .count();

        assertEquals(5, unicodeCount);
    }

    @Test
    void shouldReturnUnmodifiableList() {

        List<EdgeCase<String>> edgeCases =
                generator.generate();

        org.junit.jupiter.api.Assertions.assertThrows(
                UnsupportedOperationException.class,
                edgeCases::clear
        );
    }
}