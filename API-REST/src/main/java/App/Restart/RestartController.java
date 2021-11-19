package App.Restart;

import App.App;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestartController {

    @GetMapping("/rst")
    public String test() {
        return "Get OK";
    }

    @PostMapping("/restart")
    public void restart() {
        App.restart();
    }


}
