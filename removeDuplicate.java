public class removeDuplicate {
public static int[] removeDuplicate(int[] array) {
        int index = 0;
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (indexOf(temp, array[i]) > -1) {
            } else {
                temp[index++] = array[i];
            }
        }
        int[] result=new int[index];
        System.arraycopy(temp, 0, result, 0, index);
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(removeDuplicate(new int[]{1, 1, 1, 10, 5, 3, 4, 2}, 3));
    }
}
