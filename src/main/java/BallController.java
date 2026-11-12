import net.thevpc.gaming.atom.annotations.AtomSceneController;
import net.thevpc.gaming.atom.presentation.DefaultSceneController;
import net.thevpc.gaming.atom.presentation.KeyCode;
import net.thevpc.gaming.atom.presentation.SceneKeyEvent;


@AtomSceneController(name = "ballController", scene = "balls")
public class BallController extends DefaultSceneController {

    public BallController() {
        addAllAcceptedEvents();
    }

    @Override
    public void keyPressed(SceneKeyEvent e) {
        if (e.getKeyCode() == KeyCode.SPACE) {
            BallSceneEngine engine = (BallSceneEngine) e.getSceneEngine();
            engine.fireMissile();
        }
    }
}
