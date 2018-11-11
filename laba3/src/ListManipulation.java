import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ListManipulation implements Cloneable {
    private List<Integer> list = new Random().ints(20, 0, 100)
            .boxed().collect(Collectors.toList());

    public static void main(String[] args) {
        ListManipulation listManipulation = new ListManipulation();
        //listManipulation.bubbleSort();
        //listManipulation.matrix();
        listManipulation.scope();
    }

    /**
     * При помощи статического метода реализовать пузырьковую сортировку массива целых чисел
     * (длина массива задается при вызове метода сортировки).
     */
    private void bubbleSort() {
        System.out.println("\n============================================\nTASK 1");
        printList(list);
        for (int i = list.size() - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if(list.get(j) > list.get(j+1))
                    swap(j, j + 1);
            }
        }
        printList(list);
    }

    private void swap(int first, int second){ //метод меняет местами пару чисел массива
        int dummy = list.get(first);
        list.set(first, list.get(second));
        list.set(second, dummy);
    }

    /**
     * Задана “неровная матрица” (или ступенчатый массив - двумерный массив, строки в котором имеют различную длину:
     * int [][] arr; arr = new int[ 5 ][]; arr[ 0 ] = new int[ 3 ]; arr[ 1 ] = new int[ 7 ]; и т.д.).
     * Матрица содержит целые значения. Отсортировать каждую строку (использовать Arrays.sort() ),
     * распечатать матрицу на экране. Повторно распечатать матрицу, но выводить на экран только отрицательные значения
     * (использовать цикл с continue).
     */
    private void matrix() {
        System.out.println("\n============================================\nTASK 2");
        int[][] matrix = initMatrix();
        printMatrix(matrix);

        for (int[] arr : matrix) {
            Arrays.sort(arr);
        }
        printMatrix(matrix);
        printMatrixNegativeValue(matrix);
    }

    /**
     * Создать собственный класс с полями доступа public и private,
     * проверить их доступность из другого класса текущего пакета.
     */
    private void scope() {
        System.out.println("\n============================================\nTASK 3");
        Scope scope = new Scope();
        int i = scope.j;
    }

    private int [][] initMatrix() {
        int [][] arr;
        arr = new int[5][];
        arr[ 0 ] = new int[ 3 ];
        arr[ 1 ] = new int[ 7 ];
        arr[ 2 ] = new int[ 6 ];
        arr[ 3 ] = new int[ 2 ];
        arr[ 4 ] = new int[ 5 ];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().ints(arr[i].length, -100, 100).toArray();
        }
        return arr;
    }

    private void printMatrix(int[][] matrix) {
        System.out.println();
        for (int[] arr : matrix) {
            System.out.print(Arrays.toString(arr) + " \n");
        }
    }

    private void printMatrixNegativeValue(int[][] matrix) {
        System.out.println();
        for (int[] arr : matrix) {
            for (int value : arr) {
                if (value > 0)
                    continue;
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private void printList(List<Integer> list) {
        System.out.println();
        list.forEach(i -> System.out.print(i + " "));
    }

    @Override
    protected ListManipulation clone() {
        ListManipulation listManipulation = new ListManipulation();
        listManipulation.list = new ArrayList<>(list);
        return listManipulation;
    }
}
