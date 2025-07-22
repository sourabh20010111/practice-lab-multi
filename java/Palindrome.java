public static void main(String[]args) {
    String og="hello";
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
}
