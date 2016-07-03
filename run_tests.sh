javac -cp ".:ds:jars/*" TestSLList.java TestDLList.java TestMaxHeap.java
java -cp ".:jars/*" org.junit.runner.JUnitCore TestSLList TestDLList TestMaxHeap
./clean.sh
