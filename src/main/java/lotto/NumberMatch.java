package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberMatch {
    public List<Integer> makeMatchNumbers(int bonusNumber, List<Integer> winNumber, List<Lotto> selectNumbers){//3,4,5,5+,6
        List<Integer> MatchNumbers = new ArrayList<Integer>();
        for(int i = 0; i < 5; i++){
            MatchNumbers.add(0);
        }
        for(int selectnumber = 0; selectnumber <selectNumbers.size(); selectnumber++){
            int matchNum = countMatchNum(bonusNumber, winNumber, selectNumbers.get(selectnumber).getNumbers());
            if(matchNum > 2) {
                int indexMatchNum = matchNum - 3;
                MatchNumbers.set(indexMatchNum, MatchNumbers.get(indexMatchNum) + 1);
            }
        }
        return MatchNumbers;
    }

    public int countMatchNum(int bonusNumber ,List<Integer> winNumber, List<Integer> selectNumber){
        int matchNum = 0;
        for(int i = 0; i < winNumber.size(); i++){
            if(selectNumber.contains(winNumber.get(i))){
                matchNum ++;
            }
        }
        if(matchNum < 5){
            return matchNum;}
        if(matchNum == 5){
            if(matchBonusNum(bonusNumber, selectNumber)){
                matchNum ++;
            }
            return matchNum;
        }
        if(matchNum == 6){
            matchNum ++;
        }
        return matchNum;
    }

    public boolean matchBonusNum(int bonusNumber, List<Integer> selectNumber){
        if(selectNumber.contains(bonusNumber)){
            return true;
        }
        return false;
    }

    public int calcPrice(List<Integer> MatchNumbers){
        int priceMoney  = MatchNumbers.get(0) * 5000 + MatchNumbers.get(1) * 50000 + MatchNumbers.get(2) * 1500000 + MatchNumbers.get(3) * 30000000 + MatchNumbers.get(4) * 2000000000;
        return priceMoney;
    }
}
