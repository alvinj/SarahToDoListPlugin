package com.devdaily.sarah.plugin.todolist

import scala.concurrent.duration._
import java.util.regex.Pattern

object ToDoListUtils {
  
    // add make coffee to my to do list
    // and make coffee to my to do list
    // had make coffee to my to do list
    // had make coffee to the to do list
    //
    // delete make coffee from to do list
    // delete make coffee from my to do list
    //
    // remove make coffee from to do list
    // remove make coffee from my to do list
    //
    // show my to do list
  
    // the first word is usually in (add|and|had), but it doesn't really matter
    val addPattern = "([a-z]+) (.*) to (my|the)* *to do list"
    val compiledAddPattern = Pattern.compile(addPattern)

    // delete pattern
    val deletePattern = "(delete|remove) (.*) from (my|the)* *to do list"
    val compiledDeletePattern = Pattern.compile(deletePattern)
    
    // show pattern
    val showPattern = "show (my|the)* *to do list"
    val compiledShowPattern = Pattern.compile(showPattern)
    
    // 'matches' methods
    def phraseMatchesAddPattern(spokenPhrase: String) = spokenPhrase.trim.toLowerCase.matches(addPattern)
    def phraseMatchesDeletePattern(spokenPhrase: String) = spokenPhrase.trim.toLowerCase.matches(deletePattern)
    def phraseMatchesShowPattern(spokenPhrase: String) = spokenPhrase.trim.toLowerCase.matches(showPattern)
    
    // get the user's task (make coffee) from the complete spoken 'add' phrase
    def getTaskFromSpokenAddPhrase(spokenPhrase: String): Option[String] = {
        val m = compiledAddPattern.matcher(spokenPhrase)
        if (m.find) {
            Some(m.group(2).trim)
        } else {
            None
        }
    }

    // get the user's task (walk the dog) from the complete spoken 'delete' phrase
    def getTaskFromSpokenDeletePhrase(spokenPhrase: String): Option[String] = {
        val m = compiledDeletePattern.matcher(spokenPhrase)
        if (m.find) {
            Some(m.group(2).trim)
        } else {
            None
        }
    }

}














