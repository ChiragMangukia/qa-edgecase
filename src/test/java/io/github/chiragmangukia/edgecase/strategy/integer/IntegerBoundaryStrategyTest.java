package io.github.chiragmangukia.edgecase.strategy.integer;

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

        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value() == 17));
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value() == 18));
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value() == 19));
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value() == 99));
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value() == 100));
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value() == 101));
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

    @Test
    void shouldGenerateValuesOutsideBoundaries() {

        IntegerBoundaryStrategy strategy = new IntegerBoundaryStrategy(18, 100);
        List<EdgeCase<Integer>> edgeCases = strategy.generate();

        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value() == 17));
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value() == 101));
    }

    @Test
    void shouldHandleIntegerMinimumValue() {

        IntegerBoundaryStrategy strategy = new IntegerBoundaryStrategy(Integer.MIN_VALUE, Integer.MIN_VALUE + 10);
        List<EdgeCase<Integer>> edgeCases = strategy.generate();

        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value() == Integer.MIN_VALUE));
        assertTrue(edgeCases.stream().noneMatch(edgeCase -> edgeCase.reason().equals("minimum - 1")));
    }

    @Test
    void shouldHandleIntegerMaximumValue() {

        IntegerBoundaryStrategy strategy = new IntegerBoundaryStrategy(Integer.MAX_VALUE - 10, Integer.MAX_VALUE);
        List<EdgeCase<Integer>> edgeCases = strategy.generate();

        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value() == Integer.MAX_VALUE));
        assertTrue(edgeCases.stream().noneMatch(edgeCase -> edgeCase.reason().equals("maximum + 1")));
    }
}
