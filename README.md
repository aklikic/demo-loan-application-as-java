# Loan application DEMO - Java - Event Sourced

## Prerequisite
- Java 11<br>
- Apache Maven 3.6 or higher<br>
- Akka Serverless:
    - Register account: [Login, Register, Register via Google](https://console.akkaserverless.com/p/login)
    - `akkasls` tool installed: [Akka Serverless CLI](https://developer.lightbend.com/docs/akka-serverless/akkasls/install-akkasls.html)
    - `akkasls` login
    -  project `demo` created and set for `akkasls`
- Docker 20.10.8 or higher (engine and client)<br>
- Docker Hub account (configured with Docker)<br>
  Access to the `gcr.io/akkaserverless-public` container registry<br>
  cURL<br>
  IDE / editor<br>

## Generate Java project (terminal)

```
mvn archetype:generate \
  -DarchetypeGroupId=com.akkaserverless \
  -DarchetypeArtifactId=akkaserverless-maven-archetype \
  -DarchetypeVersion=0.10.6
```

```
Define value for property 'groupId': io.as
Define value for property 'artifactId': loan-application
Define value for property 'version' 1.0-SNAPSHOT: :
Define value for property 'package' com.example: : io.as.loanapp
```

## Import in IDE

## Cleanup (IDE)

Delete:<br>
`src/main/proto/io/as/loanapp/counter_api.proto`<br>
`src/main/proto/io/as/loanapp/domain/counter_domain.proto`

## API descriptor - endpoints (IDE)

Note: For code snippet insertion use command+J (MAC)<br>

1. Create file `loan_app_api.proto` in `src/main/proto/io/as/loanapp` folder.<br>
2. Edit `src/main/proto/io/as/loanapp/loan_app_api.proto` in IDE <br>
3. Insert header snippet: `aheader`
4. Insert commands snippet: `acmd`
5. Insert state snippet: `astate`
6. Insert service snippet: `asrv`
7. Add functions to service snippet (place cursor inside brackets `service LoanAppService { }`): `afunc`

## API descriptor - domain (IDE)

1. Create file `loan_app_domain.proto` in `src/main/proto/io/as/loanapp/domain` folder.<br>
2. Edit `src/main/proto/io/as/loanapp/domain/loan_app_domain.proto` in IDE <br>
3. Insert header snippet: `dheader`
4. Insert events snippet: `devts`
5. Insert state snippet: `dstate`

## API descriptor - codegen annotations (IDE)

1. Edit `src/main/proto/io/as/loanapp/loan_app_api.proto`
2. Insert codegen annotations (place cursor under `service LoanAppService {` ): `acodegen`

## Codegen

1. Code generation (terminal):
```
mvn compile
```
2. Refresh project (IDE)
3. Trigger Maven sync (IDE)


## Business logic implementation (IDE)

1. Edit `src/main/java/io/as/loanapp/domain/LoanAppEntity` class
2. Delete class body
3. Insert code snippet (delete everything under constructor): `eall`

## Implement unit test
1. Edit `src/test/java/io/as/loanapp/domain/LoanAppEntityTest` class
2. Delete class body
3. Insert code snippet: `ut`

## Run unit test (terminal)
```
mvn test
```

## Implement integration test (IDE)
1. Edit `src/it/java/io/as/loanapp/LoanAppEntityIntegrationTest` class
2. Delete everything under the constructor
3. Insert code snippet: `it`

## Run integration test (terminal)
```
mvn -Pit verify
```
## Run locally
??

## Package
1. Edit `pom.xml` and update `my-docker-repo` in `<dockerImage>my-docker-repo/${project.artifactId}</dockerImage>`
2. Execute in terminal:
```
mvn package
```
3. Push docker image to repository:
```
mvn docker:push
```

## Deploy to Akka Serverless
1. Deploy project:
```
akkasls service deploy loan-application aklikic/loan-application:1.0-SNAPSHOT
```
Note: replace `aklikic` as in Package
2. Expose service:
```
akkasls services expose loan-application
```
3. List routes:
```
akkasls routes list                 
```
```
NAME           HOSTNAME                                           PATHS             CORS ENABLED   STATUS          
loan-application    fragrant-mud-9702.us-east1.akkaserverless.app   /->loan-application   false          NotConfigured   

```
Note: HOSTNAME is dedicated hostname for this service and is publicly accessible on Internet

## Test service in production
1. Submit loan application
```
curl -XPOST -d '{
  "client_id": "1111",
  "client_monthly_income_cents": 60000,
  "loan_amount_cents": 20000,
  "loan_duration_months": 12
}' https://fragrant-mud-9702.us-east1.akkaserverless.app/loanapp/123456 -H "Content-Type: application/json"
```

2. Get loan application:
```
curl -XGET https://fragrant-mud-9702.us-east1.akkaserverless.app/loanapp/123456 -H "Content-Type: application/json"
```
2. Approve:
```
curl -XPUT https://fragrant-mud-9702.us-east1.akkaserverless.app/loanapp/123456/approve -H "Content-Type: application/json"
```
## Eventing (optional)

1. Create file `loan_app_topic.proto` in `src/main/proto/io/as/loanapp` folder.<br>
2. Edit `src/main/proto/io/as/loanapp/loan_app_topic.proto` in IDE <br>
3. Insert header snippet: `dheader`
4. Insert events snippet: `devts`
5. Insert service snippet: `dsrv`
6. Insert functions snippet (place cursor inside brackets `service LoanAppToTopic { }`): `dfunc`


8. Code generation (terminal):
```
mvn compile
```
9. Refresh project (IDE)
10. Trigger Maven sync (IDE)
11. Edit `src/main/java/io/as/loanapp/LoanAppToTopicAction` class
12. Delete class body
13. Insert code snippet: `tall`


## Copy-paste list
```
mvn archetype:generate \
  -DarchetypeGroupId=com.akkaserverless \
  -DarchetypeArtifactId=akkaserverless-maven-archetype \
  -DarchetypeVersion=0.10.6
```
```
io.as
```
```
loan-application
```
```
io.as.loanapp
```
```
loan_app_api.proto
```
```
loan_app_domain.proto
```
```
mvn compile
```
```
mvn test
```
```
mvn -Pit verify
```
```
mvn package
```
```
mvn docker:push
```
```
akkasls service deploy loan-application aklikic/loan-application:1.0-SNAPSHOT
```
```
curl -XPOST -d '{
  "client_id": "1111",
  "client_monthly_income_cents": 60000,
  "loan_amount_cents": 20000,
  "loan_duration_months": 12
}' https://fragrant-mud-9702.us-east1.akkaserverless.app/loanapp/1234567 -H "Content-Type: application/json"
```
```
curl -XGET https://fragrant-mud-9702.us-east1.akkaserverless.app/loanapp/1234567 -H "Content-Type: application/json"
```
```
curl -XPUT https://fragrant-mud-9702.us-east1.akkaserverless.app/loanapp/1234567/approve -H "Content-Type: application/json"
```
```
loan_app_topic.proto
```
