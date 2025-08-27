gendamento de Transferências - Frontend
 - Frontend desenvolvido em Vue.js 3 com Element Plus para consumir a API de agendamento de transferências bancárias.

Visão Geral
 - Agendamento de transferências com cálculo automático de taxa

 - Visualização em tabela dos agendamentos realizados

 - Formulário validado para cadastro de novas transferências

 - Feedback de mensagens de erro com integração ao backend

Pré-requisitos
 - Node.js 20.x ou superior

 - npm (instalado junto com Node)

 - Backend rodando e disponível (ex: http://localhost:8080)

Instalação
 - Clone o repositório do frontend:

bash:
 - git clone <url-do-repositorio>
 - cd agendamento-transferencias
 - Instale as dependências:

bash:
 - npm install
 - npm install axios
 - npm install element-plus

Como rodar o projeto
 - Inicie o servidor de desenvolvimento:

bash:
 - npm run dev
 - O app ficará disponível em algo como http://localhost:5173.

Como usar
 - Agende uma transferência preenchendo todos os campos no formulário.

 - Clique em "Agendar" — se tudo estiver ok, a transferência aparecerá na tabela.

 - Veja mensagens de erro caso algum campo esteja inválido ou ocorra erro de regra de negócio no backend.

Configurações personalizadas
 - O endpoint da API é configurado nos arquivos .vue. Se necessário, troque http://localhost:8080/api/transferencias para o endereço do seu backend em produção ou outro ambiente.

Principais dependências
 - Vue.js 3

 - Element Plus

 - Axios

Estrutura dos principais arquivos

agendamento-transferencias/
├── src/
│   ├── App.vue
│   ├── components/
│   │   └── Transferencias.vue
│   ├── assets/
│   │   └── main.css
│   ├── main.js
├── public/
│   └── index.html
├── package.json

Teste rápido da conexão com backend
 - Certifique-se que a API backend está rodando (porta 8080 por padrão).

 - Cadastre uma transferência via formulário e confirme que ela aparece na tabela.