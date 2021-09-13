
SET JAVA_PATH="C:\Program Files\Java\jdk-13.0.1\bin\java"
SET PROJECT_PATH=C:\Users\tvonstebut\IdeaProjects\NFA035

copy C:\Users\tvonstebut\IdeaProjects\NFA035\petite_image_2.png .\petite_image_2.png
%JAVA_PATH% -ea -Duser.dir=%PROJECT_PATH% -classpath out\production\NFA035;lib\commons-codec-1.15.jar  fr.cnam.foad.nfa035.fileutils.streaming.test.StreamingTest
del petite_image_2.png
