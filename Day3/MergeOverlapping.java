import java.util.*;

class MergeOverlapping {
    public int[][] merge(int[][] intervals) {
        int i = 0;
        while (i < intervals.length - 1) {
            int i_start = intervals[i][0];
            int i_end = intervals[i][1];
            boolean merge = false;
            
            for (int j = i + 1; j < intervals.length; j++) {
                int j_start = intervals[j][0];
                int j_end = intervals[j][1];
                
                if (!(i_end < j_start || i_start > j_end)) {
                    // Overlap. Merge them
                    intervals[i][0] = Math.min(i_start, j_start);
                    intervals[i][1] = Math.max(i_end, j_end);
                    
                    // Erase j by shifting elements
                    for (int k = j; k < intervals.length - 1; k++) {
                        intervals[k] = intervals[k + 1];
                    }
                    
                    intervals = Arrays.copyOf(intervals, intervals.length - 1);
                    merge = true;
                    break;
                }
            }
            
            if (!merge) {
                i++;
            }
        }
        return intervals;
    }
}