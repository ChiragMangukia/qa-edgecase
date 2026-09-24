package io.github.chiragmangukia.edgecase.generator;

import io.github.chiragmangukia.edgecase.core.EdgeCase;
import io.github.chiragmangukia.edgecase.core.EdgeCaseCategory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringEdgeCaseGeneratorTest {

    private final StringEdgeCaseGenerator generator = new StringEdgeCaseGenerator();

    @Test
    void shouldGenerateEdgeCase() {

        List<EdgeCase<String>> edgeCases = generator.generate();
        assertEquals(6, edgeCases.size());
    }

    @Test
    void shouldGenerateEmptyStringCase() {

        List<EdgeCase<String>> edgecases = generator.generate();

        assertTrue(
                edgecases.contains(
                        new EdgeCase<>(
                                "",
                                EdgeCaseCategory.EMPTY,
                                "Empty string"
                        )
                )
        );
    }

    @Test
    void shouldGenerateUnicodeCases() {

        List<EdgeCase<String>> edgeCases =
                generator.generate();

        assertTrue(
                edgeCases.stream()
                        .anyMatch(edgeCase ->
                                edgeCase.value().equals("हिन्दी"))
        );

        assertTrue(
                edgeCases.stream()
                        .anyMatch(edgeCase ->
                                edgeCase.value().equals("😊"))
        );
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
