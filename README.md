
Desafio

Cenário/Requisito obrigatório
1 - WEB (Selenium - BDD - Cucumber):
Desenvolva, uma automação de testes para o e-commerce: https://automationexercise.com/

O projeto deve conter, pelo menos, um cenário de teste para a seguinte História do Usuário:

História do Usuário #1:
Como um cliente cadastrado no https://automationexercise.com/
Eu quero fazer a compra de ao menos três produtos
Para que eu possa estar bem vestida

Os seguintes produtos do e-commerce devem ser adicionados ao carrinho de compras com as seguintes quantidades.
- Stylish Dress - 3 Itens
- Beautiful Peacock Blue Cotton Linen Saree - 2 itens
- Men Tshirt - 1

CENÁRIO BÔNUS
Desenvolva um novo cenário para a anteriormente citada no qual é realizado o cadastro de um novo usuário.

Como executar o projeto:
Importar na IDE de preferencia o projeto como maven java
Abrir o arquivo \src\test\java\TestRunner\CucumberTestRunner.java e executar.

Arquitetura do Projeto
Pacotes:

Core: Pacote responsavel pela parte do core da automação, como acesso ao driver e ações dos elementos

PageFactory: Pacote responsavel pela parte das ações das paginas, como preenchimento, cliques, retornos de conteudose também pelo mapeamento dos elementos e integração dos objetos com o driver.

TestRunner: Pacote responsavel pela parte das classes de execuções.

Utils: Pacote responsavel para guardar todas as classes que contenham metodos que possam ser usadas por varios métodos ou classes

StepsDefinitions: Pacote responsavel para guardar as Classes de Steps, as quais são geradas pelo cucumber. Nessas classes são chamadas as ações das paginas através das pages e validações.

features: Diretório responsável para guardar os arquivos .feature, onde estão gravados os arquivos relacionados ao cucumber e as escrita em gherkin

Libs utilizadas
PageFactory: 
Cucumber: Dependencia responsável pela leitura dos arquivos .feature escritos em gherkin e realizacao da conversao em metodos.
Maven: Responsavel por gerenciar as dependencias utilizadas no projeto.

Bibliotescas utilizadas:

selenium-java (Versão: 4.11)

cucumber-testng

cucumber-java

testng

faker
