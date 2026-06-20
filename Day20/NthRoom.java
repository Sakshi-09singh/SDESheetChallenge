package Day20;

public class NthRoom {
    public int NthRoot(int N, int M) {
        int low = 1, high = M;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long value = 1;

            for (int i = 0; i < N; i++) {
                value *= mid;

                if (value > M) break;
            }

            if (value == M) return mid;
            else if (value < M) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }
}
