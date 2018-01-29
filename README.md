### Flight Search Application
This project simulates flight search  by departure time.

### NOTES
* Doesn't contain dependency injection setup/framework.
* Object carries stateless behaviour through out the project.
* SparkJava as REST interface provider -- didnt had much time to decouple SparkJava.

### Requirements
This project requires following software versions or higher in order to compile, package and execute the JAR.

```
JDK 8
maven 2
```

### Example Endpoints
Application exposes port `8080` for REST interface.

```
http://localhost:8080/flight-search/6:00AM
[{
        "carrier": "Air Canada 8099",
        "departure": {
            "hour": 7,
            "minute": 30,
            "second": 0,
            "nano": 0
        }
    },
    {
        "carrier": "United Airline 6115",
        "departure": {
            "hour": 10,
            "minute": 30,
            "second": 0,
            "nano": 0
        }
    }
]
```