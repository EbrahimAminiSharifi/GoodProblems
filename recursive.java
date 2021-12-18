/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moghaleb
 */
public class recursive {

    public static int[] swap(int[] res, int index, int index1) {

        int temp = res[index];
        res[index] = res[index1];
        res[index1] = temp;
        return res;
    }

    public static void sort(int[] array, int index1, int index2) {
        if (array[index1] > array[index2]) {
            swap(array, index1, index2);
        }

    }

    public static void spilit1(int[] array, int start, int end) {

        if (end == start) {
            //  sort(array, start, start);

        } else if (end - start == 1) {
            sort(array, start, end);

        } else {

            int end1 = end % 2 != 0 ? (end / 2) + 1 : end / 2;
            if (end1 <= start) {
                end1 = (end - start) % 2 != 0 ? (start + (end - start) / 2) + 1 : (start + (end - start) / 2);
            }
            spilit1(array, start, end1);

            int start1 = (end - start) % 2 != 0 ? (start + (end - start) / 2) + 2 : (start + (end - start) / 2) + 1;
            spilit1(array, start1, end);

        }

    }

    public static void main(String[] args) {
        int[] testArray = new int[]{11, 20, 19, 10, 14, 13, 16, 17, 18, 12, 12};
        spilit1(testArray, 0, testArray.length - 1);
        for (int i = 0; i < testArray.length; i++) {
            System.out.println(testArray[i]);
        }

    }

}
