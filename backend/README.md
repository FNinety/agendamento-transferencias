Funcionalidades
 - Agendamento de transferências financeiras entre contas.

 - Armazenamento dos seguintes dados por transferência:

 - Conta de origem

 - Conta de destino

 - Valor

 - Taxa (calculada conforme regras de negócio)

 - Data de transferência (data efetiva)

 - Data de agendamento (data atual)

Tecnologias Utilizadas
 - Java 11

 - Spring Boot 2.7.x

 - Spring Data JPA

 - H2 Database

 - Lombok

 - Gradle

Como executar o projeto

    1 -  Baixe o repositório.

    2 - Certifique-se de possuir o JDK 11 instalado.

    3 - Compile e rode o projeto Spring Boot:

    4 - bash
    ./gradlew bootRun
    Acesse o console do banco H2 em http://localhost:8080/h2-console.

    5 - O frontend Vue pode ser executado separadamente conforme instruções próprias.

Estrutura da Entidade

 - A entidade principal (Transferencia) possui os seguintes campos principais:

 - contaOrigem: String (formato XXXXXXXXXX)

  - contaDestino: String (formato XXXXXXXXXX)

 - valor: BigDecimal

 - taxa: BigDecimal (calculada)

 - dataTransferencia: LocalDate

 - dataAgendamento: LocalDate

Observações

 - O projeto utiliza Lombok para reduzir a verbosidade na criação de getters/setters.

 - O backend está pronto para integração com consumidores REST, como um frontend em Vue.

