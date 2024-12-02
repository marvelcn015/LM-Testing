package final4j.lmtesting.LM;

import dev.langchain4j.model.openai.OpenAiChatModel;
import static dev.langchain4j.model.openai.OpenAiChatModelName.GPT_4_O_MINI;
import static final4j.lmtesting.Component.ApiKeySet.OPENAI_API_KEY;

public class OpenAi {
    OpenAiChatModel model = OpenAiChatModel.builder()
            .apiKey(OPENAI_API_KEY)
            .modelName(GPT_4_O_MINI)
            .build();
    public String sendMessage(String prompt){
       return model.generate(prompt);
   }
}
