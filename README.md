# Folha de Pagamento Refatorada

## Código Original: https://github.com/RickMLS1/Folha-de-Pagamento

# Code Smells

### Long Method:

a. The size of the parameter list 

b. You are getting several values from an object and passing these values as parameters in a method call 

c. The amount of switch statement for dispatching and handling request 

d. The amount of switch statement to gather data from numerous classes with different interfaces.

### Large Class: 
Fields and methods

### Shotgun Surgery: 
When every time you make a kind of change, you have to make a lot of Little changes to a lot of different classes

### Feature Envy: 
A method that seems more interested in a class other than the one it actually is in.

### Lazy Class: 
A class that is not doing enough to pay for itself.

### Message Chains: 
Example: object.getE().getD().getC().getB().getA().getValue();
##

# Patterns Used 
##
### 1. Facade

Oferecer uma interface única para um conjunto de interfaces de um subsistema. Facade define uma interface de nível mais elevado que torna o subsistema mais fácil de usar.

* Classe: FolhaDePagamentoFacade 

### 2. Singleton

Garantir que uma classe só tenha uma única instância, e prover um ponto de acesso global a ela.

* Classes: BaseDeDadosSingleton, CalendarioSingleton

### 3. Template Method

Definir o esqueleto de um algoritmo dentro de uma operação, deixando alguns passos a serem preenchidos pelas subclasses. Template Method permite que suas subclasses redefinam certos passos de um algoritmo sem mudar sua estrutura.

* Classes: Empregado -> Assalariado, Comissionado, Horista

##

### IDE Utilizada : Jetbrains IntelliJ
