Sarah 'To-Do List' Plugin
=========================

This is a new "To-Do List" plugin for Sarah (v2).
It can handle phrases like these:

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


Files
-----

The jar file built by this project needs to be copied to the Sarah plugins directory.
On my computer that directory is _/Users/al/Sarah/plugins/DDToDoList_.

Files in that directory should be:

    ToDoList.info
    ToDoList.jar

The _ToDoList.info_ file currently contains these contents:

    main_class = com.devdaily.sarah.plugin.todolist.ToDoListPlugin
    plugin_name = To-Do List


Developers - Building this Plugin
---------------------------------

You can build this plugin using the shell script named _build-jar.sh. It currently looks like this:

    #!/bin/bash

    sbt package

    if [ $? != 0 ]
    then
        echo "'sbt package' failed, exiting now"
        exit 1
    fi

    cp target/scala-2.10/timer_2.10-0.1.jar Timer.jar

    ls -l Timer.jar

    echo ""
    echo "Created Timer.jar. Copy that file to /Users/al/Sarah/plugins/DDTimer, like this:"
    echo "cp Timer.jar /Users/al/Sarah/plugins/DDTimer"


Dependencies
------------

This plugin depends on:

* The Sarah2.jar file.
* The Akka/Scala actors. The actor version needs to be kept in sync with whatever actor version
  Sarah2 uses.
* ScalaTest

As mentioned above, I need to improve the process of requiring and using the Sarah2.jar file,
but that's more of a problem for the Sarah2 project than for this project. 









