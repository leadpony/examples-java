# Example: Switching logback.xml by Maven profile

## Building for development environment
```bash
$ mvn clean
$ mvn package
# Testing jar built
$ java -jar target/logback-example-1.0.0.jar
```

## Building for production environment
```bash
$ mvn clean
$ mvn package -P production
# Testing jar built
$ java -jar target/logback-example-1.0.0.jar
```
