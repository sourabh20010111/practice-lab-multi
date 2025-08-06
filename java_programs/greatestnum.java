public class greatestnum {
    public static void main(String[]args) {
    
    int [] a={40,50,90,40,60};
    int greatest=a[0];
    // System.out.println(greatest);
    for(int i:a){
        if(i>=greatest){
            greatest=i;
        }
    }

    System.out.println(greatest);

}

}