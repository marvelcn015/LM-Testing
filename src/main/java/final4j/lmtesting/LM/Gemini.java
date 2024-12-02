package final4j.lmtesting.LM;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import static final4j.lmtesting.Component.ApiKeySet.GEMINI_API_KEY;

public class Gemini {
    ChatLanguageModel gemini = GoogleAiGeminiChatModel.builder()
            .apiKey(GEMINI_API_KEY)
            .modelName("gemini-1.5-flash")
            .build();
    public String sendMessage(String prompt) {
        return gemini.generate(prompt);
    }
}
