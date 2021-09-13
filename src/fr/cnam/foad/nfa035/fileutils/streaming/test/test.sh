#/bin/sh

JAVA_PATH="/c/Program Files/Java/jdk-13.0.1/bin/java"
PROJECT_PATH=/c/Users/tvonstebut/IdeaProjects/NFA035

cp $PROJECT_PATH/petite_image_2.png ./
"$JAVA_PATH" -ea -classpath "out/production/NFA035;lib\commons-codec-1.15.jar" -Duser.dir=$PROJECT_PATH fr.cnam.foad.nfa035.fileutils.streaming.test.StreamingTest
rm petite_image_2.png