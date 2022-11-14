package lotto;

import java.util.*;

public class WinNumber {
    public List<Integer> makeWinnumber(String inputWinNumber){


        List<Integer> winNumber = new ArrayList<Integer>();
        Arrays.asList(inputWinNumber.split(",")).forEach(strNum -> {
            try{
                winNumber.add(Integer.valueOf(strNum));
            }catch(Exception e){
                throw new IllegalArgumentException("[Error] 올바른 형식으로 입력하세요.");
            }
        });
        if(winNumber.size() != 6){
            throw new IllegalArgumentException("[Error] 6개의 숫자를 ,로 구분하여 입력하세요");
        }
        Collections.sort(winNumber);
        for(int i = 1; i <winNumber.size(); i++){
            if(winNumber.get(i) == winNumber.get(i-1)){
                throw new IllegalArgumentException("[Error] 동일한 숫자가 포함되어 있습니다.");
            }
            if(winNumber.get(i) > 46){
                throw new IllegalArgumentException("[Error] 45이하의 수를 입력하세요.");
            }
            if(winNumber.get(i) < 1){
                throw new IllegalArgumentException("[Error] 1이상의 수를 입력하세요.");
            }
        }


//        String[] winNumberArr = inputWinNumber.split(",");
//        List<Integer> winNumber = new ArrayList<Integer>();
//        for(int i = 0; i < winNumberArr.length; i++){
//            winNumber.add(Integer.valueOf(winNumberArr[i]));
//        }
//        Collections.sort(winNumber);


        return winNumber;
    }

    public int inputbonusNum(){
        Scanner sc = new Scanner(System.in);
        try{
            int bonusNum = sc.nextInt();
            if(bonusNum > 46){
                throw new IllegalArgumentException("[Error] 45이하의 수를 입력하세요.");
            }
            if(bonusNum < 1){
                throw new IllegalArgumentException("[Error] 0이상의 수를 입력하세요.");
            }
            return bonusNum;
        }catch(Exception e){
            throw new IllegalStateException("[Error] 올바르지 못한 입력입니다.");
        }
    }

}
