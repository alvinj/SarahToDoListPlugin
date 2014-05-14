#!/bin/bash

sbt package

if [ $? != 0 ]
then
  echo "'sbt package' failed, exiting now"
  exit 1
fi

cp target/scala-2.10/todolist_2.10-0.1.jar ToDoList.jar

ls -l ToDoList.jar

echo ""
echo "Created ToDoList.jar. Copy that file to /Users/al/Sarah/plugins/DDToDoList, like this:"
echo "cp ToDoList.jar /Users/al/Sarah/plugins/DDToDoList"

