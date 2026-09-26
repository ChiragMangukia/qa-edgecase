package io.github.chiragmangukia.edgecase.strategy.Integer;

import io.github.chiragmangukia.edgecase.core.EdgeCase;
import io.github.chiragmangukia.edgecase.core.EdgeCaseCategory;
import io.github.chiragmangukia.edgecase.strategy.EdgeCaseStrategy;

import java.util.ArrayList;
import java.util.List;

public class IntegerBoundaryStrategy implements EdgeCaseStrategy<Integer> {

    private final int minimum;
    private final int maximum;

    public IntegerBoundaryStrategy(int minimum, int maximum) {

        if (minimum > maximum) {
            throw new IllegalArgumentException("minimum must be less than or equal to maximum");
        }

        this.minimum = minimum;
        this.maximum = maximum;
    }

    @Override
    public List<EdgeCase<Integer>> generate() {

        if (minimum == maximum) {
            return List.of(new EdgeCase<>(minimum, EdgeCaseCategory.BOUNDARY, "minimum and maximum"));
        }

        List<EdgeCase<Integer>> edgeCases = new ArrayList<>();

        addIfWithinIntegerRange(edgeCases, (long) minimum - 1, "minimum - 1");

        edgeCases.add(new EdgeCase<>(minimum, EdgeCaseCategory.BOUNDARY, "minimum"));
        edgeCases.add(new EdgeCase<>(minimum + 1, EdgeCaseCategory.BOUNDARY, "minimum + 1"));
        edgeCases.add(new EdgeCase<>(maximum - 1, EdgeCaseCategory.BOUNDARY, "maximum - 1"));
        edgeCases.add(new EdgeCase<>(maximum, EdgeCaseCategory.BOUNDARY, "maximum"));

        addIfWithinIntegerRange(edgeCases, (long) maximum + 1, "maximum + 1");

        return List.copyOf(edgeCases);
    }

    private void addIfWithinIntegerRange(
            List<EdgeCase<Integer>> edgeCases,
            long value,
            String reason
    ) {
        if (value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE) {
            edgeCases.add(new EdgeCase<>((int) value, EdgeCaseCategory.BOUNDARY, reason));
        }
    }
}
