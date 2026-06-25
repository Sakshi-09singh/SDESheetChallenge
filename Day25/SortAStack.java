package Day25;

import java.util.Stack;

public class SortAStack {
    public void sortStack(Stack<Integer> st) {

        // Base case
        if (st.isEmpty()) {
            return;
        }

        int top = st.pop();

        // Sort remaining stack
        sortStack(st);

        // Insert element at correct position
        insertSorted(st, top);
    }

    private void insertSorted(Stack<Integer> st, int val) {

        // For descending order (largest at top)
        if (st.isEmpty() || st.peek() <= val) {
            st.push(val);
            return;
        }

        int top = st.pop();

        insertSorted(st, val);

        st.push(top);
    }
}
