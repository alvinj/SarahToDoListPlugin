package com.devdaily.sarah.plugin.todolist

import org.scalatest._

class TimerUtilsTests extends FunSuite with Matchers {

    val add1 = "add make coffee to my to do list"
    val add2 = "and make coffee to my to do list"
    val add3 = "had make coffee to my to do list"
    val add4 = "had make coffee to the to do list"
    val add5 = "add vacuum to the to do list"
    val add6 = "add clean the car and walk the dog to the to do list"

    test("test add phrases") {
        assert(ToDoListUtils.phraseMatchesAddPattern("") == false)
        assert(ToDoListUtils.phraseMatchesAddPattern(add1) == true)
        assert(ToDoListUtils.phraseMatchesAddPattern(add2) == true)
        assert(ToDoListUtils.phraseMatchesAddPattern(add3) == true)
        assert(ToDoListUtils.phraseMatchesAddPattern(add4) == true)
        assert(ToDoListUtils.phraseMatchesAddPattern(add5) == true)
        assert(ToDoListUtils.phraseMatchesAddPattern(add6) == true)
    }
    
    test("test extracting tasks from spoken 'add' phrases") {
        println(ToDoListUtils.getTaskFromSpokenAddPhrase(add1).get)
        assert(ToDoListUtils.getTaskFromSpokenAddPhrase(add1).get == "make coffee")
        assert(ToDoListUtils.getTaskFromSpokenAddPhrase(add2).get == "make coffee")
        assert(ToDoListUtils.getTaskFromSpokenAddPhrase(add3).get == "make coffee")
        assert(ToDoListUtils.getTaskFromSpokenAddPhrase(add4).get == "make coffee")
        assert(ToDoListUtils.getTaskFromSpokenAddPhrase(add5).get == "vacuum")
        assert(ToDoListUtils.getTaskFromSpokenAddPhrase(add6).get == "clean the car and walk the dog")
    }

    val d1 = "delete make coffee from to do list"
    val d2 = "delete make coffee from my to do list"
    val d3 = "remove make coffee from my to do list"
    val d4 = "remove make coffee from the to do list"
    test("test extracting tasks from spoken 'delete make coffee' phrases") {
        assert(ToDoListUtils.getTaskFromSpokenDeletePhrase(d1).get == "make coffee")
        assert(ToDoListUtils.getTaskFromSpokenDeletePhrase(d2).get == "make coffee")
        assert(ToDoListUtils.getTaskFromSpokenDeletePhrase(d3).get == "make coffee")
        assert(ToDoListUtils.getTaskFromSpokenDeletePhrase(d4).get == "make coffee")
    }

    val dv1 = "delete vacuum from to do list"
    val dv2 = "delete vacuum from my to do list"
    val dv3 = "remove vacuum from my to do list"
    val dv4 = "remove vacuum from the to do list"
    val dv5 = "removed vacuum from the to do list"
    test("test extracting tasks from spoken 'delete vacuum' phrases") {
        assert(ToDoListUtils.getTaskFromSpokenDeletePhrase(dv1).get == "vacuum")
        assert(ToDoListUtils.getTaskFromSpokenDeletePhrase(dv2).get == "vacuum")
        assert(ToDoListUtils.getTaskFromSpokenDeletePhrase(dv3).get == "vacuum")
        assert(ToDoListUtils.getTaskFromSpokenDeletePhrase(dv4).get == "vacuum")
        assert(ToDoListUtils.getTaskFromSpokenDeletePhrase(dv5).get == "vacuum")
    }

    test("test matching 'delete' phrases") {
        assert(ToDoListUtils.phraseMatchesDeletePattern(d1) == true)
        assert(ToDoListUtils.phraseMatchesDeletePattern(d2) == true)
        assert(ToDoListUtils.phraseMatchesDeletePattern(d3) == true)
        assert(ToDoListUtils.phraseMatchesDeletePattern(d4) == true)
        assert(ToDoListUtils.phraseMatchesDeletePattern(dv1) == true)
        assert(ToDoListUtils.phraseMatchesDeletePattern(dv2) == true)
        assert(ToDoListUtils.phraseMatchesDeletePattern(dv3) == true)
        assert(ToDoListUtils.phraseMatchesDeletePattern(dv4) == true)
        assert(ToDoListUtils.phraseMatchesDeletePattern(dv5) == true)
    }
    
    val s1 = "show to do list"
    val s2 = "show my to do list"
    val s3 = "show the to do list"
    test("test matching 'show' phrases") {
        assert(ToDoListUtils.phraseMatchesShowPattern(s1) == true)
        assert(ToDoListUtils.phraseMatchesShowPattern(s2) == true)
        assert(ToDoListUtils.phraseMatchesShowPattern(s3) == true)
    }

}












