# Micro Framework para Processamento de Exercícios <br>

Autor: Fernando Bino Machado <br><br>

**Projeto Despriorizado Temporariamente**

<h2 id="h2-sumario">Sumario</h2>

<ul>
	<li><a href="#h2-introducao">1 - Introdução</a> </li>
	<li><a href="#h2-iniciando">2 - Iniciando Projeto de Exercícios</a></li>
	<li><a href="#h2-estrutura-projeto">3 - Estrutura do Projeto de Exercícios</a>
		<ul>
			<li><a href="#b-StartUserAplication">3.1 - Classe StartUserAplication</a></li>
			<li><a href="#b-AloMundoEx">3.2 - Classe AloMundoEx</a></li>
			<li><a href="#b-UserServiceImpl">3.3 - Classe UserServiceImpl</a></li>
			<li><a href="#b-impl.exercicio">3.4 - Pacote impl.exercicio</a></li>
		</ul>
	</li>
	<li><a href="#h2-como-debugar">4 - Debugando Exercícios</a></li>
	<li><a href="#h2-anotacoes">5 - Anotações em um Exercício</a>
		<ul>
			<li><a href="#b-ann-Assunto">5.1 - @Assunto</a></li>
			<li><a href="#b-ann-ExMap">5.2 - @ExMap</a></li>
			<li><a href="#b-ann-Flags">5.2 - @Flags</a></li>
			<li><a href="#b-ann-Ignore">5.4 - @Ignore</a></li>
			<li><a href="#b-ann-Repetir">5.5 - @Repetir</a></li>
		</ul>
	</li>
</ul>

<h2 id="h2-introducao">1 - Introdução</h2><br>

<p align="justify">Quem nunca começou um curso ou uma play-list no youtube sobre algum tema de programação, tal como, herança, interfaces, tipos primitivos, lambda etc. Enquanto assisitimos ao conteúdo é natural espalharmos um bilhão de classes com qualquer nome e um salvador método main. No momento inicial de conhecer os conceitos, essas classes milagrosas funcionam bem, mas as semanas passam e depois vamos precisar novamente daquele determinado tema. E agora, como encontrar essas classes milagrosas espalhadas em vários projetos sem padrão algum? A saída é recorrer ao mesmo video/conteúdo visto semanas antes e irônicamente produzir mais uma classe e mais um método main em qualquer lugar por acaso...</p>
<p align="justify">Não que isso seja errado, só é uma pratica ruim, principalmente quando estamos aprendendo algo novo. E que tal se pudessemos aprender esses temas importantes e formar nossa própria bibliotéca pessoal de classes, exemplos, e cases? Que tal se o aprendizado fosse documentado com comentários e explicações? Exemplos didáticos no próprio código fáceis de localizar, otimizando tempo no aprendizado e consolidando cada vez mais nosso conhecimento?</p>
<p align="justify">Refletindo muito sobre essa necessidade comum a todos, desenvolvi o presente projeto que consiste em um micro framework para processamento de exercícios chamado FBMEXDEBUG. Com ele podemos criar um projeto de exercícios padronizado, com anotações do framework, permitindo filtrar facilmente os exercícios por titulo, tema ou numeração da aula. Esse projeto apresenta uma solução ao problema recorrente que todos passamos, pois organiza nosso aprendizado e permite que se apropriemos do que aprendemos, o aprendizado se torna nossa experiência pessoal documentada, e com propriedade vamos buscá-lo no futuro, não em um fórum, mas na nossa bibliotéca pessoal de exercícios.
</p>
<p align="justify">A seguir será apresentado como iniciar um projeto de exercícios, vamos também entender sua estrutura. Além disso será mostrado como localizar os exercícios e debugá-los e também vamos falar sobre um conjunto de anotações padrões do framework que podemos utilizar nos exercícios para facilitar sua localização.</p>

<a href="#sumario">Voltar Sumário</a>
<br>

<h2 id="h2-iniciando">2 - Iniciando um Projeto de Exercícios</h2><br>

