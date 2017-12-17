package txc.xyz;

import java.util.Random;

/**
 * Created by txc on 17-12-17.
 */
public class Tank implements Moveable{
    @Override
    public void move(){
//        long start = System.currentTimeMillis();
        System.out.println("Tank moving...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        long end = System.currentTimeMillis();
//        System.out.println("time:"+(end-start));
    }
}
