class ex4 {
    public static void main(String[] args) {
        int n=6;
        pattern_A(n);
        space(2);
        pattern_B(n);
        space(2);
        pattern_C(n);
        space(2);
        pattern_D(n);
    }
    public static void space(int n){
        for(int i=0;i<n;i++)
        System.out.println();
    }
    public static void pattern_A(int n){
        for(int i=0;i<n+1;i++){
            for(int j=0;j<i;j++){
                System.out.print(j+1);
            }
            System.out.println();
        }
    }
    public static void pattern_B(int n){
        for(int i=n;i>=0;i--){
            for(int j=0;j<i;j++){
                System.out.print(j+1);
            }
            System.out.println();
        }
    }
    public static void pattern_C(int n){
        for(int k=1;k<=n;k++){
            for(int l=n;l>k;l--){
                System.out.print(" ");
            }
            for(int j=0;j<k;j++){
                System.out.print(k-j);
            }
            System.out.println();
        }
    }
    public static void pattern_D(int n){
        int l=0;
        for(int i=n;i>0;i--){
            for(int j=0;j<l;j++){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print(j+1);
            }
            System.out.println();
            l+=1;
        }
    }
}