<p align="justify">É possível utilizar o gerador de projetos para iniciar um projeto de Exercícios nos padrões do framework, para isso basta baixar o jarfile na pasta generator. Após ter baixado o jarfile, execute o programa e siga os passos abaixo:</p>
<br>

<p align="justify">Preencha os campos de acordo com a necessidade do seu projeto</p>

![Preenchimento dos Campos](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/tela_campos.png)

<br>

<p align="justify">Clique em Concluir, e verá que em seguida uma barra de progresso e alguns logs serão exibidos</p>

![Concluir Criação do Projeto](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/clique_concluir.png)

<br>

<p align="justify">Aguarde até a conclusão tal como abaixo, onde verá a mensagem de confirmação</p>

![Conclusão do Projeto Criado](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/confirmacao.png)

<a href="#sumario">Voltar Sumário</a>
<br>

<h2 id="h2-estrutura-projeto">3 - Estrutura do Projeto de Exercícios</h2><br>

<p align="justify">Após ter sido criado, o projeto de exercícios terá a seguinte estrutura:</p>

![Estrutura do Projeto de Exercícios](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/estrutura_projeto.png)

<p align="justify">A seguir faremos um breve comentário sobre cada item importante.</p>

<p align="justify"><b id="b-StartUserAplication">3.1 - Classe StartUserAplication - </b> </b>Dentro do pacote app, essa classe é responsável por iniciar a interface (janela) que permite filtrar e pesquisar os exercícios que criamos, então dentro de StartUserAplication.java existe um método main que basicamente abrirá a seguinte janela:</p>

![Janela de Pesquisa de Exercícios](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/janela_pesquisa.png)

<a href="#sumario">Voltar Sumário</a>

<p align="justify"><b id="b-AloMundoEx">3.2 - Classe AloMundoEx - </b> </b>Dentro do pacote impl.exercicio, existe uma classe chamada AloMundoEx.java. Essa classe representa nosso primeiro exercício, que simplismente herda tudo de ExGeneric, que por sua vez é uma classe genérica no framework para representar os nossos exercícios.</p> 

<p align="justify">Um exercício por padrão terá 3 métodos, tal como vemos abaixo no nosso exercício AloMundoEx: </p>

![Exercício Alo Mundo](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/alo_mundo_ex.png)

<p align="justify">Além disso, notamos a anotação @ExMap na declaração da classe, essa anotação contém o número do exercício e o título do exercício. Agora se juntarmos as peças, podemos usar a tela de pesquisa para encontrar esse exercício pelo título, como segue abaixo:</p>

![Pesquisando Exercício](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/pesquisa_alo_mundo_ex.png)

<a href="#sumario">Voltar Sumário</a>

<p align="justify"><b id="b-UserServiceImpl">3.3 - Classe UserServiceImpl - </b> </b>Agora que já temos uma janela que mostra o exercício alo mundo, fica facil entender a responsabilidade dessa classe  UserServiceImpl. Quando na janela de pesquisas o botão Debugar for clicado, o framework irá recuperar o exercício filtrado na janela, e irá passar uma instância do exercício para o método processar da classe UserServiceImpl. Nesse momento, você terá uma associação entre a facil pesquisa realizada na janela, e o momento onde pode debugar seu exercício. Lembre dos 3 métodos vistos na apresentação do exercício alo mundo anteriormente, verá que são exatamente os mesmos 3 métodos sendo chamados dentro do método processar, e o parâmetro ExGeneric pExGeneric é o seu exercício alo mundo, ou qualquer outro exercício que tenha feito e recuperado na pesquisa.</p>

![Classe recebe os exercícios](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/user_service_impl_metodo_processar.png)

<a href="#sumario">Voltar Sumário</a>

<p align="justify"><b id="b-impl.exercicio">3.4 - Pacote impl.exercicio - </b>Dentro do pacote exercicio, como deve ter percebido é o local onde deverão ser feitos todos os seus exercícios para que o framework possa localizá-los, você até pode se organizar e criar subpacotes dentro do pacote impl.exercicio, pois o framework já está preparado para identificar qualquer exercício começando hierarquicamente do pacote impl.exercicio para baixo, como podemos observar nesse exemplo:</p>

