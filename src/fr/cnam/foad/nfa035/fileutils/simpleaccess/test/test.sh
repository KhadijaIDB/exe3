#/bin/sh

JAVA_PATH="/c/Program Files/Java/jdk-13.0.1/bin/java"
PROJECT_PATH=/c/Users/tvonstebut/IdeaProjects/NFA035

"$JAVA_PATH" -ea --class-path out/production/NFA035 -Duser.dir=$PROJECT_PATH fr.cnam.foad.nfa035.fileutils.simpleaccess.test.SimpleAccessTest
