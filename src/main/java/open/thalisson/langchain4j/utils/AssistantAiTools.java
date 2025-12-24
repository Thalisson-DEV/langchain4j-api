package open.thalisson.langchain4j.utils;

import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <h3>
 * Classe de ferramentas auxiliares para o assistente de IA.
 * </h3>
 * <p>
 * Esta classe fornece ferramentas especializadas que podem ser utilizadas
 * pelo assistente de IA para realizar cálculos e operações específicas.
 * As ferramentas são automaticamente reconhecidas pelo LangChain4j através
 * da anotação {@code @Tool} e podem ser invocadas pelo modelo de IA quando necessário.
 * </p>
 * <p>
 * Atualmente, implementa funcionalidades de cálculo de cotações baseadas
 * em modelos de IA e quantidade de tokens, considerando preços base e
 * taxas de uso diferenciadas por modelo.
 * </p>
 *
 * @author Thalisson
 * @version 1.0
 * @since 2025
 */
@Component
public class AssistantAiTools {

    /**
     * <h3>
     * Mapa contendo o preço base por token para cada modelo de IA disponível.
     * </h3>
     * <p>
     * Os valores representam o custo unitário em reais (R$) por token:
     * <ul>
     *   <li><strong>fast:</strong> R$ 150,00 por token - modelo mais rápido e econômico</li>
     *   <li><strong>pro:</strong> R$ 300,00 por token - modelo intermediário com melhor qualidade</li>
     *   <li><strong>deep research:</strong> R$ 500,00 por token - modelo mais avançado para análises complexas</li>
     * </ul>
     * </p>
     */
    private static final Map<String, Double> TOKEN_BASE_PRICE = Map.of(
            "fast", 150.0,
            "pro", 300.0,
            "deep research", 500.0
    );

    /**
     * <h3>
     * Mapa contendo a taxa de uso adicional para cada modelo de IA.
     * </h3>
     * <p>
     * As taxas são aplicadas sobre o valor base e representam percentuais:
     * <ul>
     *   <li><strong>fast:</strong> 5% (0.05) de taxa adicional</li>
     *   <li><strong>pro:</strong> 8% (0.08) de taxa adicional</li>
     *   <li><strong>deep research:</strong> 12% (0.12) de taxa adicional</li>
     * </ul>
     * </p>
     */
    private static final Map<String, Double> USAGE_RATE = Map.of(
            "fast", 0.05,
            "pro", 0.08,
            "deep research", 0.12
    );

    /**
     * <h3>
     * Calcula o valor total da cotação para uso de um modelo de IA.
     * </h3>
     * <p>
     * Esta ferramenta é automaticamente invocada pelo assistente de IA quando
     * necessário calcular o preço de contratação de um modelo específico.
     * O cálculo considera:
     * </p>
     * <ol>
     *   <li>Preço base do modelo por token</li>
     *   <li>Quantidade de tokens solicitada</li>
     *   <li>Taxa de uso adicional específica do modelo</li>
     * </ol>
     * <p>
     * <strong>Fórmula:</strong> {@code Total = (PreçoBase × Tokens) × (1 + TaxaUso)}
     * </p>
     *
     * @param model nome do modelo de IA (case-insensitive). Valores aceitos:
     *              "fast", "pro" ou "deep research"
     * @param tokens quantidade de tokens para cálculo da cotação
     * @return String formatada contendo a cotação detalhada com o valor total
     *         em reais e a porcentagem da taxa de uso aplicada
     * @throws NullPointerException se o modelo especificado não existir no mapa de preços
     */
    @Tool("Calcula o valor total do aluguel do modelo com base no modelo do agente e numero de tokens")
    public String calculateQuotation(String model, int tokens) {
        Double base = TOKEN_BASE_PRICE.get(model.toLowerCase());
        Double rate = USAGE_RATE.get(model.toLowerCase());

        double total = (base * tokens) * (1 + rate);
        return String.format(
                "Cotação: %s por %d tokens -> R$ %.2f (inclui taxa de uso %.0f%%",
                model, tokens, total, rate * 100
        );
    }
}
