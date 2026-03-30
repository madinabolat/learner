# Learner App


# 3: User Registration & Login (Backend)
## 1. Beans
IoC (Inversion of Control) container is a container that manages object creation for us. Instead of manually creating objects with new keyword, we can create beans (objects) that are stored in IoC container and can be used later.  
DI (Dependency Injection) is a way to implement IoC. 

- For classes that we wrote ourselves: we use @Component annotation. 
- For methods that return objects of classes that we import: we use @Bean annotation. it should be in a class annotated with @Configuration.

At startup, Spring creates all the beans for us and stores in IoC container. 


## 2. 
@Service is similar to @Component when creating beans
You can use objects from IoC (previously created using @Bean or @Component or other bean ways) through constructor. 
When you have a class and you use previous bean, you add it to constructor. that way when you create an instance of this class - spring injects it for you wihtout you explicitly creating it. but you need to make this class a bean too otherwise you would need to pass this object, but if this class is a bean - spring does this class automatically for you so injects. 

Lombok for writing succinctly - getters, setters can just do @Getter, @Setter. 

DTO - data transfer object. 
Transfers data from controller to service instead of using the actual object. Service will further save it to repo. 