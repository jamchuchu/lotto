package lotto;

import java.beans.ExceptionListener;
import java.util.*;

public class Application {
    Scanner scanner;
    LottoList lottos;
    PriceCheck priceCheck;
    ResultList results;
    Benefit benefit;

    public static void main(String[] args) {
        Application app = new Application();
        app.solution();



    }



    public void solution(){
        scanner = new Scanner(System.in);
        lottos = new LottoList();
        priceCheck = new PriceCheck();
        results = new ResultList();
        benefit = new Benefit();

        System.out.println("구입금액을 입력해 주세요");
        int pay = scanner.nextInt();
        System.out.println();
        int lottoNum = pay/1000;

        System.out.println(lottoNum + "개를 구매했습니다.");

        List<Lotto> lottoList = new ArrayList<Lotto>();

        for(int i = 0; i < lottoNum; i++){
            lottoList.add(new Lotto(lottos.makeRandomList()));
        }

        System.out.println();

        System.out.println("당첨번호를 입력해 주세요.");
        String resultSTR = scanner.next();
        List<Integer> resultList = results.makeResultList(resultSTR);
        System.out.println();

        System.out.println("보너스 번호를 입력해주세요");
        int bonus = scanner.nextInt();
        System.out.println();

        System.out.println("당첨통계");
        System.out.println("---");
        List<Integer> priceList = priceCheck.makePriceList(bonus, resultList, lottoList);
        System.out.println("3개 일치(5,000원) - " + priceList.get(0) + "개");
        System.out.println("4개 일치(50,000원) - " + priceList.get(1) + "개");
        System.out.println("5개 일치(1,500,000원) - " + priceList.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + priceList.get(3) + "개");
        System.out.println("6개 일치(2,000,000,000원) - " + priceList.get(4) + "개");

         int priceMoney =priceCheck.calcPrice(priceList);
         long benefitRate = benefit.calcBenefit(pay, priceMoney);

        System.out.println("총 수익률은 " + benefitRate + "%입니다.");



    }



}