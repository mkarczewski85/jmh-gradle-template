package dev.karczewski.benchmark;

import dev.karczewski.Fib;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

public class SampleBenchmark {

    @Benchmark
    public void fibClassic(Blackhole bh) {
        bh.consume(Fib.fibClassic(30));
    }

    @Benchmark
    public void fibTailRec(Blackhole bh) {
        bh.consume(Fib.tailRecFib(30));
    }

}