package open.thalisson.langchain4j.services;

import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

/**
 * <h3>
 * Interface de serviço para o assistente de IA especializado em vendas.
 * <h3/>
 * <p>
 * Esta interface define o contrato para o assistente de IA que atua como
 * um consultor de vendas para uma startup de IA generativa. O assistente
 * é configurado com instruções do sistema que definem seu comportamento,
 * limitando suas respostas a tópicos relacionados a modelos de IA generativa,
 * preços e contratação de serviços.
 * </p>
 * <p>
 * A interface é anotada com {@code @AiService}, permitindo que o LangChain4j
 * crie automaticamente uma implementação que integra o modelo de linguagem
 * com as ferramentas disponíveis.
 * </p>
 *
 * @author Thalisson
 * @version 1.0
 * @since 2025
 */
@AiService
public interface AssistantAiService {
    /**
     * <h3>
     * Processa uma requisição do usuário através do assistente de IA.
     * </h3>
     * <p>
     * Este método recebe uma mensagem do usuário e a processa de acordo
     * com as instruções do sistema configuradas. O assistente é especializado
     * em responder perguntas sobre:
     * <ul>
     *   <li>Modelos de IA disponíveis (fast, pro, deep research)</li>
     *   <li>Preços e cotações baseadas em tokens e modelos</li>
     *   <li>Taxas de uso e políticas de contratação</li>
     * </ul>
     * </p>
     * <p>
     * <strong>Comportamento do Assistente:</strong>
     * </p>
     * <ul>
     *   <li><strong>Detecção de Intenção:</strong> Identifica se a pergunta envolve
     *       cálculo de valores (preço, contratação) ou se é apenas informativa</li>
     *   <li><strong>Uso de Ferramentas:</strong> Utiliza ferramentas de cálculo
     *       quando necessário para gerar cotações precisas</li>
     *   <li><strong>Validação:</strong> Não inventa modelos além dos três disponíveis
     *       e solicita informações faltantes quando necessário</li>
     *   <li><strong>Escopo Limitado:</strong> Recusa educadamente responder sobre
     *       assuntos fora do domínio de IA generativa</li>
     * </ul>
     *
     * @param userMessage mensagem enviada pelo usuário contendo a pergunta ou requisição
     * @return {@link Result} contendo a resposta gerada pelo assistente de IA
     */
    @SystemMessage("""
            Você é um assistente de vendas em uma STARTUP DE IA GENERATIVA.
            Responda APENAS sobre IAs generativas (preços, taxa de uso, tokens, modelos, etc...).

            DETECÇÃO DE INTENÇÃO:
            - se a pergunta envolver VALOR, PREÇO, CONTRATAÇÃO com a indicação da MODELO e/ou NÚMERO DE TOKENS DA CONTRATAÇÃO
            use a ferramenta de cálculo para retornar uma cotação e explique o que está fazendo.
            - se for apenas INFORMATIVO (ex: tipos de modelos, política de uso, documentação),
            responda brevemente sem usar a ferramenta.

            IMPORTANTE:
            - Não invente modelos além de fast, pro e deep research.
            - Se faltar algum dado para o cálculo (ex.: tokens ou modelo), peça somente o que falta.
            - Se a pergunta for sobre assuntos fora de IAs generativas, responda apenas que não pode ajudar.
            """)
    Result<String> handleRequest(@UserMessage String userMessage);
}
