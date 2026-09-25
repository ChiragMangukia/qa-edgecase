package io.github.chiragmangukia.edgecase.strategy.string;

import io.github.chiragmangukia.edgecase.core.EdgeCase;
import io.github.chiragmangukia.edgecase.core.EdgeCaseCategory;
import io.github.chiragmangukia.edgecase.strategy.EdgeCaseStrategy;

import java.util.List;

public class WhiteSpaceStrategy implements EdgeCaseStrategy<String> {

    @Override
    public List<EdgeCase<String>> generate() {

        return List.of(
                new EdgeCase<>(
                        " ",
                        EdgeCaseCategory.WHITESPACE,
                        "Single whitespace character"
                ),
                new EdgeCase<>(
                        "   ",
                        EdgeCaseCategory.WHITESPACE,
                        "Multiple whitespace character"
                ),
                new EdgeCase<>(
                        "\t",
                        EdgeCaseCategory.WHITESPACE,
                        "Tab character"
                ),
                new EdgeCase<>(
                        "\n",
                        EdgeCaseCategory.WHITESPACE,
                        "Newline character"
                ),
                new EdgeCase<>(
                        "\r\n",
                        EdgeCaseCategory.WHITESPACE,
                        "Carriage return followed by newline"
                )
        );
    }
}
