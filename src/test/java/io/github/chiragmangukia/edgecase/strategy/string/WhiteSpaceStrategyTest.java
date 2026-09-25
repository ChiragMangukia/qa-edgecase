package io.github.chiragmangukia.edgecase.strategy.string;

import io.github.chiragmangukia.edgecase.core.EdgeCase;
import io.github.chiragmangukia.edgecase.core.EdgeCaseCategory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WhiteSpaceStrategyTest {

    @Test
    void shouldGenerateWhiteSpaceCases() {

        WhiteSpaceStrategy strategy = new WhiteSpaceStrategy();

        List<EdgeCase<String>> edgeCases = strategy.generate();

        assertEquals(5, edgeCases.size());
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value().equals(" ")));
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value().equals("   ")));
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value().equals("\t")));
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value().equals("\n")));
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value().equals("\r\n")));
        assertTrue(edgeCases.stream().allMatch(edgeCase -> edgeCase.category() == EdgeCaseCategory.WHITESPACE));
    }
}
