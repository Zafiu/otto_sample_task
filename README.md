## otto sample task
### Setup with Docker
1. ./gradle build
2. docker build -t otto_sample_task_zafar .
3. docker run -d --name otto_sample_task_zafar -p 8080:8080 otto_sample_task_zafar

### Example Usage
http://127.0.0.1:8080/region?region=ca

### Acceptance Criteria:
A Spring Boot Application is created 
- The application has a REST controller and lists the expected data  
- The datasource is public and readable from here: https://ip-ranges.amazonaws.com/ip-ranges.json  
- The REST controller takes URL query parameter like "?region=EU" or "?region=US" or "?region=ALL" to filter the data (valid regions are EU, US, AP, CN, SA, AF, CA)  
- The data is presented as MIME type text/plain  
- Each value is shown as single line in the output  
- The data (from AWS ip-ranges.json) is not stored  
- The code should be stored in github
- github users Mowee, stdogr and rebekka-s should have read access to the code  

### *Hints / Remarks:*
- Remember to write unit tests for the application.
There is no expectation of creating a security group in AWS and use the data.

- A pipeline in github actions is not requested but would be plus.
- Putting the app into a docker container is not requested but would be plus. 