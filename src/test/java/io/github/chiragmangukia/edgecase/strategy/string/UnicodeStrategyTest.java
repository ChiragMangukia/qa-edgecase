package io.github.chiragmangukia.edgecase.strategy.string;

import io.github.chiragmangukia.edgecase.core.EdgeCase;
import io.github.chiragmangukia.edgecase.core.EdgeCaseCategory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UnicodeStrategyTest {

    @Test
    void shouldGenerateUnicodeCases() {

        UnicodeStrategy strategy = new UnicodeStrategy();

        List<EdgeCase<String>> edgeCases = strategy.generate();

        assertEquals(5, edgeCases.size());
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value().equals("😀")));
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value().equals("हिन्दी")));
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value().equals("ગુજરાતી")));
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value().equals("العربية")));
        assertTrue(edgeCases.stream().anyMatch(edgeCase -> edgeCase.value().equals("中文")));
        assertTrue(edgeCases.stream().allMatch(edgeCase -> edgeCase.category() == EdgeCaseCategory.UNICODE));
    }
}
