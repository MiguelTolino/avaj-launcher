FROM openjdk:11

# Copy the project files to the container
COPY . /usr/src/myapp

# Set the working directory
WORKDIR /usr/src/myapp

# Compile all Java files
RUN javac -d out $(find . -name "*.java")

# Copy the scenario.txt file to the working directory
COPY scenario.txt /usr/src/myapp/scenario.txt

# Set the classpath and specify the main class to run with the scenario.txt file as input
CMD ["java", "-cp", "out", "com.weather_simulation.Simulator", "scenario.txt"]

