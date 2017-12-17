package txc.xyz;

/**
 * Created by txc on 17-12-17.
 */
public class TankLogProxy implements Moveable {
    private Moveable m;

    public TankLogProxy(Moveable m){
        this.m = m;
    }


    @Override
    public void move() {
        System.out.println("tank start");
        m.move();
        System.out.println("tank end");
    }
}
