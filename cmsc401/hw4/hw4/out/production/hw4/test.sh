javac hw4.java
echo "test 1"
java hw4  <<EOF
x1 = 12
x2 = 3
x3 = x2 * x1
x4 = x3 - x1
QUIT
