package lotto;

public class Benefit {
    public long calcBenefit(int pay , int priceMoney){
        long BenefitRate = priceMoney/pay*100;
        return BenefitRate;
    }
}
