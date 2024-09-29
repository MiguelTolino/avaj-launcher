find . -name "*.java" > sources.txt
javac -d out -sourcepath . @sources.txt
cp scenario.txt out
java -cp out Simulator scenario.txt