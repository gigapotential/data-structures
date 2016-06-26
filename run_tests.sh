javac -cp ".:ds:jars/*" TestSLList.java TestDLList.java
java -cp ".:jars/*" org.junit.runner.JUnitCore TestSLList TestDLList
./clean.sh
