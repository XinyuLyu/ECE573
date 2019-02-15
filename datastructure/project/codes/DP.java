package com.company;

public class DP {
        public int dp[][][]=new int[10][1<<9][10];
        public int skip[][]=new int[10][10];
        public boolean initialized;
        private void InitSkipArray() {
            //  memset(skip, 0, sizeof(skip));
            skip[1][3] = skip[3][1] = 2;
            skip[1][7] = skip[7][1] = 4;
            skip[3][9] = skip[9][3] = 6;
            skip[7][9] = skip[9][7] = 8;
            skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = 5;
        }

        void calcDP() {
            initialized = true;
            InitSkipArray();
            // memset(dp, 0, sizeof(dp));
            // this loops initializes the DP : for every element in the android pattern table, there
            // is a path of length 1, ending at that element, which visit only that element
            // thinks about every path of length 1 : there is nine of them, they visit only one point
            for (int i = 1; i <= 9; i++)
                dp[1][1 << (i - 1)][i] = 1;
            for (int len = 1; len < 9; len++) {
                for (int state = 0; state < (1 << 9); state++) {
                    for (int endNode = 1; endNode <= 9; endNode++) {
                        if (dp[len][state][endNode]!=0) { // if it is zero : it has not been initialized, which means no path ends on this node given the state
                            for (int i = 1; i <= 9; i++) { // i represent the potential next element of the android pattern array that you could visit
                                if ((state & (1 << (i - 1))) == 0) { // if i is the element we are at currently we do not consider it : we want to visit a different element
                                    int nextState = (state | (1 << (i - 1))); // this is how the state bit map would you look like if you were to visit i
                                    if (skip[endNode][i] == 0 || ((state & (1 << (skip[endNode][i] - 1))) != 0))  // skipping logic
                                        dp[len + 1][nextState][i] += dp[len][state][endNode];
                                }
                            }
                        }
                    }
                }
            }
        }
        public int numberOfPatterns(int m, int n) {
            if (!initialized) {
                calcDP();
            }
            int ans = 0;
            for (int state = 0; state < (1 << 9); state++) {
                for (int len = m; len <= n; len++) {
                    for (int endNode = 1; endNode <= 9; endNode++) {
                        ans += dp[len][state][endNode];
                    }
                }
            }
            return ans;
        }

}
