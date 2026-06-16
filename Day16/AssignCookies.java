import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;

        while (child < g.length && cookie < s.length) {

            // If cookie can satisfy child
            if (s[cookie] >= g[child]) {
                child++;
            }

            // Move to next cookie
            cookie++;
        }

        return child;
    }
}
