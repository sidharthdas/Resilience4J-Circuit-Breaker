#Reselience4J Configuration

```
//Enable all the endpoints of actuator
management:
  health:
    circuitbreakers:
      enabled: true
  endpoints:
    web:
      exposure:
        include: health
  endpoint:
    health:
      show-details: always

//
resilience4j:
  circuitbreaker:
    instances: // name of the instance i.e. userService
      userService:
        registerHealthIndicator: true
        eventConsumerBufferSize: 10
        failureRateThreshold: 50 // if 50% req is failed change the state to OPEN
        minimumNumberOfCalls: 5
        automaticTransitionFromOpenToHalfOpenEnabled: true
        waitDurationInOpenState: 5s
        permittedNumberOfCallsInHalfOpenState: 3
        slidingWindowSize: 10
        slidingWindowType: COUNT_BASED


```