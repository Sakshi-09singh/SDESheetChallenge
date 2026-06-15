package Day15;

import java.util.Arrays;

public class JobSequencing {
   public int[] JobScheduling(int[][] Jobs) {

        int n = Jobs.length;

        // Sort jobs by profit descending
        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);

        // Find maximum deadline
        int maxDeadline = 0;

        for (int[] job : Jobs) {
            maxDeadline = Math.max(maxDeadline, job[1]);
        }

        // Slot array
        int[] slot = new int[maxDeadline + 1];

        Arrays.fill(slot, -1);

        int countJobs = 0;
        int maxProfit = 0;

        // Process jobs
        for (int i = 0; i < n; i++) {

            int deadline = Jobs[i][1];
            int profit = Jobs[i][2];

            // Find free slot from deadline to 1
            for (int j = deadline; j >= 1; j--) {

                if (slot[j] == -1) {

                    slot[j] = i;

                    countJobs++;
                    maxProfit += profit;

                    break;
                }
            }
        }

        return new int[]{countJobs, maxProfit};
    } 
}
