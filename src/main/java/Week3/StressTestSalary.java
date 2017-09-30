package Week3;

import java.util.Scanner;

public class StressTestSalary {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        setWith(n, s);
    }

    public static int[][] change(int n, int i, int[][] array) {
        int l;
        l = array[0][i + 1];
        array[0][i + 1] = array[0][i];
        array[0][i] = l;

        l = array[1][i + 1];
        array[1][i + 1] = array[1][i];
        array[1][i] = l;

        l = array[2][i + 1];
        array[2][i + 1] = array[2][i];
        array[2][i] = l;

        l = array[3][i + 1];
        array[3][i + 1] = array[3][i];
        array[3][i] = l;

        l = array[4][i + 1];
        array[4][i + 1] = array[4][i];
        array[4][i] = l;
        return array;
    }


    public static void sortWith(int n, int[][] array) {

        for (int k = n - 1; k > 0; k--) {// Отсортировали по старшему разряду
            for (int j = 0; j < k; j++) {
                if (array[0][j] < array[0][j + 1]) {
                    array = change(n, j, array);
                }
            }
        }
        // Хотим проверить на равенство старших разрядов
        //System.out.println("После сортировки по старшим разрядам");
        //outArray(n, array);
        int q, w, e;
        for (int t = 0; t < 3; t++) {
            for (int k = n - 1; k > 0; k--) {
                for (int j = 0; j < k; j++) {
                    if (t != 0) {
                        q = t - 1;
                    } else {
                        q = t;
                    }

                    if (t > 1) {
                        w = t - 2;
                    } else {
                        w = t;
                    }

                    if (t > 2) {
                        e = t - 3;
                    } else {
                        e = t;
                    }
                    int q1 = array[4][j];
                    int q2 = array[4][j + 1];

                    if (array[e][j] == array[e][j + 1] && array[w][j] == array[w][j + 1] && array[q][j] == array[q][j + 1] && array[t][j] == array[t][j + 1]
                            && array[t + 1][j] < array[t + 1][j + 1]
                            && (array[t + 1][j] != -1)
                            ) {
                        array = change(n, j, array);
                    } else if (array[e][j] == array[e][j + 1] && array[w][j] == array[w][j + 1] && array[q][j] == array[q][j + 1] && array[t][j] == array[t][j + 1]
                            && array[t + 1][j + 1] == -1
                            && array[t + 1][j] != -1
                            && array[t + 1][j] <= array[t][j]
                            && array[q1][j] < array[0][j + 1]
                            ) {
                        array = change(n, j, array);
                    } else if (array[e][j] == array[e][j + 1] && array[w][j] == array[w][j + 1] && array[q][j] == array[q][j + 1] && array[t][j] == array[t][j + 1]
                            && array[t + 1][j] == -1
                            && array[t + 1][j + 1] > array[t][j + 1]) {
                        array = change(n, j, array);
                    } else if (array[e][j] == array[e][j + 1] && array[w][j] == array[w][j + 1] && array[q][j] == array[q][j + 1] && array[t][j] == array[t][j + 1]
                            && array[t + 1][j] == -1
                            && array[q2][j + 1] > array[0][j]) {
                        array = change(n, j, array);
                    }
                }
            }
        }
        //System.out.println("Конечная сортировка хахаха");
        //outArray(n, array);
        //System.out.println();
        out(n, array);
    }

    public static void outArray(int n, int[][] array) {
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < n; i++) {
                System.out.print(array[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void out(int n, int[][] array) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[j][i] != -1) {
                    System.out.print(array[j][i]);
                }
            }
            //System.out.print(" ");
        }
    }

    public static void setWith(int n, Scanner s) {
        int[][] array = new int[5][n];
        int a, j;
        for (int i = 0; i < n; i++) {
            for (int l = 0; l < 4; l++) {
                array[l][i] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            a = s.nextInt();
            if (a - 1000 >= 0) {
                j = 3;
                array[4][i] = j;
            } else if (a - 100 >= 0) {
                j = 2;
                array[4][i] = j;
            } else if (a - 10 >= 0) {
                j = 1;
                array[4][i] = j;
            } else {
                j = 0;
                array[4][i] = j;
            }
            for (; j >= 0; j--) {
                array[j][i] = a % 10;
                a = a / 10;
            }
        }
        //System.out.println("После записывания в массив");
        //outArray(n, array);
        //sortWith(n, array);

        for (int i=0;i<n-1;i++){
            if(array[4][i]>array[4][i+1]){
                array = change(n, i, array);
            }
        }
        //System.out.println("После смены мест по кол-ву разрядов");
        //outArray(n, array);
        sortWith(n, array);
    }
}