![Onde Criar os Exercícios](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/exemplo_pacote_exercicio.png)

<p align="justify">Recomendamos a divisão em subpacotes dessa maneira, pois facilita a organização dos seus exercícios.</p>

<a href="#sumario">Voltar Sumário</a>
<br>

<h2 id="h2-como-debugar">4 - Debugando Exercícios</h2>

<p align="justify">Para debugar os exercícios localizados na tela de pesquisa, basta clicar em Debugar, será exibida uma mensagem perguntando se foi adicionado um breakpoint no método processar de UserServiceImpl (apresentado no tópico <a href="#b-UserServiceImpl">3.3</a>). Para reforçar veja o método processar abaixo, e adicione um breakpoint na primeira linha com código dentro dele, tal como segue abaixo</p>

![BreakPoint método processar](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/break_point_metodo_processar.png)

<p align="justify">Após isso, basta confirmar a mensagem e verá que o framework conduzirá o debug para esse método processar, passando todos os exercícios encontrados na tela de pesquisa um a um. Podemos ver isso nos prints seguintes:</p>

![Mensagem de Confirmação do BreakPoint](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/confirma_debug.png)

![Debugando Exercício](https://raw.githubusercontent.com/devBino/file_repo/master/fbm_ex_debug/documentos/debugando.png)

<p align="justify">Pronto, agora basta seguir debugando.</p>

<a href="#sumario">Voltar Sumário</a>
<br>

<h2 id="h2-anotacoes">5 - Anotações em um Exercício</h2>

<p align="justify">O framework disponibiliza várias anotações que podemos utilizar em nossos exercícios, tais como @Assunto, @ExMap, @Flags, @Ignore e @Repetir. A seguir veremos um breve resumo de cada uma.</p>

<p align="justify"><b id="b-ann-Assunto">5.1 - @Assunto - </b>Podemos utilizar essa anotação para agrupar exercícios por assunto, por exemplo se estamos estudando sobre interfaces, e temos vários exercícios sobre interfaces, na declaração da classe do nosso exercício podemos adicionar a anotação da seguinte maneira: 
<br> @Assunto("interfaces")<br> 
Então podemos encontrar todos os exercícios por determinado assunto na tela de pesquisa.</p>
<br>

<p align="justify"><b id="b-ann-ExMap">5.2 - @ExMap - </b>Essa anotação é util quando estamos realizando um curso, e criamos um projeto de exercícios para esse curso, assim podemos utilizar @ExMap para anotar os exercícios vinculando a eles um número e título, onde o número pode ser o número da aula, e o título o título dessa aula. Por exemplo: 
<br>@ExMap(numero=11, titulo="Como usar o if ternário")<br>
Dessa forma podemos localizar o exercício pelo título contendo as palavras "if ternário" ou mesmo pelo seu número.
</p>
<br>

<p align="justify"><b id="b-ann-Flags">5.3 - @Flags - </b>Essa anotação é útil quando um exercício pode ser associado a mais de um termo de forma que facilite sua localização, por exemplo se o assunto principal for sobre casting entre tipos primitivos, podemos utilizar o exemplo abaixo: 
<br>@Flags(flags = {"casting","conversao"})<br>
Assim é possível encontrar o exercício informando uma das flags.
</p>
<br>

<p align="justify"><b id="b-ann-Ignore">5.4 - @Ignore - </b>Todo exercício anotado com @Ignore será ignorado e por mais que exista, não será retornado na janela de pesquisas.</p>
<br>

<p align="justify"><b id="b-ann-Repetir">5.5 - @Repetir - </b>Um exercício pode ser repetido uma ou mais vezes. Por exemplo se queremos repetir o exercício 10 vezes podemos usar a anotação da seguinte maneira @Repetir(10)</p>

<a href="#sumario">Voltar Sumário</a>
<br>




