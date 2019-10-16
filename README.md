# spring-reactor-example
Building non-blocking reactive applications on the JVM.

# Technology stacks used in this example

- Spring boot 2.x

- Spring webflux

- Mongodb 


# Notes

**Blocking vs non-blocking (async) request processing**

- ***Blocking request processing***

  In traditional MVC applications, when a request come to server, a servlet thread is created. It delegates the request to worker threads for I/O operations such as database access etc. During the time worker threads are busy, servlet thread (request thread) remain in waiting status and thus it is blocked. It is also called synchronous request processing.
  
  <p align="center">
    <img src="https://howtodoinjava.com/wp-content/uploads/2019/02/Blocking-request-processing.png" height=80% width=80%/>
  </p>
  
  As server can have some finite number of request threads, it limits the server capability to process that number of requests at maximum server load. It may hamper the performance and limit the full utilization of server capability.
  
- **Non-blocking request processing**

  In non-blocking or asynchronous request processing, no thread is in waiting state. There is generally only one request thread receiving the request.

  All incoming requests come with a event handler and call back information. Request thread delegates the incoming requests to a thread pool (generally small number of threads) which delegate the request to it’s handler function and immediately start processing other incoming requests from request thread.

  When the handler function is complete, one of thread from pool collect the response and pass it to the call back function.
  
  <p align="center">
    <img src="https://howtodoinjava.com/wp-content/uploads/2019/02/Non-blocking-request-processing.png" height=80% width=80%/>
  </p>
  
- **Spring WebFlux** is parallel version of Spring MVC and supports fully non-blocking reactive streams.
  Spring webflux uses project reactor as reactive library. Reactor is a Reactive Streams library and, therefore, all of its operators support non-blocking back pressure. It is developed in close collaboration with Spring.
  
  Spring WebFlux heavily uses two publishers :
  
  - **Mono:** Returns 0 or 1 element.
  
  - **Flux:** Returns 0…N elements. A Flux can be endless, meaning that it can keep emitting elements forever. Also it can return a sequence of elements and then send a completion notification when it has returned all of its elements.
  
**Important note**

To build a truly non-blocking application, we must aim to create/use all of it’s components as non-blocking i.e. client, controller, middle services and even the database. If one of them is blocking the requests, our aim will be defeated.

  
