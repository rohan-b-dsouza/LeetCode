// Optimal


// Logic:- First we put all rotten oranges positions into the queue as a Tuple {row, col, current time}. Using BFS, we visit level - wise each adjacent fresh orange for every rotten orange and make it rotted and putting it into the 
// queue as a Tuple {row, col, time + 1} as this happens the next minute. Finally, we return the max time encountered.


class Tuple {
    int row, col, time;
    Tuple(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    } 
}

class Solution {
    public int orangesRotting(int[][] grid) {
     int n = grid.length;
     int m = grid[0].length;
     int minTime = 0;
     int[][] visited = new int[n][m];
     int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
     int initialFresh = 0;
     Deque<Tuple> queue = new ArrayDeque<>();
     for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++ ) {
            if (grid[i][j] == 2) {
                queue.offer(new Tuple(i, j, 0));
                visited[i][j] = 2;
            } 
            else if (grid[i][j] == 1) {
                initialFresh++;
            }
        }
     }
     while(!queue.isEmpty()) {
        Tuple tuple = queue.poll();
        int r = tuple.row;
        int c = tuple.col;
        int time = tuple.time;
        minTime = Math.max(time, minTime);
        for (int[] direction : directions) {
            int row = r + direction[0];
            int col = c + direction[1];
            if (row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1 && visited[row][col] != 2) {
                visited[row][col] = 2;
                initialFresh--;
                queue.offer(new Tuple(row, col, time + 1));
            } 
        }
     }
     if (initialFresh == 0) return minTime;
     return -1;
    }
}

// T.C => O(n * m) + O(n * m * 4)
// S.C => O(n * m) for visited array + O(n * m) for queue 
