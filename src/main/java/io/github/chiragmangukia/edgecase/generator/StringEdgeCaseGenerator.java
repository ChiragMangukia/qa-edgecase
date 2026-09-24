package io.github.chiragmangukia.edgecase.generator;

import io.github.chiragmangukia.edgecase.core.EdgeCase;
import io.github.chiragmangukia.edgecase.core.EdgeCaseCategory;

import java.util.ArrayList;
import java.util.List;

public class StringEdgeCaseGenerator implements EdgeCaseGenerator<String> {


    @Override
    public List<EdgeCase<String>> generate() {

        List<EdgeCase<String>> edgeCases = new ArrayList<>();

        edgeCases.add(
                new EdgeCase<>(
                        "",
                        EdgeCaseCategory.EMPTY,
                        "Empty string"
                )
        );

        edgeCases.add(
                new EdgeCase<>(
                        "\t",
                        EdgeCaseCategory.WHITESPACE,
                        "Tab character"
                )
        );

        edgeCases.add(
                new EdgeCase<>(
                        " ",
                        EdgeCaseCategory.WHITESPACE,
                        "Single whitespace character"
                )
        );

        edgeCases.add(
                new EdgeCase<>(
                        "\n",
                        EdgeCaseCategory.WHITESPACE,
                        "Newline character"
                )
        );

        edgeCases.add(
                new EdgeCase<>(
                        "😊",
                        EdgeCaseCategory.UNICODE,
                        "Emoji input"
                )
        );

        edgeCases.add(
                new EdgeCase<>(
                        "हिन्दी",
                        EdgeCaseCategory.UNICODE,
                        "Devanagari input"
                )
        );
        return List.copyOf(edgeCases);
    }
}
