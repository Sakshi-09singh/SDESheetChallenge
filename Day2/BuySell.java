// 121. Best Time to Buy and Sell Stock
public class BuySell {
    public int maxProfit(int[] prices) {
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
           if(prices[i] < minPrice) 
                minPrice = prices[i];
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }
        
        return maxProfit;
    }
}

