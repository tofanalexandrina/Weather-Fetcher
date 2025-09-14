# WeatherFetcher

A simple Java console application that fetches current weather information for any city using the [WeatherAPI](https://www.weatherapi.com/) service.

## Features
- User can type the name of a city in the console.
- Fetches weather data via HTTP request.
- Parses JSON response into Java objects using Jackson.
- Prints key weather details:
  - City and Country
  - Temperature (°C)
  - Condition (Clear, Sunny, Rainy, etc.)
- Loop allows checking multiple cities without restarting the program.

