import java.util.ArrayList;

public class OddEvenFromArray {
    public static void main(String[] args) {
        int[]a={1,2,3,4,5,6,7,8,9,10};
        ArrayList<Integer>b=new ArrayList<>();
        ArrayList<Integer>c=new ArrayList<>();
        for(int i:a){
            if (i%2==0) {
                // System.out.println(i);
                b.add(i);
            }
            else{
                c.add(i);
            }
        }
        System.out.println("even array: "+b);
        System.out.println("even array: "+c);
    }
}
