Feature: Realizar una compra en saucedemo

  Scenario Outline: Agregar al carrito y realizar la compra
    Given un usuario se ingresó a la página de login
    When ingresa sus credenciales válidas: usuario "standard_user" y contraseña "secret_sauce"
    And agrega los productos "<product1>" y "<product2>" al carrito
    And realiza la compra con información "<first_name>", "<last_name>", "<postal_code>" y un total "<price_total>"
    Then debería ver el mensaje de confirmación de pedido "THANK YOU FOR YOUR ORDER"

    Examples:
      | product1                         | product2                   | first_name | last_name | postal_code | price_total  |
      | Sauce Labs Onesie                | Sauce Labs Fleece Jacket   | Carlos     | Brown     | 11223       | $62.62       |
