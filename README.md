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

## 1. Facade 

Providing a single interface for a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.

Classe: FolhaDePagamentoFacade;

## 2. Singleton

Ensure that a class only has a single instance, and provide a global access point to it.

Classes: BancoDeDadosSingleton, CalendarioSingleton

## 3. Template Method

Define the skeleton of an algorithm within an operation, leaving some steps to be filled in by subclasses. Template Method allows its subclasses to redefine certain steps of an algorithm without changing its structure.

Classes: Empregado -> Assalariado, Comissionado, Horista
##

### IDE Utilizada : Jetbrains IntelliJ
