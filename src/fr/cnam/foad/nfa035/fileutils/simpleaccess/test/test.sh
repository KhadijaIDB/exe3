#/bin/sh
JAVA_PATH="/xxxxxxxxxxxxx/xxxxxxxxxxxxxxxxxxxxxxxxxxxx/bin/java"
PROJECT_PATH=/c/xxxxxxxxxxxxxxxxxxx/NFA035

"$JAVA_PATH" -ea --class-path out/production/NFA035 -Duser.dir=$PROJECT_PATH fr.cnam.foad.nfa035.fileutils.simpleaccess.test.SimpleAccessTest