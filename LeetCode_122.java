public class LeetCode_122 {
    public static int maxProfit(int[] prices) {
        int profit=0;
        for(int i=1;i<prices.length;i++)
            if(prices[i]>prices[i-1])
                profit+= prices[i]-prices[i-1];
        
    return profit;
    }
    public static void main(String[] args) {
        // Example usage of maxProfit method
        int[] stockPrices = {7, 1, 5, 3, 6, 4}; // Sample stock prices
        int result = maxProfit(stockPrices);
        for(int num:stockPrices)
        System.out.print(num+" ");
        System.out.println();
        System.out.println("Maximum profit: " + result);
    }
}
