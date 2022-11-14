package lotto;

import java.util.*;

public class Application {
    Scanner scanner;
    lottoGenerate lottoGenerate;
    NumberMatch numberMatch;
    WinNumber winNumber;
    ProfitRate profitRate;

    public static void main(String[] args) {
        Application app = new Application();
        app.solution();



    }



    public void solution(){
        scanner = new Scanner(System.in);
        lottoGenerate = new lottoGenerate();
        numberMatch = new NumberMatch();
        winNumber = new WinNumber();
        profitRate = new ProfitRate();

        System.out.println("구입금액을 입력해 주세요");
        int pay = scanner.nextInt();
        if(pay % 1000 != 0){
            throw new IllegalArgumentException("[Error] 1000원 단위로 입력하세요");
        }
        System.out.println();
        int lottoNum = pay/1000;

        System.out.println(lottoNum + "개를 구매했습니다.");

        List<Lotto> selectnumbers = new ArrayList<Lotto>();

        for(int i = 0; i < lottoNum; i++){
            selectnumbers.add(new Lotto(lottoGenerate.makeSelectNumber()));
        }

        System.out.println();

        System.out.println("당첨번호를 입력해 주세요.");
        String winNumStr = scanner.next();
        List<Integer> winNumbers = winNumber.makeWinnumber(winNumStr);
        System.out.println();

        System.out.println("보너스 번호를 입력해주세요");

        int bonusNumber=winNumber.inputbonusNum();
        System.out.println();

        System.out.println("당첨통계");
        System.out.println("---");
        List<Integer> matchNumber = numberMatch.makeMatchNumbers(bonusNumber, winNumbers, selectnumbers);
        System.out.println("3개 일치(5,000원) - " + matchNumber.get(0) + "개");
        System.out.println("4개 일치(50,000원) - " + matchNumber.get(1) + "개");
        System.out.println("5개 일치(1,500,000원) - " + matchNumber.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchNumber.get(3) + "개");
        System.out.println("6개 일치(2,000,000,000원) - " + matchNumber.get(4) + "개");

         int priceMoney =numberMatch.calcPrice(matchNumber);
         String profit = profitRate.calcProfit(pay, priceMoney);

        System.out.println("총 수익률은 " + profit + "%입니다.");



    }



}