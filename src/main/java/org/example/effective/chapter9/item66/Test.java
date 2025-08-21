package org.example.effective.chapter9.item66;

public class Test {
    public static void main(String[] args) {
        RandomNumberGenerator rng = new RandomNumberGenerator();

        try{
            for(int i=0; i<5; i++){
                System.out.println("랜덤 수 : " + rng.nextInt(100));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
