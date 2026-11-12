import net.thevpc.gaming.atom.annotations.AtomSceneController;
import net.thevpc.gaming.atom.presentation.DefaultSceneController;
import net.thevpc.gaming.atom.presentation.KeyCode;
import net.thevpc.gaming.atom.presentation.SceneKeyEvent;


@AtomSceneController(name = "welcomeController", scene = "welcome")
public class WelcomeController extends DefaultSceneController {

    public WelcomeController() {
        addAllAcceptedEvents();
    }

    @Override
    public void keyPressed(SceneKeyEvent e) {
        if (e.getKeyCode() == KeyCode.SPACE) {
            e.getGameEngine().setActiveSceneEngine("balls");
        }
    }
}
