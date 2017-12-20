package txc.xyz;

import txc.xyz.model.Person;

public interface Director {
    Person build(Builder builder);
}
