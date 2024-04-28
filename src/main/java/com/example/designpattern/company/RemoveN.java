package com.example.designpattern.company;

public class RemoveN {

    public static int removeX(int N, char X)
    {
        // Stores the index of X
        // that has to be removed
        String st= String.valueOf(Math.abs(N));
        int index = -1;

        if(N>=0) {
            for (int i = 0; i < st.length() - 1; i++) {
                if (st.charAt(i) == X) {
                    index = i;
                    if (st.charAt(i) - '0' < st.charAt(i + 1) - '0') {
                        break;
                    }
                }
            }
        }else{
            for (int i = 0; i < st.length() - 1; i++) {
                if (st.charAt(i) == X) {
                    index = i;
                    if (st.charAt(i) - '0' > st.charAt(i + 1) - '0') {
                        break;
                    }
                }
            }
        }




        String ans = "";
        for (int i = 0; i < st.length(); i++) {
            if (i != index)
                ans = ans + st.charAt(i);
        }

        int ansInt = Integer.parseInt(ans);
        if(N<0){
            ansInt = -ansInt;
        }
        return ansInt;
    }

    // Driver code
    public static void main(String[] args)
    {
        int N = 5000;
        char X = '5';

        // Function call
        System.out.println(removeX(N, X));
    }
}
