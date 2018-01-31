/*
Created by: Martin Coronel
*/

package com.example.app

import org.scalatra._

//JSON related libraries
import org.json4s.{DefaultFormats, Formats}

//JSON handling support from Scalatra
import org.scalatra.json._


//ScalarestwebappStack allows to implement 
class MyScalatraServlet extends ScalarestwebappStack with JacksonJsonSupport {

  // Sets up automatic case class to JSON output serialization, required by
  // the JValueResult trait.
  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  // Before every action runs, set the content type to be in JSON format
  before() {
  	println(" ====> Content-Type set to Json <===== ")
  	contentType = formats("json")
  }
  
  var messageMap = new MessageMap() 


  get("/") {
   "This is a simple Web Server to work with messages and JSON "
  }


/*
Lists all messages
*/
  get("/messages") {
	messageMap.map
  }

/*Gets a single message given its ID*/
  get("/message/:Id") {
  	var IdInt = Integer.parseInt(params("Id"))
        println("GET - message Id - arg. passed :: " + IdInt)
	messageMap.get(IdInt)
  }


/*
To create a new message
User provides text of message and id its created automatically
*/
  post("/message/create") {
	var message = parsedBody.extract[Message]
	messageMap.add(message)
  }

/*
To update the message with a new text. we provide the id of the message for this purpose.
*/
  put("/message/:Id") {
	//the ID of the message to be updated
	var IdInt = Integer.parseInt(params("Id"))
	//the new content
	var message = parsedBody.extract[Message]
	messageMap.update(IdInt, message)
  }



/*
To delete a message given an id
*/
  delete("/message/:Id") {
  	var IdInt = Integer.parseInt(params("Id"))
        println("DELETE - message Id - arg. passed :: " + IdInt)
	messageMap.remove(IdInt)
  	messageMap.map
  }
}

