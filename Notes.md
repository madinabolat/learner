# Learner App


# Week 3: User Registration & Login (Backend)
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

## 3. AuthController


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



# 4. Tests. CI/CD.

## 1. Test UserService

Mockito allows you to mock objects. When you test something, you don't need to create real objects that the class under test depends on. Instead, you create placeholder objects and tell them what to return when called. This way you isolate what you actually need to test.
any(User.class) — a matcher that means "accept any object of this type." Only works as an argument matcher in when() and verify(), not as a return value.
when(...).thenReturn(...) — stubs a mock to return a specific value when a method is called.
Useful assertions: assertEquals, assertThrows, assertNull, verify.
Setup annotations:

@ExtendWith(MockitoExtension.class) — on the test class, enables Mockito
@Mock — creates a mock object
@InjectMocks — creates a real instance of the class and injects the mocks into it. This is a plain Java object, not a Spring bean.

## 2. Test Controller
TO DO 

## 3. CI CD
CI CD continuous integration continuous deployment

We cant "trust" someone tested on their machine. whenever code is updated in common repo, we want to make sure it passes tests wihtout relying if individuals did tests locally.



In Intellij, when we hit run, behind the scenes:
- javac (compiler): human readable .java -> javac (compiler) turns into .class (bytecode). 
  bytecode is WORA (Write once run anywhere). any mahcine that has JVM can run it. 
- java (JVM): takes .class -> turns into machine code and executes on machine's cpu. here JIT (Just in Time compilation) - turns into machine code and runs real time

if we have pom.xml, then we use a build tool (example: maven, gradle). 
maven is needed to downlaod all libraries, packages, run tests and package everythign into jar file. 
- mvn clean install: takes .java -> builds all libraries, packages -> compiles (instead of javac. mvn handles everythign on its won) -> builds jar file
- java (JVM): runs jar file. 


CI CD in guthub actions: 
- create .github / workflows folder
- create a yaml file, ex: jobs.yml
- add all jobs
on pull_requests
download JDK 
run code 
run maven (builds, tests etc)

github actions - copies the code on a vm (virtual machine), does what we do locally with intellij - downlaods JDK, copies code, runs maven, runs java 
checkout code - means copies code (like git clone)


# Week 4: Frontend

## 1 
TO DO 

## 2 
Thymeleaf vs React:
thymeleaf is server-based. it is build on backend, then browser calls it. 
react is client-based. it is making api calls to backend. fills in dynamically. 

npm is package manager for node. node package manager. 
nvm is version manager. node version manager. 

node is a runtime environment that allows to run javascript in terminal, not in browser. 

React is library. The language is Javascript. 


we did: 
npm create vite@latest frontend -> to build react app
npm run dev -> to run app 


React app: 

node_modules
src > 
  App.jsx
  main.jsx
  ...
index.html
...


index.html - the shell
references main.jsx
main.jsx is like LearnerApplication.java - the main entry point
it calls all the other methods (it mounts the App component into the HTML. It tells React "render App inside the root div.")
here is is App.jsx