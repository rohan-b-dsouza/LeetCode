class DisjointSet {
  int[] rank;
  int[] parent;
  int[] size;

  public DisjointSet(int n) {
    rank = new int[n + 1];
    parent = new int[n + 1];
    size = new int[n + 1];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
    for (int i = 0; i < n; i++) {
      size[i] = 1;
    }
  }

  public boolean find(int u, int v) {
    return findPar(u) == findPar(v);
  }

  public void unionByRank(int u, int v) {
    int ulp_u = findPar(u);
    int ulp_v = findPar(v);
    if (ulp_u == ulp_v) return;
    if (rank[ulp_u] < rank[ulp_v]) {
      parent[ulp_u] = ulp_v;
    } else if (rank[ulp_v] < rank[ulp_u]) {
      parent[ulp_v] = ulp_u;
    } else {
      parent[ulp_u] = ulp_v;
      rank[ulp_v]++;
    }
  }

  public int findPar(int x) {
    if (parent[x] == x) {
      return x;
    }
    return parent[x] = findPar(parent[x]);
  }

  public void unionBySize(int u, int v) {
    int ulp_u = findPar(u);
    int ulp_v = findPar(v);
    if (ulp_u == ulp_v) return;
    if (size[ulp_u] < size[ulp_v]) {
      parent[ulp_u] = ulp_v;
      size[ulp_v] += size[ulp_u];
    } else {
      parent[ulp_v] = ulp_u;
      size[ulp_u] += size[ulp_v];
    }
  }
}
class Solution {
    public int makeConnected(int n, int[][] Edge) {
        DisjointSet dsu = new DisjointSet(n);
    int spareEdges = 0;
    for (int[] edge : Edge) {
      if (!dsu.find(edge[0], edge[1])) {
        dsu.unionByRank(edge[0], edge[1]);
      }
      else {
        spareEdges++;
      }
    }
    int components = 0;
    for (int i = 0; i < n; i++) {
        if (dsu.parent[i] == i) {
            components++;
        } 
    }
    if (components == 1) {
        return 0;
    }
    else if (spareEdges >= components - 1) {
        return components - 1;
    }
    return -1;
    }
}