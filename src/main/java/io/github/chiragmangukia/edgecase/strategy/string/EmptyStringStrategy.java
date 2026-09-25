package io.github.chiragmangukia.edgecase.strategy.string;

import io.github.chiragmangukia.edgecase.core.EdgeCase;
import io.github.chiragmangukia.edgecase.core.EdgeCaseCategory;
import io.github.chiragmangukia.edgecase.strategy.EdgeCaseStrategy;

import java.util.List;

public class EmptyStringStrategy implements EdgeCaseStrategy<String> {

    @Override
    public List<EdgeCase<String>> generate() {

        return List.of(
                new EdgeCase<>(
                        "",
                        EdgeCaseCategory.EMPTY,
                        "Empty string"
                )
        );
    }
}
