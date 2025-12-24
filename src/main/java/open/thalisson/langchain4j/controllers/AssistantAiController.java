package open.thalisson.langchain4j.controllers;

import dev.langchain4j.service.Result;
import open.thalisson.langchain4j.services.AssistantAiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3>
 * Controlador REST responsável por gerenciar as requisições ao assistente de IA.
 * </h3>
 * <p>
 * Este controlador expõe endpoints para interação com o assistente de IA,
 * processando mensagens dos usuários e retornando as respostas geradas.
 * Todas as rotas estão sob o caminho base {@code /api/v1/assistant}.
 * </p>
 *
 * @author Thalisson
 * @version 1.0
 * @since 2025
 */
@RestController
@RequestMapping("api/v1/assistant")
public class AssistantAiController {

    /**
     * Serviço de assistente de IA injetado para processar requisições.
     */
    private final AssistantAiService assistantAiService;

    /**
     * Construtor para injeção de dependência do serviço de assistente.
     *
     * @param assistantAiService instância do serviço de IA a ser utilizada
     */
    public AssistantAiController(AssistantAiService assistantAiService) {
        this.assistantAiService = assistantAiService;
    }

    /**
     * <h3>
     * Endpoint para enviar uma mensagem ao assistente de IA.
     * </h3>
     * <p>
     * Recebe uma mensagem do usuário via POST e a processa através do
     * serviço de assistente de IA, retornando a resposta gerada pelo modelo.
     * </p>
     *
     * @param userMessage mensagem enviada pelo usuário no corpo da requisição
     * @return resposta gerada pelo assistente de IA como String
     */
    @PostMapping
    public String askAssistant(@RequestBody String userMessage) {
        Result<String> result = assistantAiService.handleRequest(userMessage);
        return result.content();
    }
}
