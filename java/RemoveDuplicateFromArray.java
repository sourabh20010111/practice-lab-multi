import java.util.ArrayList;

public class RemoveDuplicateFromArray {
    public static void main(String[] args) {
        int[]a={1,2,3,5,4,5,11,6,7,8,9,10,5,6,8};
        
        int n=a.length;
        int[] b =new int[n];
        int count=0;

        ArrayList<Integer>withoutduplicate=new ArrayList<>();

        for(int i=0;i<n;i++){
            boolean isduplicate=false;
            for(int j=0;j<count;j++){
                if(a[i]==b[j]){
                    isduplicate = true;
                    break;
                }
            }
            // System.out.println(isduplicate);
            if(!isduplicate){
                b[count]=a[i];
                count++;
            }

        }

        // System.out.print("without duplicate arraylist:");
        // for(int i=0;i<count;i++){
        //     System.out.print(b[i]+" ");
        // }
        
       
        System.out.print("without duplicate arraylist:");
        for(int i=0;i<count;i++){
            withoutduplicate.add(b[i]);
        }
        System.err.println(withoutduplicate);

    }
}
