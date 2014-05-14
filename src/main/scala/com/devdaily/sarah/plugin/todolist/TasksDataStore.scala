package com.devdaily.sarah.plugin.todolist

import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import java.io.{File, BufferedWriter, FileWriter}

object TasksDataStore {

    val SLASH = System.getProperty("file.separator")
    val DB_DIR = "/var/tmp"
    val DB_FILE = DB_DIR + SLASH + "SarahToDoList.db"
    val records = new ArrayBuffer[String]()

    /**
     * Creates the database directory if it does not already exist.
     */
    def init {
        val dir = new File(DB_DIR)
        if (!dir.exists) {
            val successful = dir.mkdirs
            if (!successful) {
                // TODO use a logger instead of this
            }
        }
    }
  
    def getTasks(): List[String] = {
        if ((new File(DB_FILE).exists())) {
            val urlsFromFile = for (line <- Source.fromFile(DB_FILE).getLines()) yield line
            records.clear
            records.appendAll(urlsFromFile)
            records.toList
        } else {
            Nil
        }
    }

    def addTask(task: String) {
        records += task
        saveTasks
    }

    def removeTask(task: String) {
        records -= task
        saveTasks
    }

    // save the urls (in sorted order)
    private def saveTasks {
        val file = new File(DB_FILE) 
        val bw = new BufferedWriter(new FileWriter(file))
        for (url <- records.sorted) bw.write(s"$url\n")
        bw.close
    }

}







