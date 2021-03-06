package baekjoon.data_structure.boj2304;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2304 {
    static int index;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("baekjoon/data_structure/boj2304/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        index = 0;
        int[][] map = new int[N][];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[i] = new int[]{x, y};
            if (y > max) {
                index = x;
                max = y;
            }
        }
        Arrays.sort(map, (o1, o2) -> {
            if (o2[1] == o1[1]) return Math.abs(index - o2[0]);
            return o2[1] - o1[1];
        });
        int lindex = index;
        int rindex = index;
        int sum = 0;
        for (int i = 1; i < map.length; i++) {
            if (map[i][0] > rindex) {
                sum += map[i][1] * (map[i][0] - rindex);
                rindex = map[i][0];
            } else if (map[i][0] < lindex) {
                sum += map[i][1] * (lindex - map[i][0]);
                lindex = map[i][0];
            }
        }
        System.out.print(sum + max);
    }
}
