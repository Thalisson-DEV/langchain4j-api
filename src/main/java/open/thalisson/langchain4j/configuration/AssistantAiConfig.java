package open.thalisson.langchain4j.configuration;

import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import open.thalisson.langchain4j.services.AssistantAiService;
import open.thalisson.langchain4j.utils.AssistantAiTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <h3>
 * Classe de configuração para os serviços de IA da aplicação.
 * </h3>
 * <p>
 * Esta classe gerencia a configuração e inicialização dos componentes
 * relacionados ao modelo de chat do Google Gemini AI e ao serviço de
 * assistente de IA, integrando-os através do LangChain4j.
 * </p>
 *
 * @author Thalisson
 * @version 1.0
 * @since 2025
 */
@Configuration
public class AssistantAiConfig {

    /**
     * Chave de API do Google Gemini obtida do arquivo de propriedades.
     * Esta chave é necessária para autenticar as requisições à API do Gemini.
     */
    @Value("${gemini.api-key}")
    private String geminiApiKey;

    /**
     * Nome do modelo Gemini a ser utilizado, configurado no arquivo de propriedades.
     */
    @Value("${gemini-model}")
    private String geminiModel;

    /**
     * <h3>
     * Cria e configura um bean do modelo de chat Google Gemini AI.
     * </h3>
     * <p>
     * Este bean é responsável por estabelecer a comunicação com a API
     * do Google Gemini, utilizando as credenciais e modelo configurados.
     * </p>
     *
     * @return instância configurada de {@link GoogleAiGeminiChatModel}
     */
    @Bean
    public GoogleAiGeminiChatModel googleAiGeminiChatModel() {
        return GoogleAiGeminiChatModel.builder()
                .apiKey(geminiApiKey)
                .modelName(geminiModel)
                .build();
    }

    /**
     * <h3>
     * Cria e configura o serviço de assistente de IA.
     * </h3>
     * <p>
     * Este bean integra o modelo de chat do Gemini com as ferramentas
     * personalizadas (tools) do assistente, criando um serviço completo
     * de IA capaz de processar requisições e utilizar ferramentas especializadas.
     * </p>
     *
     * @param model instância do modelo de chat do Google Gemini
     * @param assistantAiTools ferramentas auxiliares do assistente de IA
     * @return instância configurada de {@link AssistantAiService}
     */
    @Bean
    public AssistantAiService assistant(GoogleAiGeminiChatModel model, AssistantAiTools assistantAiTools) {
        return AiServices.builder(AssistantAiService.class)
                .chatModel(model)
                .tools(assistantAiTools)
                .build();
    }
}
