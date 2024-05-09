package com.example.designpattern.company;

public class MS_DistributeMonitorsToClosetDistanceVendor {


        static void sort(int[] D, int[] C){

            int n = D.length;
            int temp;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j <n ; j++) {
                    if(D[i]>D[j]){

                        temp = D[i];
                        D[i] = D[j];
                        D[j] = temp;

                        temp = C[i];
                        C[i] = C[j];
                        C[j] = temp;


                    } else if (D[i] == D[j] && C[i] > C[j]) {
                        temp = C[i];
                        C[i] = C[j];
                        C[j] = temp;

                    }

                }
            }

        }
        public int solution(int[] D, int[] C, int P) {
            // Implement your solution here
            sort(D,C);

            for(int i=0;i<D.length;i++)
                System.out.println(D[i] + " ");
            System.out.println();

            for(int i=0;i<D.length;i++)
                System.out.println(C[i] + " ");
            System.out.println();

            int count = 0;
            int ans = 0;
            for (int i = 0; i < D.length; i++) {
                if(ans+C[i]<=P){
                    ans = ans + C[i];
                    count++;
                }else {
                    break;
                }
            }

            return count;

        }

}
