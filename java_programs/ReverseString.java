import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
     Scanner u_input = new Scanner(System.in);
    System.out.println("enter string :");
    String og=u_input.next();
    String revstring="";
    for (int i=og.length()-1;i>-1;i--){
        revstring=revstring+og.charAt(i);
    }
    System.out.println(revstring);
    u_input.close();
}
    
}
