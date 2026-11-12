import net.thevpc.gaming.atom.model.DefaultSprite;

public class Ball extends DefaultSprite {

    public Ball(double x, double y) {
        super();
        setLocation(x, y);
        setName("MainBall");
        setKind("Ball");
        setLife(3);
        setDirection(0);
        setSpeed(2.0);
    }
}
