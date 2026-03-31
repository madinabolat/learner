# Learner App


# 3: User Registration & Login (Backend)
## 1. Beans
IoC (Inversion of Control) container is a container that manages object creation for us. Instead of manually creating objects with new keyword, we can create beans (objects) that are stored in IoC container and can be used later.  
DI (Dependency Injection) is a way to implement IoC. 

- For classes that we wrote ourselves: we use @Component annotation. 
- For methods that return objects of classes that we import: we use @Bean annotation. it should be in a class annotated with @Configuration.

At startup, Spring creates all the beans for us and stores in IoC container. 


## 2. UserService, Repository. 
@Service is similar to @Component when creating beans
You can use objects from IoC (previously created using @Bean or @Component or other bean ways) through constructor. 
When you have a class and you use previous bean, you add it to constructor. that way when you create an instance of this class - spring injects it for you wihtout you explicitly creating it. but you need to make this class a bean too otherwise you would need to pass this object, but if this class is a bean - spring does this class automatically for you so injects. 

Lombok for writing succinctly - getters, setters can just do @Getter, @Setter. 

DTO - data transfer object. 
Transfers data from controller to service instead of using the actual object. Service will further save it to repo. 


Repository: 
It is a layer that does actions to DB. 
In Java JPA - there is a built in method findBy... - you can add a custom field and JPA will perform queries. For example, findByUsername. 

@Service, @Repository ... - are all beans. Specified types of beans. 

Repository extends JPA Repository and we declare there what Entity it is connected to. 
extends JpaRepository<User, Long> 
so, this repo is connected to User entity (and primary key is of type Long). 
we can save to repository. 


Exceptions: checked vs unchecked. 
Unchecked - throw, but dont need to catch (can still catch if you want). 
Checked - throw, then must catch somewhere. 
IllegalArgumentException is Unchecked. 

# 3. AuthController


CURL Command: 

curl -H 'Content-Type: application/json' \
      -d '{ "username":"madina1","password":"pass"}' \
      -X POST \
      localhost:8080/api/auth/register

H -> header
d -> data
X -> type of http request (GET, POST, PUT, DELETE)

Controller is a layer that takes http requests from users and calls corresponding methods from service then sends back http response. 

@Controller
@RestController
REST API
REST - set of conventions for http methods. it returns response as JSON instead of html. RestController is a controller that performs REST apis. 

to controller - we are injecting UserService interface. Spring will know to use the bean for UserServiceImpl because this implemetns the interface. 
if there were two classes that implement this interface, then there will be error. We should do @Qualifier in this case. 

      curl -H 'Content-Type: application/json' \
      -d '{ "username":"madina","password":"pass2"}' \
      -X POST \
      localhost:8080/api/auth/login