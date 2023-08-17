package Arrays.RePractise;

/*The cost of a stock on each day is given in an array. Find the maximum profit that you can make by buying and selling on those days.
If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.

        Examples:

        Input: arr[] = {100, 180, 260, 310, 40, 535, 695}
        Output: 865
        Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210
        Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655
        Maximum Profit  = 210 + 655 = 865*/
public class stockBuySellInfiniteTrx {
    static int maxProfit(int[] prices, int size)
    {
        int maxProfit = 0;
        for (int i = 1; i < size; i++)
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        return maxProfit;
    }


    // Driver code
    public static void main(String[] args)
    {

        // stock prices on consecutive days
        int[] price = { 7, 1, 5, 3, 6, 4};
        int n = price.length;

        // function call
        System.out.println(maxProfit(price, n));
    }
}
