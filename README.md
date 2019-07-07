  O projeto feito para a Lancheria Daniela foi feito em Java utilizando Spring boot. Este é um projeto novo com tecnologias exploradas
pela primeira vez pelo desenvolvedor, no qual você pode incluir um novo pedido no banco de dados e lista-los. Futuramente será capaz de 
designar o cozinheiro certo para um lanche específico e ser enviado para motoboy, se necessário, à partir do local de entrega solicitado.

  Nesta aplicação está implementado o método post, o qual inclui um novo pedido feito por um cliente, onde contém uma comanda com quais
itens foram pedidos e suas quantidades, o local de entrega e o nome do cliente. Implementarei um método para ver se o pedido precisa de 
entrega ou não à partir do local de entrega solicitado e um método para enviar para a fila do cozinheiro correto de acordo com o lanche
pedido, caso seja feito o pedido de Cachorro Quente, será encaminhado para a fila do ajudante e não do cozinheiro principal que ficará 
responsável por todos outros lanches.

  Implementamos também o método get, que fica responsável por listar todos os pedidos registrados no banco, que no futuro terá um 
  filtro por nome de cliente para ver um histórico de compras de um determinado cliente e não tenha que ficar procurando em meio aos
  demais.
  
  O projeto possui os packages:
  -Controller, onde ficam implementados os métodos GET, que lista todos os pedidos como uma lista, e Post, responsável pela inclusão de 
  um novo pedido.
  
  -Dto, onde possuímos itemPedidoDto que possui quantidade e id do item pedido pelo cliente. PedidoInputDto responsável por enviar ao 
  banco as informações de itens pedidos (comanda), entrega e nome do cliente. PedidoOutputDto, responsável por retornar somante as 
  informações necessárias do banco.
  
  -Entity possui Cliente com seu nome, endereço e telefone caso necessário entrega. Comanda, que o que foi pedido pelo cliente e suas
  quantidades. Item possui um nome, um valor, e a entidade Pedido contém uma comanda com todos os itens pedidos, a origem do pedido, se 
  feito de algum lugar ou do próprio estabelecimento e um cliente.
  Falta incluir a entidade cozinheiro e uma entidade Entregas para a fila do motoboy.
  
  -Mapper possui comandaMapper e pedidoMapper, responsáveis pela "conversão" de pedido para pedidoInputDto, pedidoOutputDto, lista de itens,
  entre outras.
  
  -Repository possui cliente, comanda, item e pedidoRepository, os quais extendem o CRUD.
  
  -Service possui Cliente, que realiza uma busca por um determinado cliente e seus pedidos. Comanda que busca por pedido, Item que busca por
  ID e PedidoService que salva pedido em comanda, lista todos os pedidos e salva em respotiróio.
  
  -Swagger ficou responsável por documentação.
