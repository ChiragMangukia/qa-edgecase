package io.github.chiragmangukia.edgecase.generator;

import io.github.chiragmangukia.edgecase.core.EdgeCase;

import java.util.List;

public interface EdgeCaseGenerator<T> {

    List<EdgeCase<T>> generate();
}
