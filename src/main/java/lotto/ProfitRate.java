package lotto;

public class ProfitRate {
    public String calcProfit(int pay , int priceMoney){
        double profitRate = priceMoney/pay*100;
        String profitRate2F = String.format("%.2f", profitRate);
        return profitRate2F;
    }
}
