package features.form

Feature: Formulário
  Scenario: Submeter Formulario
    Given que estou na página do formulário
    When eu preencher os campos obrigatórios
    And eu enviar o formulário
    Then o popup de confirmação será exibido

