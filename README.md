# Micro Framework para Processamento de Exercícios <br>

Autor: Fernando Bino Machado <br><br>

<h2 id="h2-sumario">Sumario</h2>

<ul>
	<li><a href="#h2-introducao">1 - Introdução</a> </li>
	<li><a href="#h2-iniciando">2 - Iniciando Projeto de Exercícios</a></li>
	<li><a href="#h2-estrutura-projeto">3 - Estrutura do Projeto de Exercícios</a></li>
	<li><a href="#h2-como-debugar">4 - Debugando Exercícios</a></li>
</ul>

<h2 id="h2-introducao">1 - Introdução</h2><br>

<p align="justify">Quem nunca começou um curso ou uma play-list no youtube sobre algum tema de programação, tal como, herança, interfaces, tipos primitivos, lambda etc. Enquanto assisitimos ao conteúdo é natural espalharmos um bilhão de classes com qualquer nome e um salvador método main. No momento inicial de conhecer os conceitos, essas classes milagrosas funcionam bem, mas as semanas passam e depois vamos precisar novamente daquele determinado tema. E agora, como encontrar essas classes milagrosas espalhadas em vários projetos sem padrão algum? A saída é recorrer ao mesmo video/conteúdo visto semanas antes e irônicamente produzir mais uma classe e mais um método main em qualquer lugar por acaso...</p>
<p align="justify">Não que isso seja errado, só é uma pratica ruim, principalmente quando estamos aprendendo algo novo. E que tal se pudessemos aprender esses temas importantes e formar nossa própria bibliotéca pessoal de classes, exemplos, e cases? Que tal se o aprendizado fosse documentado com comentários e explicações? Exemplos didáticos no próprio código fáceis de localizar, otimizando tempo no aprendizado e consolidando cada vez mais nosso conhecimento?</p>
<p align="justify">Refletindo muito sobre essa necessidade comum a todos, desenvolvi o presente projeto que consiste em um micro framework para processamento de exercícios chamado FBMEXDEBUG. Com ele podemos criar exercícios padronizados, com anotações do framework, permitindo filtrar facilmente os exercícios por titulo, tema ou numeração da aula. Esse projeto apresenta uma solução ao problema recorrente que todos passamos, pois organiza nosso aprendizado e permite que se apropriemos do que aprendemos, o aprendizado se torna nossa experiência pessoal documentada, e com propriedade vamos buscá-lo no futuro, não em um fórum, mas na nossa bibliotéca pessoal de exercícios.
</p>
<p align="justify">Existem algumas maneiras de utilizar o framework que envolvem desde baixar o jarfile e criar nosso projeto seguindo passo a passo, até mesmo utilizar um inicilializador automático de projeto no padrão do framework. A seguir continuaremos abordando sobre.</p>

<br>
<a href="#sumario">Voltar Sumário</a>
<br>


<h2 id="h2-iniciando">2 - Iniciando um Projeto de Exercícios</h2><br>

<p align="justify">É possível utilizar o gerador de projetos para iniciar um projeto de Exercícios nos padrões do framework, para isso basta baixar o jarfile na pasta generator. Após ter baixado o jarfile, execute o programa e siga os passos abaixo:</p>
<br>

<p align="justify">Preencha os campos de acordo com a necessidade do seu projeto</p>

![Preenchimento dos Campos](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/tela_campos.png)

<br>

<p align="justify">Clique em Concluir, e verá que em seguida uma barra de progresso e alguns logs serão exibidos</p>

![Preenchimento dos Campos](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/clique_concluir.png)

<br>

<p align="justify">Aguarde até a conclusão tal como abaixo, onde verá a mensagem de confirmação</p>

![Preenchimento dos Campos](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/confirmacao.png)

<br>
<a href="#sumario">Voltar Sumário</a>
<br>

<h2 id="h2-estrutura-projeto">3 - Estrutura do Projeto</h2><br>

<p align="justify">Após ter sido criado, o projeto de exercícios terá a seguinte estrutura:</p>

![Preenchimento dos Campos](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/estrutura_projeto.png)

<p align="justify">A seguir faremos um breve comentário sobre cada item importante.</p>

<p align="justify"><b>StartUserAplication.java</b> </b>Dentro do pacote app, essa classe é responsável por iniciar a janela, isto é, interface que permite filtrarmos e pesquisarmos os exercícios que criamos, então dentro de StartUserAplication.java existe um método main que basicamente abrirá a seguinte janela:</p>

![Preenchimento dos Campos](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/janela_pesquisa.png)

<br>
<a href="#sumario">Voltar Sumário</a>
<br>

<h2 id="h2-como-debugar">4 - Debugando Exercícios</h2>

<p align="justify">Agora basta adicionar um <b>break point</b> dentro do método processar, e todas as implementações de ExGeneric recebidas pelo framework, passaram por esse método, e nesse momento você terá a chance de debugar todos os seus exercícios. Aqui é importante dizer que quando sua aplicação iniciar, será exibida um janela padrão de pesquisa de exercícios implementados no pacote base definido. </p>
<br>
<p align="justify">Nessa Janela, logo após você ter localizado seus exercícios, ao clicar em <b>Debugar</b> o framework irá processar todos os exercícios localizados e passará um por um como parâmetro para esse método processar da classe UserServiceImpl exemplificada acima. Dessa forma, você terá organização e controle, e poderá consultar sua "<b>bibliotéca de exercícios</b>".</p>

<br>
<p align="justify">Talvez isso não pareça grande coisa se olhar somente para esse exemplo, mas considere que você pode implementar seus exercicios adicionando anotações @Assunto, @Flags além de @ExMap e através dessas anotações pode sistematicamente organizar seus exercícios dispensando a criação de inúmeros projetos e usando a organização que o framework provê, para sistematicamente localizar e debugar seus exercícios.</p>

<br>
<a href="#sumario">Voltar Sumário</a>
<br>

