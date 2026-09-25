package io.github.chiragmangukia.edgecase.strategy.Integer;

import io.github.chiragmangukia.edgecase.core.EdgeCase;
import io.github.chiragmangukia.edgecase.generator.EdgeCaseGenerator;
import io.github.chiragmangukia.edgecase.strategy.EdgeCaseStrategy;

import java.util.List;

public class IntegerEdgeCaseGenerator implements EdgeCaseGenerator<Integer> {

    private final List<EdgeCaseStrategy<Integer>> strategies;

    public IntegerEdgeCaseGenerator(int miminum, int maximum) {
        this.strategies = List.of(new IntegerBoundaryStrategy(miminum, maximum));
    }

    @Override
    public List<EdgeCase<Integer>> generate() {
        return strategies.stream().flatMap(strategy -> strategy.generate().stream()).toList();
    }
}
