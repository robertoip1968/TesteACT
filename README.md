
#    FLUXO DE CAIXA
        A Aplicação de fluxo de caixa foi desenvolvida utilizando arquitetura CLEAN, e principios do SOLID. 
        O Banco de dados escolhido foi o Mysql com instalação local, mas podendo ser instalado para rodar em container.
        
#    DESENHO DA ARQUITTURA
        Na pasta principal

#    TECNOLOGIAS:

#      1. Maven versão 4.0.0
#      2. Spring boot versão 3.0.0-M5.
#      3. Java versão 17
#      4. Spring Data jpa
#      5. Devtools
#      6. flywaydb - Migration
#      7. MySql - Instalação local 
#      8. Git
#      9. Junit

#    FERRAMENTAS:

#      1. IDE Intellij
#      2. Postman 

#    DESCRIÇÃO:

#      1. No controller de Caixa sao realizadas as seguintes operações:

#        1.1 Cadastra um novo caixa
            http://localhost:8080/caixa/salvar - Cria um novo Caixa
            RequestBody {"saldo": 1000,"flagAtivo": true,"dataCriacao": "2023-05-05"}
#        1.2 Lista todas os caixas
            http://localhost:8080/caixa/listar - Busca todos os Caixas
#        1.3 Retorna o status de um caixa (somente as contas ativas)
            http://localhost:8080/caixa/buscarCaixa/{id} - Verifica se o Caixa está ativo Por ID
#        1.4 Retorna o Saldo do caixa
            http://localhost:8080/caixa/saldo/{id} - Retorna o saldo da Conta
#        1.5 Retorna o Extrato de um Caixa (Lista de Transações)
            http://localhost:8080/caixa/extratoCaixa/{id} - Retorna o Extrato de transações do Caixa
#        1.6 Efetua uma retirada de valor do Caixa
            http://localhost:8080/caixa/sacar/{quantidade}/{id} - Efetua uma saída de valor no Caixa
#        1.7 Efetua uma Entrada de valor no Caixa
            http://localhost:8080/caixa/depositar/{quantidade}/{id} - Efetua uma entrada de valor no Caixa
#        1.8 Retorna o Saldo do Caixa pelo seu id
            http://localhost:8080/caixa/saldo/{id} - Retorna o saldo do Caixa

#      2. No Controller de Pessoa sao realizadas as seguintes operações :
#         2.1 Cadastra uma pessoa no banco de dados
            http://localhost:8080/pessoa/salvar - Cadastra uma nova pessoa no banco
            RequestBody {"nome": "Pessoa 4","cpf": "44444444444","datanascimento": "1968-09-11T04:00:00.000+00:00"}

#         2.2 Lista as Pessoas do banco de dados
            http://localhost:8080/pessoa/listar - Lista todas as Pessoas
#      3. No Controller de Transacao sao realizadas as seguintes operações :

#        4.1 /CRUD (Create, Read, Update, Delete) de uma transação


#    TESTES:

#      1. Teste realizado com junit para verificar se  CpfValido  e CpfInvalido de   uma Entidade pessoa

