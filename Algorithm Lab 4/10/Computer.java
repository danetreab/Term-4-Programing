public class Computer {
    private String brand;
    private String model;
    private int RAMSize;
    private int HDDSize;
    public Computer(){

    }
    public Computer(String brand){
        this.brand=brand;
    }
    public Computer(String brand, String model,int RAMSize){
        this.brand=brand;
        this.model=model;
        this.RAMSize=RAMSize;
    }
    public Computer(String brand, String model,int RAMSize,int HDDSize){
        this.brand=brand;
        this.model=model;
        this.RAMSize=RAMSize;
        this.HDDSize=HDDSize;
    }
    public void printInfo(){
        System.out.println("Brand \""+brand+"\"\tModel \""+model+"\"\tRamSize \""+RAMSize+"\"\tHDDSize \""+HDDSize+"\"");
    }
}
