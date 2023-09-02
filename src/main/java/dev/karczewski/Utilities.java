package dev.karczewski;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Utilities {

    private Utilities() {
    }

    public static <IN, OUT> Collection<OUT> mapToListCollection(final Stream<IN> stream,
                                                                 final Function<IN, OUT> func) {
        return stream.map(func).toList();
    }

    public static <IN, OUT> Collection<OUT> mapToArrayListCollection(final Stream<IN> stream,
                                                                      final Function<IN, OUT> func,
                                                                      final int size) {
        return stream.map(func).collect(Collectors.toCollection(() -> new ArrayList<>(size)));
    }

    public static <IN, OUT> Collection<OUT> mapToLinkedListCollection(final Stream<IN> stream,
                                                                       final Function<IN, OUT> func) {
        return stream.map(func)
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
