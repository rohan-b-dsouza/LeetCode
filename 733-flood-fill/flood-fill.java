class Pair {
  int row;
  int col;

  Pair(int r, int c) {
    row = r;
    col = c;
  }
}

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
