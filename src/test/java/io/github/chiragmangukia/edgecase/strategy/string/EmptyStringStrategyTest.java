package io.github.chiragmangukia.edgecase.strategy.string;

import io.github.chiragmangukia.edgecase.core.EdgeCase;
import io.github.chiragmangukia.edgecase.core.EdgeCaseCategory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmptyStringStrategyTest {

    @Test
    void shouldGenerateEmptyString() {

        EmptyStringStrategy strategy = new EmptyStringStrategy();

        List<EdgeCase<String>> edgeCases = strategy.generate();

        assertEquals(1, edgeCases.size());

        EdgeCase<String> edgeCase = edgeCases.get(0);

        assertEquals("", edgeCase.value());
        assertEquals(EdgeCaseCategory.EMPTY, edgeCase.category());
        assertEquals("Empty string", edgeCase.reason());
    }
}
