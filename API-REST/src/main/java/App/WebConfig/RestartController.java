package App.WebConfig;

import App.App;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestartController {

    @PostMapping("/restart")
    public void restart() {
        App.restart();
    }
}
