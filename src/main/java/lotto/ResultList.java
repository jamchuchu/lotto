package lotto;

import java.util.ArrayList;
import java.util.List;

public class ResultList {
    public List<Integer> makeResultList(String result){
        String[] resultArray = result.split(",");
        List<Integer> resultList = new ArrayList<Integer>();
        for(int i = 0; i < resultArray.length; i++){
            resultList.add(Integer.valueOf(resultArray[i]));
        }
        return resultList;
    }
}
