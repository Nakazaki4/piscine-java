public class ComputeArray {
    public static int[] computeArray(int[] array) {
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if ((array[i] - 2) % 3 == 0) {
                res[i] = array[i];
            }
            if ((array[i] - 1) % 3 == 0) {
                res[i] = array[i] + 7;
            }
            if ((array[i] % 3) == 0) {
                res[i] = array[i] * 5;
            }
        }
        return res;
    }
}