package Arrays.RePractise;

/*
Best Time to Buy and Sell Stock
        Type I: At most one transaction is allowed
        Given an array prices[] of length N, representing the prices of the stocks on different days,
        the task is to find the maximum profit possible for buying and selling the stocks on different days using transactions where at most one transaction is allowed.
*/
public class stockBuySellAtMost1 {
    public static void main(String[] args)
    {
        int[] price = {7, 1, 5, 3, 6, 4};
        int n = price.length;
        System.out.println("Expected : 5     Actual : " + getMaxProfit(price, n));
    }

    static int getMaxProfit(int[] price, int size){
        int buyPrice = price[0], maxProfit = 0;
        for(int i = 1;i< size;i++){
            if (buyPrice > price[i]){
                buyPrice = price[i];
            } else if (price[i] - buyPrice > maxProfit){
                maxProfit = price[i] - buyPrice;
            }
        }
        return maxProfit;
    }
}
