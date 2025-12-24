<div align="center">
<h1>LangChain4j Assistant API</h1>
<p>
<strong>API inteligente desenvolvida em Spring Boot, integrada com LangChain4j e Google Gemini AI, capaz de processar conversas naturais e executar ferramentas personalizadas (Tool Calling) para cálculos financeiros de "contratação".</strong>
</p>
<p>
<img src="https://img.shields.io/badge/Status-Desenvolvimento-yellow" alt="Status do Projeto: Desenvolvimento">
<img src="https://img.shields.io/badge/Java-21%2B-blue?logo=java&logoColor=white" alt="Java 21+">
<img src="https://img.shields.io/badge/Spring%20Boot-3.x-green?logo=spring-boot" alt="Spring Boot 3.x">
<img src="https://img.shields.io/badge/IA-LangChain4j-orange" alt="LangChain4j">
<img src="https://img.shields.io/badge/Model-Gemini-blueviolet?logo=google" alt="Google Gemini">
</p>
</div>

---

## 📋 Índice
- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades Principais](#-funcionalidades-principais)
- [Integração com IA](#-integração-com-ia)
- [Endpoints da API](#-endpoints-da-api)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Como Executar o Projeto](#-como-executar-o-projeto)
- [Configuração](#-configuração)
- [Contribuições](#-contribuições)

---

## 📚 Sobre o Projeto
O **LangChain4j Assistant API** é uma aplicação backend projetada para demonstrar o poder da integração entre Java e Modelos de Linguagem Grande (LLMs). Utilizando o framework **LangChain4j**, a aplicação conecta-se ao modelo **Google Gemini** para criar um assistente virtual capaz de manter conversas contextuais e, crucialmente, executar lógica de negócios específica através de "Function Calling" (chamada de ferramentas), permitindo cálculos precisos que modelos de linguagem puros muitas vezes erram.

## 👨‍💻 Funcionalidades Principais
* **Chat Conversacional:** Interface REST para interação em linguagem natural com o modelo de IA.
* **Tool Calling (Chamada de Ferramentas):** O assistente identifica automaticamente quando precisa usar código Java para realizar tarefas específicas (ex: cálculos de contratação de modelo, como nessa aplicação).
* **Cálculos de Contratação:** Ferramenta dedicada para calcular o valor final da contratação do agente com base em seus respectivos tokens.
* **Configuração Flexível:** Parâmetros de comportamento do modelo ajustável via configuração.

---

## 🤖 Integração com IA

Este projeto utiliza o conceito de **AI Services** do LangChain4j.

*   **Prompt Engineering:** O sistema instrui a IA a se comportar de maneira educada e concisa.
*   **Tools:** Quando o usuário pergunta algo como *"Quanto custa a contratação do modelo fast com 50 tokens de uso?"*, a IA não "alucina" o resultado. Ela reconhece a intenção, extrai os parâmetros e chama o método Java `calculateQuotation` definido na aplicação, retornando o valor exato calculado matematicamente.

---

## 🔌 Endpoints da API

A aplicação expõe os seguintes endpoints REST:

| Método | Endpoint           | Descrição |
|--------|--------------------|---|
| `POST` | `api/v1/assistant` | Envia uma mensagem para o assistente e recebe a resposta processada. |

### Exemplo de Uso
**Requisição:**
`POST api/v1/assistant?userMessage=Qual o valor dos modelos disponiveis?`

**Resposta:**
`A cotação para o modelo fast com 50 tokens fica em R$ 7875,00 (já incluindo a taxa de uso de 5%).`