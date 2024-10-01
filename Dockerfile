FROM openjdk:11

# Copy the project files to the container
COPY . /usr/src/myapp

# Set the working directory
WORKDIR /usr/src/myapp

# Set the classpath and specify the main class to run with the scenario.txt file as input
CMD ["/bin/sh", "run.sh", "scenario.txt"]

