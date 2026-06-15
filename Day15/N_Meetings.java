package Day15;
import java.util.ArrayList;
import java.util.Collections;

public class N_Meetings {
    static class Meeting {
        int start, end;

        Meeting(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int maxMeetings(int[] start, int[] end) {

        int n = start.length;

        ArrayList<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }

        // Sort by end time
        // If end time same, sort by start time
        Collections.sort(meetings, (a, b) -> {
            if (a.end == b.end)
                return a.start - b.start;

            return a.end - b.end;
        });

        int count = 1;
        int lastEnd = meetings.get(0).end;

        for (int i = 1; i < n; i++) {

            // Strictly greater according to problem statement
            if (meetings.get(i).start > lastEnd) {

                count++;
                lastEnd = meetings.get(i).end;
            }
        }

        return count;
    }
    
}
