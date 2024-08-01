package org.example;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Random;

public class Main {
    final static Random rand = new Random();

    public static void main(String[] args) {
        final var maxIterations = 10_000_000; // how many times run the experiment

        final var results = new HashMap<Integer, Integer>(); // numTries -> number of experiments

        var expectation = 0.0d;

        final var target = 0.999d; // probability at which the pair has to be found

        for (var iteration = 0; iteration < maxIterations; iteration++) {
            final var numTries = findPairOfBatteries();

            final var n = Integer.valueOf(numTries);

            expectation += (double) n / (double) maxIterations;

            if (results.containsKey(numTries)) {
                var temp = results.get(n).intValue() + 1;
                results.put(n, Integer.valueOf(temp));
            } else
            {
                results.put(numTries, Integer.valueOf(1));
            }
        }

        // find max number of tries to reach the desired probability target
        var accumulator = 0.0d;
        int i;
        for (i = 1; i < 1000; i++) {
            if (!results.containsKey(i)) {
                continue;
            }

            final var num = results.get(i);

            accumulator += (double) num / (double) maxIterations;
            if (accumulator > target) {
                break;
            }
        }
        System.out.println("Number of tries " + i + " to reach probability target " + target);

        System.out.println(new JSONObject(results).toString(2));

        System.out.println("Expectation: " + expectation);
    }

    private static int findPairOfBatteries() {
        // the order doesn't matter
        final var flashlights = new boolean[] {true, true, true, true, false, false, false, false};
        final var maxTests = 100000000; // some real big number of tests, very very unlucky if reached
        var num = 0;
        do {
            final var pick1 = rand.nextInt(flashlights.length);
            final var pick2 = rand.nextInt(flashlights.length);
            if (pick1 == pick2) {
                // wasted
                continue;
            } else {
                final var result = flashlights[pick1] & flashlights[pick2];
                num++;
                if (result) {
                    // found two working batteries
                    break;
                } else {
                    continue;
                }
            }
        } while (num < maxTests);
        return num;
    }
}