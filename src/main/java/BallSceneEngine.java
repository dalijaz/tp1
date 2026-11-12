import java.util.ArrayList;
import java.util.List;

import net.thevpc.gaming.atom.annotations.AtomSceneEngine;
import net.thevpc.gaming.atom.engine.DefaultSceneEngine;
import net.thevpc.gaming.atom.engine.SceneEngine;
import net.thevpc.gaming.atom.engine.SceneEngineFrameListener;
import net.thevpc.gaming.atom.model.ModelVector;
import net.thevpc.gaming.atom.model.SceneEngineModel;
import net.thevpc.gaming.atom.model.Sprite;

@AtomSceneEngine(id = "balls", columns = 20, rows = 20)
public class BallSceneEngine extends DefaultSceneEngine {

    private static final double BOARD_W = 20;   // doit correspondre à columns
    private static final double BOARD_H = 20;   // doit correspondre à rows

    @Override
    protected void sceneActivating() {

        Ball ball = new Ball(10, 10);
        ball.setVelocity(ModelVector.newCartesien(0.1, 0.1));
        addSprite(ball);


        setSpriteCollisionTask(ball, new BallCollisionTask());


        addSceneFrameListener(new SceneEngineFrameListener() {
            @Override
            public void modelUpdated(SceneEngine engine, SceneEngineModel model) {
                update();
            }
        });
    }


    public void update() {

        List<Sprite> sprites = new ArrayList<>(getSprites());

        for (Sprite s : sprites) {
            double vx = s.getVelocity().getX();
            double vy = s.getVelocity().getY();
            double nx = s.getX() + vx;
            double ny = s.getY() + vy;

            boolean outX = nx < 0 || nx + s.getWidth() > BOARD_W;
            boolean outY = ny < 0 || ny + s.getHeight() > BOARD_H;

            if ("Missile".equals(s.getKind())) {
                if (outX || outY) {
                    removeSprite(s.getId());     // le missile se détruit
                } else {
                    s.setLocation(nx, ny);
                }
            } else {

                if (outX) {
                    vx = -vx;
                    nx = s.getX();
                }
                if (outY) {
                    vy = -vy;
                    ny = s.getY();
                }
                s.setVelocity(ModelVector.newCartesien(vx, vy));
                s.setLocation(nx, ny);
            }
        }
    }


    public void fireMissile() {
        Sprite ball = findSpriteByName("MainBall");
        if (ball == null) {
            return;
        }
        Missile missile = new Missile(ball.getX(), ball.getY());
        missile.setVelocity(ModelVector.newCartesien(
                ball.getVelocity().getX() * 2,
                ball.getVelocity().getY() * 2
        ));
        addSprite(missile);
        setSpriteCollisionTask(missile, new MissileCollisionTask());
    }
}