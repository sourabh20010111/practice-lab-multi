import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        System.out.print("enter number: ");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int checkarm=0;
        int power=String.valueOf(a).length();
        int num=a;

        while (num!=0) {
            int remainder = num%10;
            checkarm+=Math.pow(remainder, power);
            num=num/10;
        }
       
        if (checkarm==a) {
            System.out.println(a+" is armstrong number");
        }
        else{
            System.out.println(a+" is not an armstrong number");
        }
        
        sc.close();
    }
}
