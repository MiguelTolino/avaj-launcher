find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java com.weather_simulation.simulation.Simulator scenario.txt