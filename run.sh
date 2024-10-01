#!/bin/bash

# Check if the scenario file is provided as an argument
if [ -z "$1" ]; then
	echo "Usage: $0 <scenario_file>"
	exit 1
fi

SCENARIO_FILE=$1

find . -name "*.java" > sources.txt
javac -d out -sourcepath . @sources.txt
cp "$SCENARIO_FILE" out
java -cp out Simulator "$SCENARIO_FILE"
cat simulation.txt
