package dev.karczewski.benchmark;

import dev.karczewski.Utilities;
import dev.karczewski.Wrapper;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Collection;
import java.util.stream.IntStream;

public class MappingUtilitiesBenchmark {

    @Benchmark
    public void simpleToList(final Blackhole bh) {
        final Collection<Wrapper<Integer>> result =
                Utilities.mapToListCollection(IntStream.rangeClosed(1, 1_000).map(i -> i * 2).boxed(), Wrapper::wrap);
        bh.consume(result);
    }

    @Benchmark
    public void toSizedArrayList(final Blackhole bh) {
        final Collection<Wrapper<Integer>> result =
                Utilities.mapToArrayListCollection(IntStream.rangeClosed(1, 1_000).map(i -> i * 2).boxed(), Wrapper::wrap, 1_001);
        bh.consume(result);
    }

    @Benchmark
    public void toLinkedList(final Blackhole bh) {
        final Collection<Wrapper<Integer>> result =
                Utilities.mapToLinkedListCollection(IntStream.rangeClosed(1, 1_000).map(i -> i * 2).boxed(), Wrapper::wrap);
        bh.consume(result);
    }

}
