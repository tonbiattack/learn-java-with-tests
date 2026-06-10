package dev.learnjavawithtests.arrays.v1;

import java.util.ArrayList;
import java.util.List;

public final class SumCalculator {
    private SumCalculator() {
    }

    public static int sum(int[] numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    public static List<Integer> sumAll(List<int[]> collections) {
        List<Integer> totals = new ArrayList<>();
        for (int[] numbers : collections) {
            totals.add(sum(numbers));
        }
        return totals;
    }
}

