package io.github.chiragmangukia.edgecase.strategy;

import io.github.chiragmangukia.edgecase.core.EdgeCase;

import java.util.List;

public interface EdgeCaseStrategy<T> {

    List<EdgeCase<T>> generate();
}
