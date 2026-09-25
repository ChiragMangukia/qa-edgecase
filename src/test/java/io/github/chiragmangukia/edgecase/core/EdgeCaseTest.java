package io.github.chiragmangukia.edgecase.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeCaseTest {

    @Test
    void shouldCreateIntegerEdgeCase() {

        EdgeCase<Integer> edgeCase = new EdgeCase<>(101, EdgeCaseCategory.BOUNDARY, "maximum + 1");

        assertEquals(101, edgeCase.value());
        assertEquals(EdgeCaseCategory.BOUNDARY, edgeCase.category());
        assertEquals("maximum + 1", edgeCase.reason());
    }

    @Test
    void shouldCreateNullCategory() {

        EdgeCase<String> edgeCase = new EdgeCase<>(
                null,
                EdgeCaseCategory.NULL,
                "Null value"
        );

        assertNull(edgeCase.value());
        assertEquals(
                EdgeCaseCategory.NULL,
                edgeCase.category()
        );
    }

    @Test
    void shouldRejectNullCategory() {

        assertThrows(
                NullPointerException.class,
                () -> new EdgeCase<>(
                        "test",
                        null,
                        "Missing category"
                )
        );
    }

    @Test
    void shouldRejectNullReason() {
        assertThrows(
                NullPointerException.class,
                () -> new EdgeCase<>(
                        "test",
                        EdgeCaseCategory.INVALID,
                        null
                )
        );
    }
}
