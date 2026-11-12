import net.thevpc.gaming.atom.engine.SceneEngine;
import net.thevpc.gaming.atom.engine.collisiontasks.BorderCollision;
import net.thevpc.gaming.atom.engine.collisiontasks.SpriteCollision;
import net.thevpc.gaming.atom.engine.collisiontasks.SpriteCollisionTask;
import net.thevpc.gaming.atom.engine.collisiontasks.TileCollision;
import net.thevpc.gaming.atom.model.Sprite;


public class MissileCollisionTask implements SpriteCollisionTask {

    @Override
    public void collideWithBorder(BorderCollision collision) {
        destroy(collision.getSceneEngine(), collision.getSprite());
    }

    @Override
    public void collideWithSprite(SpriteCollision collision) {
        destroy(collision.getSceneEngine(), collision.getSprite());
    }

    @Override
    public void collideWithTile(TileCollision collision) {
        destroy(collision.getSceneEngine(), collision.getSprite());
    }


    private void destroy(SceneEngine engine, Sprite sprite) {
        final int id = sprite.getId();
        engine.invokeLater(() -> engine.removeSprite(id));
    }
}
