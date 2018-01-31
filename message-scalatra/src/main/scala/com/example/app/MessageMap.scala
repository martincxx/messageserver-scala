/*
Created by: Martin Coronel
*/
package com.example.app

import scala.collection._

class MessageMap {

	println("MessageMap - Constructor BEGIN... ")

        var map:Map[Int, Message] = Map()

	init()
/*
For testing purposes, three sample messages are created at the beginning.
*/
	def init() {
		this.add("First Message")
		this.add("Second Message")
		this.add("Third Message")
		}
/*
A set of operations are defined to create(add), select(get), update, delete(remove)
*/
        def add(bodyMessage:String):Int = {
		println("MessageMap - ADD - Invoked")
                var c:Message = new Message(bodyMessage)
		println("New Message created. Id - " + c.id)
                map += (c.id -> c)
                c.id
        }
	
	def add(c:Message):Message = {
		map += (c.id -> c)
		c
	}

        def get(id:Int):Message = {
                map(id)
        }

        def remove(id:Int) = {
                map = map - id
        }

        def update(id:Int, c:Message) {
                map += (id -> c)
        }

        override def toString = s"Map :: ${map}"

	println("MessageMap - Constructor END....")
}
