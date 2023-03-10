class Allocator {
    int[] memo;

    public Allocator(int n) {
        memo = new int[n];
    }

    public int allocate(int size, int mID) {
        int len = 0, ind = -1;
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] == 0) {
                len++;
                if (ind == -1)
                    ind = i;
            } else {
                len = 0;
                ind = -1;
            }
            if (len == size) {
                for (int j = ind; j < ind+len; j++)
                    memo[j] = mID;

                return ind;
            }
        }
        return -1;
    }

    public int free(int mID) {
        
        int cnt = 0;
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] == mID) {
                cnt++;
                memo[i] = 0;
            }
        }
        return cnt;
    }
}
