Loan Calculator
===============

Loan Calculator is a Spring Boot project that I created to play around with various technologies.

Loan Calculator is still a work in progress with more loan support types to come.

**Loan Calculator is NOT Real and will not calculate any loans correctly.**

How to Build
------------
```
mvn clean install
```

How to Run
----------
```
java -jar target/loan-calculator-1.0.0-SNAPSHOT.jar
```

How to Use
----------
I would recommend using [Postman](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en)
 has it will easily allow you to hit the Restful Endpoints.
 
##### There are only two end-points:
*GET - `localhost:8080/loan-calculator`*

*POST - `localhost:8080/loan-calculator`*

Sample Payload:
```json
{
   "numMonths": 5,
   "loanAmount": 500,
   "interest": 10.0,
   "type": "AUTO"
}
```

Future Plans
------------
- Add H2 Layer and Hibernate Integration
- Add Angular 2 and ReactJS Front-ends
- Update to support more complex model relationships
