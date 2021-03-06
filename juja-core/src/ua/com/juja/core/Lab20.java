package ua.com.juja.core;
/*
Задача о генерации всех возможных перестановок элементов заданного списка.
Из списка длины N можно построить N! возможных перестановок
 (N! = 1 * 2 * … * (N – 1) * N, 1!=1, 2!=1*2=2, 3!=1*2*3=6, 4!=1*2*3*4=24, …).
Пример:

Из элементов списка [10, 20, 30] можно построить 6 различных перестановок:

[10, 20, 30]
[20, 30, 10]
[30, 20, 10]
[20, 10, 30]
[30, 10, 20]
[10, 30, 20]

Схема рекурсивного решения:
Все возможные перестановки N элементов ([a(1), a(2), a(3), ..., a(N)]) распадаются на N непересекающихся множеств:
1) те, что начинаются с a(1)
2) те, что начинаются с a(2)
3) те, что начинаются с a(3)
…
N) те, что начинаются с a(N)

При этом множество перестановок начинающихся с a(K) (для К = 1,2,3,…N) можно построить следующим образом:
1) первым элементов поставим a(K)
2) все остальные позиции занимают всевозможные перестановки оставшихся элементов
[a(1), a(2), ..., a(K-1), a(K+1), ..., a(N-1), a(N)]
Вот графическая схема решения для списка

[10, 20, 30]

| |->[10, ?, ?]

      |->[10, 20, ?]->[10, 20, 30]

      |-> [10, 30,?]->[10, 30, 20]

| |->[20, ?, ?]

      |->[20, 10, ?]-> [20, 10, 30]

      |->[20, 30, ?]-> [20, 30, 10]

| |->[30, ?, ?]

       |->[30, 10, ?] -> [30, 10, 20]

       |->[30, 20, ?] -> [30, 20, 10]

Которая приводит к множеству перестановок: [10, 20, 30] [10, 30, 20] [20, 10, 30] [20, 30, 10] [30, 10, 20] [30, 20, 10]

Как это работает.
1. В начале стоит ИЛИ 10 ИЛИ 20 ИЛИ 30;
1.1 Если вначале стоит 10, то дальше стоит ИЛИ 20 ИЛИ 30
1.1.1 Если вначале стоит 10, и дальше стоит 20, то осталось 30
1.1.2 Если вначале стоит 10, и дальше стоит 30, то осталось 20
1.2 Если вначале стоит 20, то дальше стоит ИЛИ 10 ИЛИ 30
1.2.1 Если вначале стоит 20, и дальше стоит 10, то осталось 30
1.2.2 Если вначале стоит 20, и дальше стоит 30, то осталось 10
1.3 Если вначале стоит 30, то дальше стоит ИЛИ 10 ИЛИ 20
1.3.1 Если вначале стоит 30, и дальше стоит 10, то осталось 20
1.3.2 Если вначале стоит 30, и дальше стоит 20, то осталось 10
 */
import java.util.Arrays;

public class Lab20 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        permutation(arr, arr.length);
    }
    public static void permutation(int[] arr, int size) {

        if (size < 2) {
            System.out.println(Arrays.toString(arr));
        } else {
            for (int k = 0; k < size; k++) {
                swap(arr, k, size - 1);
                permutation(arr, size-1);
                swap(arr, k, size - 1);
            }
        }
    }
    public static void swap(int[] arr, int index0, int index1) {
        int tmp = arr[index0];
        arr[index0] = arr[index1];
        arr[index1] = tmp;
    }
}