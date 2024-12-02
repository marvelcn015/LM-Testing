# LM-Testing

## Supported Models

- OpenAI
- Cohere
- Google Gemini

## Configuration

### API Keys Setup

1. Create `config.properties` in `src/main/resources/`
2. Add your API keys:

```properties
OPENAI_API_KEY=your_openai_key
COHERE_API_KEY=your_cohere_key
GEMINI_API_KEY=your_gemini_key
```

### Custom Prompts

The default prompt is "Please introduce yourself." To customize:

1. Open `src/main/java/final4j/lmtesting/RouteController.java`
2. Modify the `prompt` String variable

## Usage

Send a `GET` request to the following endpoints to receive responses in natural language:

```
/openai  - OpenAI models
/cohere  - Cohere models  
/gemini  - Google Gemini models
```

### Example

```bash
# Get response from OpenAI
curl http://localhost:8080/openai

# Get response from Cohere
curl http://localhost:8080/cohere

# Get response from Gemini
curl http://localhost:8080/gemini
```
