package lotto;

import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class lottoGenerate {
    public List<Integer> makeSelectNumber(){
        List<Integer> selectNumber = pickUniqueNumbersInRange(1,45,6);
        Collections.sort(selectNumber);
        while(true) {
            int num = checkSameNumberIndex(selectNumber);
            if(num != -1){
                selectNumber.remove(num);
                selectNumber.add(pickNumberInRange(1,45));
                Collections.sort(selectNumber);
            }
            if (num == -1) {
                System.out.println(selectNumber);
                break;
            }
        }
        return selectNumber;
    }

    public int checkSameNumberIndex(List<Integer> list){
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) == list.get(i-1)){
                return i;
            }
        }
        return -1;


    }
}
