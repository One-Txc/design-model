package txc.xyz;

import txc.xyz.model.Person;

public class DefaultDirector implements Director{
    public Person build(Builder builder) {
        Person person = new Person();
        person.setName(builder.buildName());
        person.setHead(builder.buildHead());
        person.setBody(builder.buildBody());
        person.setLeftHand(builder.buildHand());
        person.setRightHand(builder.buildHand());
        //feet是foot的复数形势吧
        person.setFeet(builder.buildFeet());
        return person;
    }
}
