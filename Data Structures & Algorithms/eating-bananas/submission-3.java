
class Solution {

    public boolean isPossible(int num, int[] piles, int h) {

        long ans = 0;

        for (int i = 0; i < piles.length; i++) {
            int numOfHoursPerPile = (int) Math.ceil((double) piles[i] / num);

            ans += numOfHoursPerPile;
        }

        return ans <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int st = 1;
        int end = 0;

        for (int pile : piles) {
            end = Math.max(end, pile);
        }

        int res = end;

        while (st <= end) {

            int mid = st + (end - st) / 2;

            if (isPossible(mid, piles, h)) {
                res = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return res;
    }
}
