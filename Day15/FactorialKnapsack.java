package Day15;

import java.util.Arrays;

public class FactorialKnapsack {
    static class Item {
        int value;
        int weight;
        double ratio;

        Item(int v, int w) {
            value = v;
            weight = w;
            ratio = (double) v / w;
        }
    }

    public double fractionalKnapsack(int[] val, int[] wt, long cap) {

        int n = val.length;

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(val[i], wt[i]);
        }

        // Sort by value/weight ratio descending
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0;

        for (Item item : items) {

            // Take whole item
            if (cap >= item.weight) {

                cap -= item.weight;
                totalValue += item.value;
            }
            else {

                // Take fractional part
                totalValue += item.ratio * cap;
                break;
            }
        }

        return totalValue;
    }
}
