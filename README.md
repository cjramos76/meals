# meals
Test project meals

Criei um projeto maven para o teste.

Para compilar vai na pasta do projeto e compila com mvn clean compile

Para executar mvn exec:java -Dexec.args="${COMANDO}", por exemplo: mvn exec:java -Dexec.args="night,1,2,3"

Os pacotes da aplicação começam em com.gft.test.meals.

Classes:
  com.gft.test.meals.Meal: classe java com método main para executar a aplicação.
  com.gft.test.meals.controller.MealController
  com.gft.test.meals.controller.impl.MealControllerImpl (implements MealController): recebe os parámetros de entrada, verifica que são corretos e chama para fazer o pedido.
  com.gft.test.meals.service.ValidateInputService
  com.gft.test.meals.service.impl.ValidateInputServiceImpl (implements ValidateInputService): recebe os parámetros de entrada e verifica que sejam corretos
  com.gft.test.meals.service.FoodService
  com.gft.test.meals.service.impl.FoodServiceImpl (implements FoodService): executa o pedido de acordo as regras especificadas
  com.gft.test.meals.model.MealType: enum com os tipos de comida: night e morning
  com.gft.test.meals.model.MorningMeal: enum com as comidas da manha
  com.gft.test.meals.model.NightMeal: enum com as comidas da noite
  
