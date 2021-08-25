package ch05;

public class QueenB {
    static int[] pos = new int[8];

    public static void main(String[] args) {
        set(0);
    }

    private static void set(int i) {
        for (int j = 0; j < 8; j++) {
            pos[i] = j;
            if (i == 7) {
                print();
            } else {
                set(i + 1);
            }
        }
    }

    private static void print() {
        for (int i = 0; i < 8; i++) {
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }
}
