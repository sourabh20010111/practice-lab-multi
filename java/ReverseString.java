public static void main(String[] args) {
    String og="hello";
    String revstring="";
    for (int i=og.length()-1;i>-1;i--){
        revstring=revstring+og.charAt(i);
    }
    System.out.println(revstring);
}