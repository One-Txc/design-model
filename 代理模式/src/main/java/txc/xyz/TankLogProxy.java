package txc.xyz;

/**
 * Created by txc on 17-12-17.
 */
public class TankLogProxy implements Moveable {
    private Tank tank;

    public TankLogProxy(Tank tank){
        this.tank = tank;
    }


    @Override
    public void move() {
        System.out.println("tank start");
        tank.move();
        System.out.println("tank end");
    }
}
