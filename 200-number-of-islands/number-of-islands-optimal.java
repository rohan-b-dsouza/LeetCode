// Optimal 
// Note:- Instead of BFS, DFS can also be used, its very simple just keep all same and change bfs func to dfs func

class Pair {
  int row;
  int col;

  Pair(int r, int c) {
    row = r;
    col = c;
  }
}

// Logic:- Loop over the grid, for each unvisited cell perform bfs. In bfs, for each cell check all its 4 neighbours and mark them as visited if they are a land. 
// Each time we get an unvisited cell in the loop then increment count as this is an island. Hence, eventually all islands will be visited.
// Note:- For the 8-direction neighbours version of this problem, instead of 4 check all 8 directions. (Code for this also given below)


class Solution {
  public void bfs(int row, int col, char[][] grid, int[][] visited, int n, int m) {
    Deque<Pair> queue = new ArrayDeque<>();
    visited[row][col] = 1;
    queue.offer(new Pair(row, col));
    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      int currRow = pair.row;
      int currCol = pair.col;
      if (currRow - 1 >= 0 && visited[currRow - 1][currCol] != 1 && grid[currRow - 1][currCol] == '1') {
        queue.offer(new Pair(currRow - 1, currCol));
        visited[currRow - 1][currCol] = 1;
      }
      if (currRow + 1 < n && visited[currRow + 1][currCol] != 1 && grid[currRow + 1][currCol] == '1') {
        queue.offer(new Pair(currRow + 1, currCol));
        visited[currRow + 1][currCol] = 1;
      }
      if (currCol - 1 >= 0 && visited[currRow][currCol - 1] != 1 && grid[currRow][currCol - 1] == '1') {
        queue.offer(new Pair(currRow, currCol - 1));
        visited[currRow][currCol - 1] = 1;
      }
      if (currCol + 1 < m && visited[currRow][currCol + 1] != 1 && grid[currRow][currCol + 1] == '1') {
        queue.offer(new Pair(currRow, currCol + 1));
        visited[currRow][currCol + 1] = 1;
      }
    }
  }

  public int numIslands(char[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int[][] visited = new int[n][m];
    int island = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == '1' && visited[i][j] != 1) {
          visited[i][j] = 1;
          bfs(i, j, grid, visited, n, m);
          island++;
        }
      }
    }
    return island;
  }
}

// T.C => O(n * m * 4) as in worst case we will check 4 neighbours for each cell
// S.C => Visited array:- O(n * m) + Queue :- O(n * m) in the worst case

// 8 - directions Version (i.e Diagonal neighbours included)
// class Pair {
//   int row;
//   int col;

//   Pair(int r, int c) {
//     row = r;
//     col = c;
//   }
// }


// class Solution {
//   public void bfs(int row, int col, char[][] grid, int[][] visited, int n, int m) {
//     Deque<Pair> queue = new ArrayDeque<>();
//     visited[row][col] = 1;
//     queue.offer(new Pair(row, col));
//     while (!queue.isEmpty()) {
//       Pair pair = queue.poll();
//       int currRow = pair.row;
//       int currCol = pair.col;
//       for (int delRow = -1; delRow <= 1; delRow++) {
//         for (int delCol = -1; delCol <= 1; delCol++) {
//           int nrow = currRow + delRow;
//           int ncol = currCol + delCol;
//           if (nrow >= 0
//                   && nrow < n
//                   && ncol >= 0
//                   && ncol < m
//                   && visited[nrow][ncol] != 1
//                   && grid[nrow][ncol] ==
//               '1') {
//             queue.offer(new Pair(nrow, ncol));
//             visited[nrow][ncol] = 1;
//           }
//         }
//       }
//     }
//   }

//   public int numIslands(char[][] grid) {
//     int n = grid.length;
//     int m = grid[0].length;
//     int[][] visited = new int[n][m];
//     int island = 0;
//     for (int i = 0; i < n; i++) {
//       for (int j = 0; j < m; j++) {
//         if (grid[i][j] == '1' && visited[i][j] != 1) {
//           visited[i][j] = 1;
//           bfs(i, j, grid, visited, n, m);
//           island++;
//         }
//       }
//     }
//     return island;
//   }
// }

 // T.C => O(n * m * 8) as in worst case we will check 8 neighbours for each cell
// S.C => Visited array:- O(n * m) + Queue :- O(n * m) in the worst case
