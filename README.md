Olá mundo! Este é o meu primeiro de muitos repositórios em Kotlin. Estou gradualmente evoluindo na linguagem e me encaminhando para me tornar um exímio programador de Kotlin.

#  O Problema:
  
Estava com um projeto de criar uma rádio que tocasse a mesma playlist de músicas todos os dias, garantindo que a mesma música tocasse no mesmo horário todos os dias. Inicialmente, comecei utilizando o aplicativo StationHead. Ele só precisa que você tenha uma conta no Spotify para transmitir as músicas e para que os ouvintes possam ouvi-las também. No entanto, surgiu o primeiro problema: o aplicativo só permite adicionar até 100 faixas na fila de reprodução. Para uma transmissão de mais de 12 horas, isso não é suficiente (acredito que não seja um problema do StationHead, mas sim da API do Spotify, que retorna no máximo 100 faixas. Aprendi isso testando). O segundo problema é que meu computador e minha internet estão sujeitos a imprevistos, como desligamento, queda de rede ou fechamento acidental da página. Toda vez que isso acontecia, eu precisava somar as durações das músicas, descobrir qual música deveria estar tocando e quando a próxima começaria. Eu colocava um despertador para o horário da próxima música e iniciava a rádio assim que o despertador tocava. Depois de fazer isso pela quinta vez, eu simplesmente não aguentava mais. Foi aí que surgiu a ideia de programar para resolver o problema.


#  Solução:

1. Criar uma calculadora de tempo.
2. Criar um JSON para testar a calculadora.
3. Copiar o JSON da API do Spotify.
4. Implementar a calculadora adaptando-se ao novo JSON.
5. Conectar à API:
    1. Como conectar à API (primeira vez).
	  2. Como adicionar o autenticador.
	  3. Como tratar o JSON da resposta.
	  4. Como transformar o JSON em uma lista de objetos.
7. Unir a calculadora e a API.
8. Melhorar o código.

#  Conclusão:

Foi uma longa jornada, mas consegui resolver o problema, aplicando meus conhecimentos na prática e aprendendo muitas coisas novas no processo. Ser um bom programador é buscar conhecimento, investigar novas soluções, fazer testes, criar soluções criativas e sempre buscar melhorar. Isso é o que este projeto me ensinou.


**Lembrar**
	alterar o clientSecret para um válido, acesse [spotify para desenvolvedor](https://developer.spotify.com)
