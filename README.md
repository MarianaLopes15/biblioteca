# ProjetoBiblioteca
Teste de avaliação 01
Projeto de um REST API para uma biblioteca, realizado por Mariana Lopes.

## 🔨 Funcionalidades do projeto

- `Funcionalidade 1` `Cadastro de Autores`: Para cadastrar um autor, devem ser informados seu nome e bibliografia. Todos os campos são obrigatórios. Campos nome 100 caracteres e biografia 1000 caracteres. 
- `Funcionalidade 2` `Alteração de Autores pelo id`: Para a alteração de um autor pelo seu id, é preciso informar obrigatoriamente seu id. Podendo alterar seu nome e bibliografia. Porém ambos os campos devem estar preenchidos, mesmo que não alterados. 
- `Funcionalidade 3` `Listar todos os autores`: Lista todos os autores cadastrados na API e suas informações.
- `Funcionalidade 5` `Listar autor pelo id`: Para realizar a busca de um autor pelo seu id, é preciso informar obrigatoriamente seu id. O sistema ira retorna o autor e suas informações.
- `Funcionalidade 6` `Listar todos os livros do autor pelo id`: Para listar todos os livros de um determinado autor é preciso informar obrigatoriamente seu id. O sistema ira retorna todos os livros do autor que estão cadastrados.
- `Funcionalidade 7` `Cadastro de livros`: Para cadastrar um livro na API, precisamos informar seu título, ano de lançamento e autor(es). O(s) autor(es) precisam estar previamente cadastrado no sistema. O titulo não pode ter mais que 200 caracteres. Todos os campos são obrigatórios.
- `Funcionalidade 8` `Alteração de livros pelo id`: Para a alteração de um livro pelo seu id, é preciso informar obrigatoriamente seu id. Podendo alterar seu titulo, ano de lançamento e autor(es). Porém os campos devem estar preenchidos, mesmo que não alterados. 
- `Funcionalidade 9` `Excluir um livro pelo id`: Para a exclusão de um livro pelo seu id, é preciso informar obrigatoriamente seu id. Resultando na exclusão do id solicitado.
- `Funcionalidade 10` `Listar todos os livros`: Lista todos os livros cadastrados na API e suas informações.
- `Funcionalidade 11` `Listar livro pelo id`: Para realizar a busca de um livro pelo seu id, é preciso informar obrigatoriamente seu id. O sistema ira retorna o livro e suas informações.

## ✔️ Técnicas e tecnologias utilizadas

- ``Java 17``
- ``Spring Boot``
- ``Hibernate``
- ``MySql``
- ``Swagger``

## 📁 Acesso ao projeto
Você pode acessar os arquivos do projeto clicando [aqui]https://github.com/MarianaLopes15/ProjetoBiblioteca/tree/main/biblioteca/src


## 🛠️ Abrir e rodar o projeto

Após baixar o projeto, você pode abrir com o Eclipse. 
Para isso, na tela incial da IDE no 'Project Explorer' clique com o botão direito e em import > import...

- Selecione 'Existing Maven Projects' e next
- Clique em 'Browse..' e procure o local onde o projeto está e o selecione (Caso o projeto seja baixado via zip, é necessário extraí-lo antes de procurá-lo)
- Por fim clique em Finish

O Eclipse deve baixar algumas dependencias para configurar o projeto, aguarde até finalizar. Ao finalizar, você pode executar a aplicação 🏆 

## 📚 Swagger
Após rodar a aplicação você pode acessar a documentação swagger pela url: http://localhost:8080/swagger-ui/index.html
