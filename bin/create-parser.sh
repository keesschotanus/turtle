# Creates the javacc parser classes
# First step is to create classes from the javacc/turtle.jjt file.
# Apart from generating Java files ths step creates a javacc/turtle.jj file.
# In the next step classes are generated from this javacc/turtle.jj file.

# Note
# This file assumes that a javacc file is in the CLASSPATH
# Personally I use the next line to make sure javacc is on my CLASSPATH
# export CLASSPATH=.:/home/kees/projects/javacc-javacc-7.0.10/target/javacc-7.0.10.jar

# Check if javacc is on the CLASSPATH
if [[ "$CLASSPATH" != *"javacc"* ]]; then
   echo "Please make sure that the javacc jar file is in your CLASSPATH"
   exit 1;
fi

# Generate Java parser classes and javacc/turtle.jj file.
java -classpath $CLASSPATH jjtree -node_uses_parser=true -multi -node_package=com.schotanus.turtle.parser -jjtree_output_directory=../src/main/java/com/schotanus/turtle/parser -output_file=../../../../../javacc/turtle.jj ../src/main/javacc/turtle.jjt

# Generate Java parser classes from javacc/turtle.jj file.
java -classpath $CLASSPATH javacc -output_directory=../src/main/java/com/schotanus/turtle/parser "../src/main/javacc/turtle.jj"

