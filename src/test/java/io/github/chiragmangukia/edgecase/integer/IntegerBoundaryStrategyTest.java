package io.github.chiragmangukia.edgecase.integer;

import io.github.chiragmangukia.edgecase.core.EdgeCase;
import io.github.chiragmangukia.edgecase.strategy.Integer.IntegerBoundaryStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegerBoundaryStrategyTest {

    @Test
    void shouldGenerateBoundaryValues() {

        IntegerBoundaryStrategy strategy = new IntegerBoundaryStrategy(18, 100);

        List<EdgeCase<Integer>> edgeCases = strategy.generate();

        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value() == 18));
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value() == 19));
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value() == 99));
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value() == 100));
    }

    @Test
    void shouldRejectInvalidRange() {
        assertThrows(IllegalArgumentException.class, () -> new IntegerBoundaryStrategy(100, 18));
    }

    @Test
    void shouldGenerateOnlyOneValueForSingleValueRange() {

        IntegerBoundaryStrategy strategy = new IntegerBoundaryStrategy(50, 50);

        List<EdgeCase<Integer>> edgeCases = strategy.generate();

        assertEquals(1, edgeCases.size());
        assertEquals(50, edgeCases.get(0).value());
    }
}
