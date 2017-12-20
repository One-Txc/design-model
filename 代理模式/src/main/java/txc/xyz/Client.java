package txc.xyz;

/**
 * Created by txc on 17-12-17.
 */
public class Client {
    public static void main(String[] args) throws Exception{
       /* Moveable m = new Tank();
        //m.move();
        TankTimeProxy ttp = new TankTimeProxy(m);
        //ttp.move();
        TankLogProxy tlp = new TankLogProxy(ttp);
        tlp.move();*/



        Comparable m = (Comparable) Proxy.newProxyInstance(Comparable.class,"abc");

        m.compareTo("www");


    }
}
