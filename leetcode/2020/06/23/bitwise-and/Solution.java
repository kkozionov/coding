/**
 * 201. Bitwise AND of Numbers Range
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.s
 */
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
    
