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
            return List.of(
                    new EdgeCase<>(
                            minimum,
                            EdgeCaseCategory.BOUNDARY,
                            "minimum and maximum"
                    )
            );
        }

        List<EdgeCase<Integer>> edgeCases = new ArrayList<>();

        addIfPossible(edgeCases, minimum, EdgeCaseCategory.BOUNDARY, "minimum");
        addIfPossible(edgeCases, minimum + 1, EdgeCaseCategory.BOUNDARY, "minimum + 1");
        addIfPossible(edgeCases, maximum - 1, EdgeCaseCategory.BOUNDARY, "maximum - 1");
        addIfPossible(edgeCases, maximum, EdgeCaseCategory.BOUNDARY, "maximum");

        return List.copyOf(edgeCases);
    }

    private void addIfPossible(
            List<EdgeCase<Integer>> edgeCases,
            int value,
            EdgeCaseCategory category,
            String reason
    ) {
        if (value >= minimum && value <= maximum) {
            edgeCases.add(new EdgeCase<>(value, category, reason));
        }
    }
}
