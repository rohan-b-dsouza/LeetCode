/*
    LeetCode 2149 Variety 2->
    Problem Statement:
There’s an array ‘A’ of size ‘N’ with positive and negative elements (not necessarily equal). Without altering the relative order of positive and negative elements, you must return an array of alternately positive and negative values. The leftover elements should be placed at the very end in the same order as in array A.

Note: Start the array with positive elements.
*/

// Optimal Solution => 

#include <iostream>
#include <vector>
using namespace std;

vector <int> alternateNumbers(vector <int> &a) {
    vector <int> posi;
    vector <int> nega;
    for (int i = 0; i < a.size(); i++) {
        if (a[i] > 0) {
            posi.push_back(a[i]);
        }
        else{
            nega.push_back(a[i]);
        }
    }
    if (posi.size() > nega.size()) {
        for (int i = 0; i < nega.size(); i++) {
            a[2 * i] = posi[i];
            a[2 * i + 1] = nega[i]; 
        }
        int idx = nega.size() * 2;
        for (int i = nega.size(); i < posi.size(); i++) {
            a[idx] = posi[i];
            idx++;
        }
    }
    else {
        for (int i = 0; i < posi.size(); i++) {
            a[2 * i] = posi[i];
            a[2 * i + 1] = nega[i];
        }
        int idx = posi.size() * 2;
        for (int i = posi.size(); i < nega.size(); i++) {
            a[idx] = nega[i];
            idx++;
        }
    }
    return a;
}

// T.C => O(n) + O(min(pos.size(), nega.size()) + O(leftovers) = O(n) + O(n) = O(2n)
// S.C => O(n)

int main() {
    int n;
    cout << "Enter the number of elements : ";
    cin >> n;
    vector <int> v;
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        v.push_back(x);
    }
    cout << "Input : ";
    for (int i = 0; i < n; i++) {
        cout << v[i] << " ";
    }
    cout << endl;
    vector <int> ans = alternateNumbers(v);
    cout << "Output : ";
    for (int i = 0; i < n; i++) {
        cout << ans[i] << " ";
    }
    return 0;
}
