JSP/JSTL tutorial project Quest

Technologies:
     JDK-19
     Jakarta Expression Language API » 5.0.0
     Project Lombok 1.18.30
     tomcat 10

     
leave / in Deployment -> Application context
In Server -> URL leave http://localhost:8080/

WEB-INF stores a properties file, which contains links to each of the json configuration files -> src/main/webapp/WEB-INF/jsonStor/json.properties
Json files are packed into resources - this is a file
condition.json – storing the greeting
questions.json – storing questions
quits.json – storing exits from the game (win, loss)

questions and outputs are written to objects
{
  "condition": "условие"
  "questions": [
    "question 1"
    "question 2"
  ],
  "answers": [
    int- number of the question to which the answer to “question 1” leads,
    int- number of the question to which the answer to “question 2” leads,
  ],
  "number": int- question number
}
It is advisable to configure json files in the form of a tree, I made the tree going to the root node in order - (left - right)
						          1
			             /	|  \
				          5   4   2
				        /			      \
				       6				      3
			       /  \
            9    7
			    /		    \
		    10         8

(This is an example)
The main thing is to ask 1 question with number 1 (no lower, no more)

