package txc.xyz;

import txc.xyz.model.Body;
import txc.xyz.model.Feet;
import txc.xyz.model.Hand;
import txc.xyz.model.Head;

public interface Builder {
    String buildName();
    Head buildHead();
    Body buildBody();
    Hand buildHand();
    Feet buildFeet();
}
