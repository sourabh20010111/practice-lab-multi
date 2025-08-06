import java.util.ArrayList;

public class DisplayDuplicateFromArray {
    public static void main(String[] args) {
        
        int[] array = {1, 2, 3, 4, 2, 5, 1, 6, 3};
        int n = array.length;
        ArrayList<Integer> b=new ArrayList<>();
        System.out.println("Duplicate elements are:");

        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;

            // Check if element has already been checked before
            for (int k = 0; k < i; k++) {
                if (array[i] == array[k]) {
                    isDuplicate = true;
                    break; // already checked, skip
                }
            }

            if (isDuplicate) {
                continue; // skip already checked values
            }

            // Count how many times current element appears
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }

            if (count > 0) {
                // System.out.println(array[i]);
                b.add(array[i]);
            }

    }
    System.out.println(b);
    }
    
}
