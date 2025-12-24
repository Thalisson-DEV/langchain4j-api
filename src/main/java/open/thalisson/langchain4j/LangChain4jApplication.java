package open.thalisson.langchain4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <h3>
 * Classe principal da aplicação LangChain4j.
 * </h3>
 * <p>
 * Esta é a classe de inicialização do Spring Boot que configura e executa
 * a aplicação de assistente de IA generativa integrada com o LangChain4j.
 * </p>
 *
 * @author Thalisson
 * @version 1.0
 * @since 2025
 */
@SpringBootApplication
public class LangChain4jApplication {

    /**
     * <h3>
     * Método principal que inicia a aplicação Spring Boot.
     * </h3><p>
     * Este método é o ponto de entrada da aplicação e inicializa
     * o contexto do Spring, carregando todas as configurações e
     * componentes necessários para o funcionamento do sistema.
     * </p>
     *
     * @param args argumentos da linha de comando passados na inicialização
     */
    public static void main(String[] args) {
        SpringApplication.run(LangChain4jApplication.class, args);
    }

}
