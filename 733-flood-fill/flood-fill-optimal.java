// Optimal

class Pair {
  int row;
  int col;

  Pair(int r, int c) {
    row = r;
    col = c;
  }
}

// Logic:- // Just do whats asked..start from the starting node and fill adjacent 4 nodes by checking whether they have the same color as the starting node's initial color.
// Edge Case:- If starting node's color is same as newColor, return the image as it is, as otherwise it will lead to infinite looping. 

class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    // BFS
    int n = image.length;
    int m = image[0].length;
    if (image[sr][sc] == newColor) return image;
    Deque<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(sr, sc));
    int defaultColor = image[sr][sc];
    image[sr][sc] = newColor;
    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      int row = pair.row;
      int col = pair.col;
      if (row - 1 >= 0 && image[row - 1][col] == defaultColor) {
        queue.offer(new Pair(row - 1, col));
        image[row - 1][col] = newColor;
      }
      if (row + 1 < n && image[row + 1][col] == defaultColor) {
        queue.offer(new Pair(row + 1, col));
        image[row + 1][col] = newColor;
      }
      if (col - 1 >= 0 && image[row][col - 1] == defaultColor) {
        queue.offer(new Pair(row, col - 1));
        image[row][col - 1] = newColor;
      }
      if (col + 1 < m && image[row][col + 1] == defaultColor) {
        queue.offer(new Pair(row, col + 1));
        image[row][col + 1] = newColor;
      }
    }
    return image;
  }
}

// T.C => O(n * m * 4)
// S.C => O(n * m) for the queue
