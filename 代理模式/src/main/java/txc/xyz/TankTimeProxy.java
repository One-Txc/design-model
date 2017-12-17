package txc.xyz;

/**
 * Created by txc on 17-12-17.
 */
public class TankTimeProxy implements Moveable{
    private Moveable m;

    public TankTimeProxy(Moveable m){
        this.m = m;
    }


    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));
    }
}
