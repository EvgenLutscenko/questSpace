# JSP/JSTL Tutorial Project Quest

## Technologies:
- **IntelliJ IDEA**
- **Maven**
- **Java version 18.0.1**
- **Tomcat 10.1.12**
- **JSP**
- **JSTL**
- **HTML**
- **CSS**
- **Bootstrap**
- **JUnit 5**

## Deployment Instructions:
- Leave `/` in the Deployment section -> Application context.
- In the Server section -> URL, use `http://localhost:8080/`.

## Project Structure:
- The `WEB-INF` directory stores a properties file, which contains links to each of the JSON configuration files: `src/main/webapp/WEB-INF/jsonStor/json.properties`.
- JSON files are packed into resources. The files include:
  - `condition.json`: Stores the game condition.
  - `questions.json`: Stores questions.
  - `quits.json`: Stores exits from the game (win, loss).

## JSON File Structure:
JSON files are structured as follows:
```json
{
  "condition": "condition",
  "questions": [
    "question 1",
    "question 2"
  ],
  "answers": [
    "int - number of the question to which the answer to 'question 1' leads",
    "int - number of the question to which the answer to 'question 2' leads"
  ],
  "number": "int - question number"
}
```
## Installation:

### Install Dependencies:

```bashbash
npm install
```

```bash
npm run start
```