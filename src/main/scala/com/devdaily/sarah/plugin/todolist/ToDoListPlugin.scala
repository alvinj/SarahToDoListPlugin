package com.devdaily.sarah.plugin.todolist

import com.devdaily.sarah.plugins.SarahPlugin
import com.devdaily.sarah.plugins.PleaseSay
import akka.actor.ActorSystem
import scala.concurrent.duration._
import akka.actor.actorRef2Scala

/**
 * Let the user say, "Set timer for ten minutes", "Cancel timer",
 * and similar.
 */
class ToDoListPlugin extends SarahPlugin {

    // used by any Future calls
    implicit val actorSystem = ActorSystem("CurrentTimeActorSystem")

    import ToDoListUtils._
    
    // tell sarah whether we can handle the given phrase (true) or not (false)
    def handlePhrase(spokenPhrase: String): Boolean = {
        if (phraseMatchesAddPattern(spokenPhrase)) {
            true
        } else if (phraseMatchesDeletePattern(spokenPhrase)) {
          
            true
        } else if (phraseMatchesShowPattern(spokenPhrase)) {
          
            true
        } else {
            false
        }
//        if (ToDoListUtils.phraseMatchesOurPattern(spokenPhrase)) {
//                val durationOption = ToDoListUtils.getDurationFromSpokenPhrase(spokenPhrase)
//                durationOption match {
//                    case Some(duration) => 
//                        brain ! PleaseSay("foo")
//                        actorSystem.scheduactorSystem.scheduler.scheduleOnceduradurationbraibrainPleaseSay("AlPleaseSay("Alert - This is a timer reminder.")actorSystem.(duration, brain, PleaseSay("Alert - This is a timer reminder."))
//                        true
//                    case None =>
//                        // it matched our pattern, but we couldn't extract the intValue and timeUnit for some reason
//                        brain brain ! PleaseSay("SoPleaseSay("Sorry, the Timer couldn't understand that.")b PleaseSay("Sorry, the Timer couldn't understand that.")
//                        true
//                }
//            } else {
//            false
//        }
        true
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






