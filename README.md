# Gerador de Senhas Aleatórias

Este é um aplicativo Android de geração de senhas aleatórias. Ele permite que os usuários criem senhas seguras e personalizáveis com opções de configuração, como o comprimento da senha e a inclusão de diferentes tipos de caracteres. O aplicativo é desenvolvido em Kotlin e apresenta uma interface limpa e intuitiva.

## Funcionalidades

- **Geração de Senha**: Criação de senhas aleatórias com base nas preferências definidas pelo usuário.
- **Opções de Caracteres**:
  - Incluir letras maiúsculas
  - Incluir letras minúsculas
  - Incluir números
  - Excluir caracteres semelhantes (ex.: `0`, `O`, `l`, `1`)
- **Configuração de Comprimento**: Defina o comprimento da senha usando uma barra deslizante (máximo de 20 caracteres).
- **Botão de Regeneração**: Gere uma nova senha aleatória com as configurações escolhidas.
- **Botão de Copiar**: Copie a senha gerada para a área de transferência com um único toque.

## Interface

O aplicativo utiliza o azul do Cruzeiro (#003DA5) como a cor principal, proporcionando uma interface amigável e visualmente agradável.

### Tela Principal
A tela principal exibe:
1. A senha gerada em destaque.
2. Controles de configuração de caracteres e comprimento.
3. Botões para regenerar e copiar a senha.

![image](https://github.com/user-attachments/assets/202b295d-68e3-470e-947f-35f9f63db1a6)


## Tecnologias Utilizadas

- **Linguagem**: Kotlin
- **Layout**: ConstraintLayout e LinearLayout
- **Android SDK**: Compatível com Android 5.0 (API 21) ou superior
