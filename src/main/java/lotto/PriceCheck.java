package lotto;

import java.util.ArrayList;
import java.util.List;

public class PriceCheck {
    public List<Integer> makePriceList(int bonus, List<Integer> resultList, List<Lotto> lottoList){//3,4,5,5+,6
        List<Integer> priceList = new ArrayList<Integer>();
        for(int i = 0; i < 5; i++){
            priceList.add(0);
        }
        for(int lotto = 0; lotto <lottoList.size(); lotto++){
            int sameNum = resultCheckList(bonus, resultList, lottoList.get(lotto).getNumbers());
            if(sameNum > 2) {
                int price = sameNum - 3;
                priceList.set(price, priceList.get(price) + 1);
            }
        }
        return priceList;
    }

    public int resultCheckList(int bonus ,List<Integer> resultList, List<Integer> selcectList){
        int result = 0;
        for(int i = 0; i < resultList.size(); i++){
            if(selcectList.contains(resultList.get(i))){
                result ++;
            }
        }
        if(result < 5){
            return result;}
        if(result == 5){
            if(resultBonusCheckList(bonus, selcectList)){
                result ++;
            }
            return result;
        }
        if(result == 6){
            result ++;
        }
        return result;
    }

    public boolean resultBonusCheckList(int bonus, List<Integer> selcectList){
        if(selcectList.contains(bonus)){
            return true;
        }
        return false;
    }

    public int calcPrice(List<Integer> priceList){
       int priceMoney  = priceList.get(0) * 5000 + priceList.get(1) * 50000 + priceList.get(2) * 1500000 + priceList.get(3) * 30000000 + priceList.get(4) * 2000000000;
       return priceMoney;
    }
}
