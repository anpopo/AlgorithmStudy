package inflearn.ch10_dynamicprogramming;

/**
 * 동전교환(냅색 알고리즘)
 * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환
 * 해주려면 어떻게 주면 되는가? 각 단위의 동전은 무한정 쓸 수 있다.
 * ▣ 입력설명
 * 첫 번째 줄에는 동전의 종류개수 N(1<=N<=50)이 주어진다. 두 번째 줄에는 N개의 동전의 종
 * 류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
 * 각 동전의 종류는 100원을 넘지 않는다.
 * ▣ 출력설명
 * 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
 * ▣ 입력예제 1
 * 3
 * 1 2 5
 * 15
 * ▣ 출력예제 1
 * 3
 */

import java.util.*;

public class CoinExchange {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) {
        CoinExchange main = new CoinExchange();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        m = sc.nextInt();

        System.out.println(main.solution());
    }

    private int solution() {
        int answer = 0;
        int[] dy = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);

        dy[0] = 0;

        for (int x : arr) {
            for(int j = x; j < dy.length; j++) {
                dy[j] = Math.min(dy[j - x] + 1, dy[j]);
            }
        }

        answer = dy[m];

        return answer;
    }
}
