import net.thevpc.gaming.atom.model.DefaultSprite;

public class Missile extends DefaultSprite {

    public Missile(double x, double y) {
        super();
        setLocation(x, y);
        setName("Missile");
        setKind("Missile");
        setLife(1);
    }
}
