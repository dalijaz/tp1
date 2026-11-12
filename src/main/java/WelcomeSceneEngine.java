import net.thevpc.gaming.atom.annotations.AtomSceneEngine;
import net.thevpc.gaming.atom.engine.DefaultSceneEngine;

@AtomSceneEngine(id = "welcome", columns = 20, rows = 20, welcome = true)
public class WelcomeSceneEngine extends DefaultSceneEngine {

    @Override
    protected void sceneActivating() {
        // Rien à initialiser pour l'écran d'accueil
    }
}
