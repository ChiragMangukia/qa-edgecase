package io.github.chiragmangukia.edgecase.generator;

import io.github.chiragmangukia.edgecase.core.EdgeCase;
import io.github.chiragmangukia.edgecase.core.EdgeCaseCategory;
import io.github.chiragmangukia.edgecase.strategy.EdgeCaseStrategy;
import io.github.chiragmangukia.edgecase.strategy.string.EmptyStringStrategy;
import io.github.chiragmangukia.edgecase.strategy.string.UnicodeStrategy;
import io.github.chiragmangukia.edgecase.strategy.string.WhiteSpaceStrategy;

import java.util.ArrayList;
import java.util.List;

public class StringEdgeCaseGenerator implements EdgeCaseGenerator<String> {

    private final List<EdgeCaseStrategy<String>> strategies;

    public StringEdgeCaseGenerator() {

        this.strategies = List.of(
                new EmptyStringStrategy(),
                new WhiteSpaceStrategy(),
                new UnicodeStrategy()
        );
    }

    @Override
    public List<EdgeCase<String>> generate() {

        return strategies.stream()
                .flatMap(strategy -> strategy.generate().stream())
                .toList();
    }
}
