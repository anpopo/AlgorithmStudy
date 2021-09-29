package ezsw.kakao.k2020;

import jdk.swing.interop.DropTargetContextWrapper;

public class KeyAndLock {

    public static void main(String[] args) {

    }

    public boolean solution(int[][] key, int[][] lock) {


        int offset = key.length - 1;
        for (int r = 0; r < offset + lock.length; r++) {
            for (int c = 0; c < offset + lock.length; c++) {
                for(int rot= 0; rot < 4; rot++) {
                    int[][] arr = new int[58][58];
                    for (int i = 0; i < lock.length; i++) {
                        for (int j = 0; j < lock.length; j++) {
                            arr[offset + i][offset + j] = lock[i][j];

                        }
                    }

                    match(arr, key, rot, r, c);

                    if(check(arr, offset, lock.length)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean check(int[][] arr, int offset, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(arr[offset + i][offset + j] != 1)
                    return false;
            }
        }
        return true;
    }

    private void match(int[][] arr, int[][] key, int rot, int r, int c) {
        int n = key.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if(rot == 0) {
                    arr[r + i][c + j] += key[i][j];
                } else if (rot == 1) {
                    arr[r + i][c + j] += key[n - 1 - j][i];
                } else if (rot == 2) {
                    arr[r + i][c + j] += key[n - 1 - i][n - 1 - j];
                } else {
                    arr[r + i][c + j] += key[j][n - 1 - i];
                }
            }
        }
    }
}
