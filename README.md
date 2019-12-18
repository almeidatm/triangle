# Project Triangle
## Descrição

Projeto para validar a aplicação [Calculadora de Triângulos](https://calculadoratriangulo.herokuapp.com/).

Utilizando:
* Maven para gestão de pacotes e dependências
* chromedriver para acessar o Google Chrome
* Cucumber para escrever cenários na linguagem Gherkin
* Junit para asserções
* Selenium para realizar interações com o browser

### Execução
Para executar, basta clonar o projeto, entrar na pasta raiz e executar o comando`mvn test`.

#### Drivers
É necessário selecionar qual driver utilizar baseado em seu sistema operacional. Para fazer isso, basta alterar o
driver referenciado no arquivo `src/test/java/triangle/Helper.java`. Altere o valor 'driverPath' na linha 11.
```
        String driverPath = projectDir + "/drivers/chromedriver_X";
```
As opções disponíveis são `chromedriver_linux`, `chromedriver_mac` e `chromedriver_win.exe`. A opção default do projeto
é `chromedriver_linux`.