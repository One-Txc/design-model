package txc.xyz;

import txc.xyz.model.Body;
import txc.xyz.model.Feet;
import txc.xyz.model.Hand;
import txc.xyz.model.Head;

public class DefaultBuilder implements Builder{

    public String buildName() {
        return "default";
    }

    public Head buildHead() {
        System.out.println("default.buildHead");
        return new Head();
    }

    public Body buildBody() {
        System.out.println("default.buildBody");
        return new Body();
    }

    public Hand buildHand() {
        System.out.println("default.buildHand");
        return new Hand();
    }

    public Feet buildFeet() {
        System.out.println("default.buildFeet");
        return new Feet();
    }
}
