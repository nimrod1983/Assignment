package Tasks;

import java.util.HashSet;
import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        Random rn = new Random();
        HashSet<Integer> hSet = new HashSet<>();
        while(hSet.size() != 1000) {
            hSet.add(rn.nextInt(1000));
        }
        System.out.println(hSet);
    }

}
