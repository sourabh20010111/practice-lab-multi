import java.util.Scanner;

public class PrimeNum {
    public static void main(String[] args) {
        System.out.print("enter number to number is prime or not: ");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        boolean isPrime = true;
        if(num<=1){
            isPrime=false;
        }
        else{
            for(int i=2;i<=num/2;i++){
                if(num%i==0){
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(num+" it is a prime number");
        }
        else{
            System.out.println(num+" it is not an prime number");
        }

        sc.close();
    }
}
