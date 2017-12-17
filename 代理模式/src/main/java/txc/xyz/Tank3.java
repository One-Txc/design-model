package txc.xyz;

/**
 * Created by txc on 17-12-17.
 */
public class Tank3 implements Moveable{
    private Tank tank;

    public Tank3(Tank tank){
        this.tank = tank;
    }


    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));
    }
}
