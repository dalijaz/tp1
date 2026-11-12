import net.thevpc.gaming.atom.engine.collisiontasks.BorderCollision;
import net.thevpc.gaming.atom.engine.collisiontasks.SpriteCollisionTask;
import net.thevpc.gaming.atom.model.CollisionSides;
import net.thevpc.gaming.atom.model.ModelVector;
import net.thevpc.gaming.atom.model.Sprite;

public class BallCollisionTask implements SpriteCollisionTask {

    @Override
    public void collideWithBorder(BorderCollision collision) {
        System.out.println("COLLISION BORD : " + collision.getSpriteCollisionSides());
        collision.adjustSpritePosition();   // évite que la balle colle au mur

        Sprite sprite = collision.getSprite();
        CollisionSides sides = collision.getSpriteCollisionSides();

        double vx = sprite.getVelocity().getX();
        double vy = sprite.getVelocity().getY();

        if (sides.isEast() || sides.isWest()) {
            vx = -vx;
        }
        if (sides.isNorth() || sides.isSouth()) {
            vy = -vy;
        }

        sprite.setVelocity(ModelVector.newCartesien(vx, vy));
    }
}
