class ex5 {
    public static void main(String[] args) {
        int n=7;
        if(isPrime(n)){System.out.println(n+" is Prime");}
        else{System.out.println(n+" is not Prime");}
    }
    public static boolean isPrime (int n){
        int x=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                x++;
            }
        }
        if(x==2) return true;
        else return false;
    } 
}
