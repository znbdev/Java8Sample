Java8 Sample
-----

# How to run

### Build code

##### Gradle build

```bash
cd [target repository dir]
./gradlew clean build --refresh-dependencies --stacktrace
```

# H2 DB

## Run H2 DB

`java -jar h2-2.2.224.jar`
`java -jar h2-2.2.224.jar -tcp -tcpAllowOthers -baseDir /Users/znb/workspace/Java8Sample/H2/demo_db`

[Login](http://localhost:8082/login.jsp)

### jdbc:h2:file:/absolute/path/to/data/your_db_name

- JDBC URL: jdbc:h2:file:/absolute/path/to/H2/demo_db;MODE=MySQL
- User Name: sa
- Password: (leave empty)