package io.github.chiragmangukia.edgecase.strategy.string;

import io.github.chiragmangukia.edgecase.core.EdgeCase;
import io.github.chiragmangukia.edgecase.core.EdgeCaseCategory;
import io.github.chiragmangukia.edgecase.strategy.EdgeCaseStrategy;

import java.util.List;

public class UnicodeStrategy implements EdgeCaseStrategy<String> {

    @Override
    public List<EdgeCase<String>> generate() {
        return List.of(
                new EdgeCase<>(
                        "😀",
                        EdgeCaseCategory.UNICODE,
                        "Emoji input"
                ),
                new EdgeCase<>(
                        "हिन्दी",
                        EdgeCaseCategory.UNICODE,
                        "Devanagari input"
                ),
                new EdgeCase<>(
                        "ગુજરાતી",
                        EdgeCaseCategory.UNICODE,
                        "Gujarati input"
                ),
                new EdgeCase<>(
                        "العربية",
                        EdgeCaseCategory.UNICODE,
                        "Arabic input"
                ),
                new EdgeCase<>(
                        "中文",
                        EdgeCaseCategory.UNICODE,
                        "Chinese input"
                )
        );
    }
}
