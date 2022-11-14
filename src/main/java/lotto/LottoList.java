package lotto;

import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class LottoList {
    public List<Integer> makeRandomList(){
        List<Integer> tempList = pickUniqueNumbersInRange(1,45,6);
        Collections.sort(tempList);
        while(true) {
            int num = checkRandomList(tempList);
            if(num != -1){
                tempList.remove(num);
                tempList.add(pickNumberInRange(1,45));
                Collections.sort(tempList);
            }
            if (num == -1) {
                System.out.println(tempList);
                break;
            }
        }
        return tempList;
    }

    public int checkRandomList(List<Integer> list){
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) == list.get(i-1)){
                return i;
            }
        }
        return -1;


    }
}
