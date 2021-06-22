# language: pt
# encoding: iso-8859-1

@geral
Funcionalidade: Validar teste PJ e PF

  @pf
  Esquema do Cenario: Teste PF
    Dado efetuei login no sistema
    E acessei o menu Clientes >> Inserir
    Quando na tela Dados de Identificacao informo os dados de Pessoa Fisica: "<name>","<email>","<data_nascimento>","<sexo>" e "<estado_civil>"  
    E na tela Dados de Identificacao clico em Avancar
    E na tela Enderecos informo os enderecos
    E na tela Enderecos clico em Salvar
    Entao validar alerta na tela Enderecos

    Exemplos: 
      | name                    | email                     | data_nascimento | sexo      | estado_civil |
      | Automação fora da Caixa | automacao@foradacaixa.com | 10/10/1991      | Masculino | Solteiro     |
      | Automação fora da Caixa | automacao@foradacaixa.com | 10/10/1991      | Masculino | Solteiro     |
      
      
  @pj
  Esquema do Cenario: Teste PJ
    Dado efetuei login no sistema
    E acessei o menu Clientes >> Inserir
    Quando na tela Dados de Identificacao informo os dados de Pessoa Juridica: "<razao_social>","<email>"
    E na tela Dados de Identificacao clico em Avancar
    E na tela Enderecos informo os enderecos
    E na tela Enderecos clico em Salvar
    Entao validar alerta na tela Enderecos

    Exemplos: 
      | razao_social            | email                     |
      | Automação fora da Caixa | automacao@foradacaixa.com |
      | Automação fora da Caixa | automacao@foradacaixa.com |