# US 2002

## 1. Requirements

> **US 2001** - As Product Owner, I want the system to, continuously, process the files produced by the Applications Email Bot, so that they can be imported into the system by initiative of the Operator

Há um segundo bot, chamado Applications File Bot, que processa essas candidaturas para integração no sistema.

O "Applications File Bot" está monitorando continuamente para que novas candidaturas sejam processadas. O Bot deve copiar os ficheiros para uma pasta compartilhada. Essa pasta compartilhada deve ser organizada por referência de trabalho (pastas superiores) e, em seguida, por candidatura (subpasta dentro da pasta de referência de trabalho). O Bot deve produzir um relatório de texto de todos as candidaturas processadas (incluindo candidaturas as referências de trabalho e ficheiros disponíveis).

O "Applications File Bot" deve ser desenvolvido em C e utilizar processos, sinais, pipes e primitivas de funções exec.

Um processo filho deve ser criado para monitorar periodicamente um diretório de entrada para novos arquivos relacionados à fase 'Application' do processo de recrutamento. Se novos arquivos forem detectados, um sinal deve ser enviado ao processo pai

Ao receber um sinal, o processo pai deve distribuir os novos arquivos entre um número fixo de processos filhos trabalhadores. Cada processo filho será responsável por copiar todos os arquivos relacionados a um candidato específico para seu subdiretório designado no diretório de saída

Uma vez que uma criança tenha terminado de copiar todos os arquivos para um candidato, ela deve informar seu pai que está pronta para executar trabalho adicional. Os trabalhadores filhos não terminam a menos que sejam especificamente encerrados pelo processo pai.

Depois que todos os arquivos de todos os candidatos tiverem sido copiados, o processo pai deve gerar um arquivo de relatório no diretório de saída. Esse relatório deve listar, para cada candidato, o nome do subdiretório de saída e os nomes de todos os arquivos que foram copiados

Para encerrar o aplicativo, o processo pai deve manipular o sinal SIGINT. Após a recepção, deve terminar todas as crianças e aguardar o seu término

Os nomes dos diretórios de entrada e saída, o número de filhos trabalhadores, o intervalo de tempo para verificação periódica de novos arquivos, etc., devem ser configuráveis. Essa configuração pode ser obtida por meio de parâmetros de entrada fornecidos durante a execução do aplicativo ou pela leitura de um arquivo de configuração. Vamos optar por um ficheiro de configuração.

---

## 2. Affected Use Cases

| USE CASE | DESCRIPTION                         |               DOCUMENT               |
|:--------:|-------------------------------------|:------------------------------------:|
|   UC13   | Register application of a candidate | [README.md](../../uc/uc13/README.md) |

## 3. US Implementation

- *to do*


### Unit Tests

- *to do*