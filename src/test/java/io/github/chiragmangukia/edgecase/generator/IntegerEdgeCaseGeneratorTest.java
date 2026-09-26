package io.github.chiragmangukia.edgecase.generator;

import io.github.chiragmangukia.edgecase.core.EdgeCase;
import io.github.chiragmangukia.edgecase.strategy.Integer.IntegerEdgeCaseGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntegerEdgeCaseGeneratorTest {

    @Test
    void shouldGenerateIntegerEdgeCases() {

        IntegerEdgeCaseGenerator generator = new IntegerEdgeCaseGenerator(18, 100);

        List<EdgeCase<Integer>> edgeCases = generator.generate();

        assertEquals(6, edgeCases.size());
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value() == 100));
    }
}
