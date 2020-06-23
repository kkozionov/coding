class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int shifts = 0;
        while (m!=n) {
            n = n >> 1;
            m = m >> 1;
            ++shifts;
        }
        
        return m << shifts;
        
    }
}
    
