package App.Restart;

import App.App;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestartController {

    @PostMapping("/restart")
    public void restart() {
        App.restartThread();
    }
}
