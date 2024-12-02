package final4j.lmtesting;

import final4j.lmtesting.LM.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class RouteController {

    static private String prompt = "Please introduce yourself.";

    @GetMapping("/openai")
    public String openai() {
        OpenAi openai = new OpenAi();
        return openai.sendMessage(prompt);
    }

    @GetMapping("/cohere")
    public String cohere() {
        Cohere cohere = new Cohere();
        return cohere.sendMessage(prompt);
    }

    @GetMapping("/gemini")
    public String gemini(){
        Gemini gemini = new Gemini();
        return gemini.sendMessage(prompt);
    }
}
