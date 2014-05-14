package com.devdaily.sarah.plugin.todolist

import com.devdaily.sarah.plugins.SarahPlugin
import com.devdaily.sarah.plugins.PleaseSay
import akka.actor.ActorSystem
import scala.concurrent.{ Await, Future }
import scala.concurrent.ExecutionContext.Implicits.global
import akka.actor.actorRef2Scala
import com.devdaily.sarah.actors.ShowTextWindow

/**
 * Let the user say, "Set timer for ten minutes", "Cancel timer",
 * and similar.
 */
class ToDoListPlugin extends SarahPlugin {

    // database
    TasksDataStore.init

    // used by any Future calls
    implicit val actorSystem = ActorSystem("ToDoListActorSystem")

    import ToDoListUtils._
    
    // tell sarah whether we can handle the given phrase (true) or not (false)
    def handlePhrase(spokenPhrase: String): Boolean = {
        if (phraseMatchesAddPattern(spokenPhrase)) {
            handleAddPhrase(spokenPhrase)
            true
        } else if (phraseMatchesDeletePattern(spokenPhrase)) {
            handleDeletePhrase(spokenPhrase)
            true
        } else if (phraseMatchesShowPattern(spokenPhrase)) {
            handleShowTasksPhrase
            true
        } else {
            false
        }
        true
    }

    def handleAddPhrase(spokenPhrase: String) {
        getTaskFromSpokenAddPhrase(spokenPhrase) match {
            case None =>  
                brain ! PleaseSay("Sorry, I had a problem adding that task.")
            case Some(task) =>
                TasksDataStore.addTask(task)
                brain ! PleaseSay("It has been added.")
        }
    }

    def handleDeletePhrase(spokenPhrase: String) {
        getTaskFromSpokenDeletePhrase(spokenPhrase) match {
            case None =>
                brain ! PleaseSay("Sorry, I had a problem deleting that task.")
            case Some(task) =>
                TasksDataStore.removeTask(task)
                brain ! PleaseSay("It has been removed.")
        }
    }
    
    def handleShowTasksPhrase {
        val tasks = TasksDataStore.getTasks
        var printableTasks = ""
        if (tasks.size > 0) {
            printableTasks = tasks.mkString("\n")
        }
        brain ! PleaseSay("Here you go.")  // added this bc a timing issue wasn't getting focus back into main window
        brain ! ShowTextWindow(printableTasks)
    }

    // nothing to do at startup
    def startPlugin = {}

    override def setPluginDirectory(dir: String) {
        // do nothing 
    }

    // TODO verify - i don't think Sarah uses this any more
    val phrasesICanHandle = List("foo bar")

    // sarah used to call this (may still, but it needs to go away)
    def textPhrasesICanHandle: List[String] = {
        return phrasesICanHandle
    }

}






