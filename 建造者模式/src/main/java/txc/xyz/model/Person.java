package txc.xyz.model;

public class Person {
    private String name;
    private Head head;
    private Body body;
    private Hand leftHand;
    private Hand rightHand;
    private Feet feet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Hand getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(Hand leftHand) {
        this.leftHand = leftHand;
    }

    public Hand getRightHand() {
        return rightHand;
    }

    public void setRightHand(Hand rightHand) {
        this.rightHand = rightHand;
    }

    public Feet getFeet() {
        return feet;
    }

    public void setFeet(Feet feet) {
        this.feet = feet;
    }
}
