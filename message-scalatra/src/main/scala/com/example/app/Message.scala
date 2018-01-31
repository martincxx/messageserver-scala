/*
Created by: Martin Coronel
*/
package com.example.app

//JSON related libraries
import org.json4s.{DefaultFormats, Formats}

//JSON handling support from Scalatra
import org.scalatra.json._

// JSON library for converting the POJO toString as Json
import org.json4s.native.Json


/*
Message class
*/
class Message(val id:Int, var bodyMessage:String) {                                   
                                                                                              
        println("Message - Constructor  BEGIN .... ")

	def this(bodyMessage:String) {
		this(Message.inc, bodyMessage)
	}
                                                                                              
        //override def toString = s"Message [Id=$id, bodyMessage=$bodyMessage]"
		//just to check on console

	override def toString = Json(DefaultFormats).write(this) 

	println("Message - Constructor END .... ")
}                                                                                             

/*
To assign auto incremental values for id
*/
object Message {                                                                             
	private var id = 0                                                                    
                                                                                              
        private def inc = {   
	       println(" ****** Inc method called, id = " + id)
       	        id += 1;                                                                      
               	id                                                                            
        }                                                                                     
}                                                                                              
