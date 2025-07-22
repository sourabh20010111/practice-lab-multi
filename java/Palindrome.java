import java.util.Scanner;

public class Palindrome {
    public static void main(String[]args) {

    Scanner u_input = new Scanner(System.in);
    System.out.println("enter string :");

    String og=u_input.next();
    String revstring="";

    for (int i=og.length()-1;i>-1;i--){
        revstring=revstring+og.charAt(i);
    }

    if(og.equals(revstring)){
        System.out.println("its a palindrome");
    }
    else{
        System.out.println("its not a palindrome");
    }
    u_input.close();
}

}
