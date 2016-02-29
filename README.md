# vpl-unit-test
[Virtual Programming Lab](vpl.dis.ulpgc.e) is a powerful plugin for [Moodle](https://moodle.org) that allows students to upload
programming assignments for automatic grading. If you are teaching a programming course
with hundreds of students, I imagine you don't need too much convincing that this is a good idea :-) 

This is a very brief HOWTO on creating a VPL activity that uses unit tests to grade the assignment.

. Create the activity in the usual way. There is no need to define tests in `vpl_evaluate.cases`.
. Create a suite of unit tests that you want to use to grade the activity, e.g. `MyTest.java`. Add this file to the 
  *Execution Files* section in your activity.
. Create a second class which runs the tests in `MyTest` "manually", as it were -- i.e. by calling the tests individually 
  rather than using the JUnit test runner. See the example in `src/Main.java`. Again, add this file to the *Execution Files* 
  for the activity. As well as calling the tests, the `Main` class has to calculate the grade and emit comments and a grade 
  in the format required by VPL. Anything other than comments and a single grade is ignored and you must use the exact formats 
  used in `Main.java`. If your test suite contains several tests, each of which you want to constitute part of the mark, make
  this calculation yourself in the `Main` class. Then print out any explanation you want to give to the student in comment
  sections and a single overall `Grade :==> n` line at the end of the output. 
. Create a `vpl_run.sh` script which allows the student to run the test suite. See `etc/vpl_run.sh` for an example. Edit the script to 
  contain the correct path to the JUnit jar on your jail server if necessary.
. Create a `vpl_evaluate.sh` script which allows the student to evaluate their code and receive a mark. 
  See `etc/vpl_evaluate.sh` for an example. Again, make sure the path to the JUnit jar is correct.
  