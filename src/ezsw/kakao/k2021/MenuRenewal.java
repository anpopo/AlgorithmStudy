package ezsw.kakao.k2021;

import java.util.*;

public class MenuRenewal {

    static List<Map<String, Integer>> FoodMaps = new ArrayList<>();
    int[] MaxCnt = new int[11];

    public static void main(String[] args) {
    }

    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < 11; i++) {
            FoodMaps.add(new HashMap<String, Integer>());
        }
        for (String str : orders) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            comb(arr, 0, new StringBuilder());
        }

        List<String> list = new ArrayList<>();
        for (int len : course) {
            for (Map.Entry<String, Integer> entry : FoodMaps.get(len).entrySet()) {
                if (entry.getValue() >= 2 && entry.getValue() == MaxCnt[len]) {
                    list.add(entry.getKey());
                }
            }
        }

        Collections.sort(list);

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    private void comb(char[] str, int pos, StringBuilder candi) {
        if (pos >= str.length) {
            int len = candi.length();

            if (len >= 2) {
                int cnt = FoodMaps.get(len).getOrDefault(candi.toString(), 0) + 1;
                FoodMaps.get(len).put(candi.toString(), cnt);
                MaxCnt[len] = Math.max(MaxCnt[len], cnt);
            }
            return ;
        }
        comb(str, pos + 1, candi.append(str[pos]));
        candi.setLength(candi.length() - 1);
        comb(str, pos, candi);
    }


}
