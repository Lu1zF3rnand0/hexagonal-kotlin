[![Hexagonal Architecture](https://img.shields.io/badge/Architecture-Hexagonal-brightgreen)](https://en.wikipedia.org/wiki/Hexagonal_architecture)
[![Kotlin](https://img.shields.io/badge/Language-Kotlin-orange)](https://kotlinlang.org/)
[![Docker](https://img.shields.io/badge/Environment-Docker-blue)](https://www.docker.com/)

# Exemplo de Projeto Hexagonal com Kotlin

Este é um projeto de exemplo que utiliza a **arquitetura hexagonal** (também conhecida como **arquitetura limpa**) em conjunto com a linguagem Kotlin. 

A arquitetura hexagonal é uma abordagem de design de software que busca separar as preocupações e promover a **modularidade** e **testabilidade** do código. Ela envolve a divisão do sistema em camadas independentes, como a camada de domínio, de aplicação e de infraestrutura, cada uma com suas responsabilidades bem definidas.

## Executando o Projeto

Para executar o projeto, basta utilizar o comando `docker-compose up` no terminal, o que permitirá a criação de um ambiente de execução adequado. Em seguida, você pode iniciar o projeto e testar suas funcionalidades.

```bash
docker-compose up
```

## Testes

Além disso, foram implementados testes tanto de integração quanto unitários para garantir a qualidade e robustez do sistema. Os testes de integração visam verificar o comportamento correto das diferentes camadas da aplicação em conjunto, enquanto os testes unitários são focados em testar unidades individuais de código de forma isolada.

## Referências

Este projeto serve como um exemplo de implementação da arquitetura hexagonal utilizando Kotlin e pode ser usado como referência para o desenvolvimento de aplicações com essa abordagem.
- [Arquitetura Hexagonal](https://en.wikipedia.org/wiki/Hexagonal_architecture)
- [Kotlin](https://kotlinlang.org/)
- [Docker](https://www.docker.com/)

