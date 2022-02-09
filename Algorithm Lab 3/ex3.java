class ex3 {
    public static void main(String[] args) {
        int n=5;
        //a
        pattern_a(n);
        //b
        space(2);
        pattern_b(n);
        //c
        space(2);
        pattern_c(n);
        //d
        space(2);
        pattern_d(n);
    }
    public static void space(int n){
        for(int i=0;i<n;i++)
        System.out.println();
    }
    public static void pattern_a(int n){
        for(int i=0;i<n+1;i++){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern_b(int n){
        for(int k=1;k<=n;k++){
            int m=0;
            for(int l=1;l<=n-k;l++){
                System.out.print(" ");
            }
            while(m!=2*k-1){
                System.out.print("*");
                m++;
            }
            System.out.println();
        }
    }
    public static void pattern_c(int n){
        for(int o=n;o>=1;o--){
            for(int p=0;p<n-o;p++){
                System.out.print(" ");
            }
            for (int q=o;q<=2*o-1;++q)
                System.out.print("*");
            for (int q=0; q < o - 1; ++q)
                System.out.print("*");
                System.out.println();
        }
    }
    public static void pattern_d(int n){
        for(int k=1;k<=n;k++){
            int m=0;
            for(int l=1;l<=n-k;l++){
                System.out.print(" ");
            }
            while(m!=2*k-1){
                System.out.print("*");
                m++;
            }
            System.out.println();
        }
        for(int o=n-1;o>=1;o--){
            for(int p=0;p<n-o;p++){
                System.out.print(" ");
            }
            for (int q=o;q<=2*o-1;++q)
                System.out.print("*");
            for (int q=0; q < o - 1; ++q)
                System.out.print("*");
                System.out.println();
        }
    }
}
