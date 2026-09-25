package io.github.chiragmangukia.edgecase.generator;

import io.github.chiragmangukia.edgecase.core.EdgeCase;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringEdgeCaseGeneratorTest {

    private final StringEdgeCaseGenerator generator =
            new StringEdgeCaseGenerator();

    @Test
    void shouldCombineAllStringStrategies() {

        List<EdgeCase<String>> edgeCases = generator.generate();
        assertEquals(11, edgeCases.size());
    }

    @Test
    void shouldReturnUnmodifiableList() {

        List<EdgeCase<String>> edgeCases = generator.generate();

        assertThrows(UnsupportedOperationException.class, edgeCases::clear);
    }
}