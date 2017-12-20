package txc.xyz;

public class Start {
    public static void main(String[] args) {
        Builder builder = new DefaultBuilder();
        Director director = new DefaultDirector();

        director.build(builder);
    }
}
