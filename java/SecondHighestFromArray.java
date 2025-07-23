public class SecondHighestFromArray {
    public static void main(String[] args) {
        int[] array = {10, 20, 5, 8, 25, 18};

        // Check if array length is at least 2
        if (array.length < 2) {
            System.out.println("Array must have at least two elements.");
            return;
        }

        int first, second;

        // Initialize first and second with first two elements correctly
        if (array[0] > array[1]) {
            first = array[0];
            second = array[1];
        } else {
            first = array[1];
            second = array[0];
        }

        // Start from third element
        for (int i = 2; i < array.length; i++) {
            int num = array[i];

            if (num > first) {
                second = first;
                first = num;
            } 
            else if (num > second && num != first) {
                second = num;
            }
        }

        System.out.println("Second highest number is: " + second);
    }
}