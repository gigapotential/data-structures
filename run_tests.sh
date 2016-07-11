javac -cp ".:ds:jars/*" TestSLList.java TestDLList.java TestMaxHeap.java TestMedianOfStream.java TestBST.java
java -cp ".:jars/*" org.junit.runner.JUnitCore TestSLList TestDLList TestMaxHeap TestMedianOfStream TestBST
./clean.sh
