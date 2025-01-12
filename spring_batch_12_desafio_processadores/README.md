O banco XPTO solicitou a criação de uma rotina batch para gerar contas bancárias para clientes cadastrados no sistema. Os clientes são lidos de um banco de dados no seguinte formato:

| Field          | Type        | Null | Key | Default | Extra |
| -------------- | ----------- | ---- | --- | ------- | ----- |
| nome           | text        | YES  |     | NULL    |       |
| idade          | int         | YES  |     | NULL    |       |
| email          | varchar(50) | NO   | PRI | NULL    |       |
| faixa_salarial | double      | YES  |     | NULL    |       |

Baseado na faixa salarial, as contas serão criadas da seguinte forma:
- Até 3000: Conta tipo PRATA
- 3001 à 5000: Conta tipo OURO
- 5001 à 10000: Conta tipo PLATINA
- > 10000: Conta tipo DIAMANTE

Cada conta possuirá um limite diferente dependendo do seu tipo:
- PRATA: Limite R$ 500,00
- OURO: Limite R$ 1000,00
- PLATINA: Limite R$ 2500,00
- DIAMANTE: Limite R$ 5000,00

A conta possui a seguinte estrutura:

| Field      | Type                                         | Null | Key | Default | Extra          |
| ---------- | -------------------------------------------- | ---- | --- | ------- | -------------- |
| id         | int                                          | NO   | PRI | NULL    | auto_increment |
| tipo       | enum('PRATA', 'OURO', 'PLATINA', 'DIAMANTE') | YES  |     | NULL    |                |
| limite     | double                                       | YES  |     | NULL    |                |
| cliente_id | text                                         | YES  |     | NULL    |                |

Em anexo, estão os scripts para criação dessas tabelas e inserção dos clientes do banco. Execute os scripts num banco de dados chamado XPTO para prosseguir.

Perguntas dessa tarefa
Implemente um Job chamado ContasBancariasJob para criar as contas bancárias de cada cliente com base nas regras descritas. A criação de contas será simulada com a impressão das contas geradas no escritor do Job. Informe aqui os códigos relativos ao processador Spring Batch.

Você utilizou alguma implementação de processador do Spring Batch? Explique a sua escolha de implementação.