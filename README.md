# avaj-launcher 🚀

This project, avaj-launcher, serves as an introduction to the Java world at 42. It simulates an aircraft control tower 🏰, managing various types of aircraft 🛩️ through changing weather conditions ☁️.

## Overview 📖

The simulation is built around a simple concept: aircrafts are created using a factory pattern 🏭, and they interact with a weather tower 🌦️ to respond to changing weather conditions. The simulation runs through a predefined number of cycles, reading scenarios from a file 📄 and outputting the simulation results to another file 📁.

## Features 🌟

- Aircraft simulation with different types of aircraft (Balloon 🎈, Helicopter 🚁, JetPlane ✈️).
- Weather changes that affect the behavior of the aircraft 🌩️.
- A weather tower that notifies aircraft about weather changes 📡.
- Simulation results are written to a file named `simulation.txt` 📝.

## Project Structure 🏗️

```
.
├── Dockerfile 🐳
├── README.md 📚
├── error_files/ ❌
├── run.sh 🖥️
├── scenario.txt 📖
├── sources.txt 📋
└── src/
    └── com/
        └── weather_simulation/
            ├── aircraft/
            │   ├── Aircraft.java ✈️
            │   ├── AircraftFactory.java 🏭
            │   ├── Baloon.java 🎈
            │   ├── Flyable.java 🛫
            │   ├── Helicopter.java 🚁
            │   └── JetPlane.java ✈️
            ├── simulation/
            │   ├── Tower.java 🏰
            │   ├── WeatherProvider.java ☁️
            │   └── WeatherTower.java 🌦️
            ├── Simulator.java 🎮
            └── utilities/
                └── Coordinates.java 🌐
```

## How to Run 🏃‍♂️

1. **Build the project** 🛠️: Run the `run.sh` script to compile the Java files and prepare the simulation.
    ```sh
    ./run.sh <scenario_file>
    ```
2. **Run the simulation** 🚀: The `run.sh` script will automatically start the simulation after building the project.
3. **View the results** 📊: Check the `simulation.txt` file for the output of the simulation.

## Docker Support 🐳

This project includes a `Dockerfile` for building and running the simulation in a Docker container.

To build the Docker image:
```sh
docker build -t avaj-launcher .
```

To run the simulation using Docker:
```sh
docker run --rm avaj-launcher
```

## Contributing 🤝

Contributions are welcome! Please feel free to submit a pull request.

## License 📝

This project is licensed under the MIT License - see the LICENSE file for details.
