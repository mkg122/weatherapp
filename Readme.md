## Weather Forecast API with Spring Boot

This Spring Boot application provides a RESTful API for retrieving weather forecast data using the RapidAPI Wetter API ([https://rapidapi.com/wettercom-wettercom-default/api/forecast9 ](https://rapidapi.com/wettercom-wettercom-default/api/forecast9 )).

**Features:**

* API endpoints for accessing weather data:
    * **GET /weather/forecast/summary?city={city_name}**: Retrieves weather summary for a specific city.
    * **GET /weather/forecast/hourly?city={city_name}**: Retrieves hourly weather forecast for a specific city

**Authentication:**

* The API utilizes header-based authentication with a client ID and client secret for each request.

**Requirements:**

* Java 17
* Maven

**Setup:**

1. Clone this repository.
2. Install dependencies: `mvn install`
5. Start the application: `mvn spring-boot:run`

**Usage:**

**Get Weather Summary:**

```
GET http://localhost:8080/weather/forecast/summary?city={city_name}

Headers:
  X-Client-Id: <client_id>
  X-Client-Secret: <client_secrete>

Example Response (JSON):
{
  // ... weather summary data based on API response
}
```

**Get Hourly Forecast:**

```
GET http://localhost:8080/weather/forecast/hourly?city={city_name}

Headers:
  X-Client-Id: <client_id>
  X-Client-Secret: <client_secrete>

Example Response (JSON):
{
  // ... hourly weather data based on API response
}
```

**Note:**

* Replace `<random_client_id>` and `<random_client_secret>` with a valid client ID and secret.
    * example: client_id = 'client1', client_secret = 'clientsecret0123456789'


