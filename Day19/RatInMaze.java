package Day19;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    public List<String> findPath(int[][] grid) {
        List<String> ans = new ArrayList<>();

        int n = grid.length;

        // If starting cell is blocked
        if (grid[0][0] == 0)
            return ans;

        boolean[][] visited = new boolean[n][n];

        solve(0, 0, grid, visited, "", ans, n);

        return ans;
    }

    private void solve(int row, int col, int[][] grid,
                       boolean[][] visited,
                       String path,
                       List<String> ans,
                       int n) {

        // Reached destination
        if (row == n - 1 && col == n - 1) {
            ans.add(path);
            return;
        }

        visited[row][col] = true;

        // Down
        if (isSafe(row + 1, col, grid, visited, n)) {
            solve(row + 1, col, grid, visited, path + "D", ans, n);
        }

        // Left
        if (isSafe(row, col - 1, grid, visited, n)) {
            solve(row, col - 1, grid, visited, path + "L", ans, n);
        }

        // Right
        if (isSafe(row, col + 1, grid, visited, n)) {
            solve(row, col + 1, grid, visited, path + "R", ans, n);
        }

        // Up
        if (isSafe(row - 1, col, grid, visited, n)) {
            solve(row - 1, col, grid, visited, path + "U", ans, n);
        }

        // Backtrack
        visited[row][col] = false;
    }

    private boolean isSafe(int row, int col,
                           int[][] grid,
                           boolean[][] visited,
                           int n) {

        return (row >= 0 && col >= 0 &&
                row < n && col < n &&
                grid[row][col] == 1 &&
                !visited[row][col]);
    }
}
