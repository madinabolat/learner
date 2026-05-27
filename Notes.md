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




React: 
router
make app.jsx a router
then create pages it routes to

react component
react hook

controlled vs uncontrolled component. controlled - the developer controls, uncontrolled - dom (browser) controls. 

react forms - user input. 


useState - returns an array
const [username, setUsername] = useState('') -> means useState creates a variable username with initial value '', then it updates it by running setUsername function
event - the browser creates this object by default

    const handleNameChange = (event) => {
        setUsername(event.target.value);
    }
    <label>
        username
        <input
            type="text"
            value={username}
            onChange={handleNameChange}
        />
    </label>


username variable. 
onChange - calls handleNameChange
handleNameChange - event.target is the input field element (the html box). .value graps the text in that box and setUsername puts that text into the username variable
setUsername updates it, useState creates the username and setUsername at the start
        


Connecting Frontend to Backend
we write calls from frontend to backend in a similar way we did curl, postman. Backend doesnt care who calls, these are all clients - postman, curl, frontend. 

In React: 
we have variables like let name = "madina". 

then functions. useState - runs the component again. then the variable gets updated. 
Hooks are such special functions that use React's inner stuff. 

in browser - Console and Network. Console is like a terminal for our javascript code. 
Network - shows all calls. 

fetch() - can be used to make api calls. 

in browser, it was blocking, we need CORS. cross origin resource sharing. 
backend blocks*(browser blocks - see below) - we dont want anyone be able to use our API endpoints. so we can add what localhost we allow - this shows this localhost is allowed to make an api call to thsi endpoint. but this is ok in dev - later we will add our domain so that these api endpoints can only be called from there. 
we dont want to allow just everyone because other website might be calling it. 

we can add specific cors allow to specific methods too. added a cors config - allowing everyone while in development:         registry.addMapping("/**");

*"backend blocks" — it's actually the browser that blocks, not the backend. The backend processed the request fine (200 OK). The browser saw the response didn't have CORS headers and refused to let your JavaScript read it. The CORS config you added tells the backend to include those headers so the browser allows it.



# Week 5
Frontend
UseState - you can save errors from backend through useState.
setError(...) stores whatever you pass into it - like text from the backend response.
to display it on page just put {error} in JSX.
.then(...)
.then(...)
each then is getting input from previous. this is called a Promise chain.
promise - means the result isn't ready yet, run this when it is. response.text() returns a promise so you do response.text().then(text => setError(text))
fetch() - javascript version of curl. makes HTTP requests from the browser.
every new page need to add to routes in App.jsx
Backend
Bean Validation - @NotBlank, @Length on DTO fields. @Valid on controller parameter triggers the check.
BindingResult - catches validation errors inside the controller method. if you remove it, Spring throws MethodArgumentNotValidException instead.
ControllerAdvice + ExceptionHandler
instead of handling exceptions in every controller, can add global exception handler to handle at once.
you can remove try catch from individual parts and global exception handler can handle it for you.
can create custom exceptions (like UserAlreadyExistsException) so the handler knows exactly what happened.
MethodArgumentNotValidException - what Spring throws when @Valid fails and there's no BindingResult.



# Week 6
constructor in controller - need this so Spring knows to pass in the ChatService bean. without it chatService is null and you get NullPointerException.
service interface, then class that implements it.
interface has methods public by default - because interface is a contract, methods need to be accessible.
class implements and says public explicitly on methods.
add @Service to the impl class - that way spring will know it is a bean and will create the object. since only one implementation, Spring auto picks it. if two, need @Qualifier.
@RequestBody ChatRequestDto - tells Spring take incoming JSON and turn it into a Java object.
send json {"request": "hello"} - Spring creates ChatRequestDto, calls setRequest("hello"). key name must match field name. that's why DTOs need getters and setters.
curl -H 'Content-Type: application/json' \
  -d '{"request": "hello"}' \
  -X POST \
  localhost:8080/api/chat
return ResponseEntity.status(HttpStatus.OK).body(response);
ResponseEntity is like an envelope. status code on the outside, response string inside.
body(response) - this is what is being returned to frontend.