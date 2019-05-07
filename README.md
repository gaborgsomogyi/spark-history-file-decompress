spark-history-file-decompress
============

### Introduction
Spark history server files can be compressed. This application can decompress such files.

### Build the app
To build, you need Java 1.8, git and maven on the box.
Do a git clone of this repo and then run:
```
cd spark-history-file-decompress
mvn clean package
```

### Running the app
```
java -jar target/spark-history-file-decompress-1.0-SNAPSHOT.jar history.lz4 history
```
