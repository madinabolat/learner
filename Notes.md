# Learner App


# 3: User Registration & Login (Backend)
## 1. Beans
IoC (Inversion of Control) container is a container that manages object creation for us. Instead of manually creating objects with new keyword, we can create beans (objects) that are stored in IoC container and can be used later.  
DI (Dependency Injection) is a way to implement IoC. 

- For classes that we wrote ourselves: we use @Component annotation. 
- For methods that return objects of classes that we import: we use @Bean annotation. it should be in a class annotated with @Configuration.

At startup, Spring creates all the beans for us and stores in IoC container. 





    UserService interface
    UserServiceImpl class


registerUser(UserRegistrationDto userData):
findByUsername(String username):

