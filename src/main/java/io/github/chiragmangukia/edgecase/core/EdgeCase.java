package io.github.chiragmangukia.edgecase.core;

import java.util.Objects;

public record EdgeCase<T>(
        T value,
        EdgeCaseCategory category,
        String reason
) {
    public EdgeCase {
        Objects.requireNonNull(category, "category must not be null");
        Objects.requireNonNull(reason, "reason must not be null");
    }
}
