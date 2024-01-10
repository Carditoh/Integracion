Feature: Realizacion de casos ingresando nombre de usuario y contraseña

Scenario: Verificacion de ingreso de sesion
Given abrir Chrome
When ingresa Username "Max" y Password "4321"
Then inicia sesion

Scenario: Verificacion de ingreso de sesion
Given abrir Chrome
When ingresa Username "Max" y Password "aaaa"
Then inicia sesion

Scenario: Verificacion de ingreso de sesion
Given abrir Chrome
When ingresa Username "" y Password ""
Then inicia sesion