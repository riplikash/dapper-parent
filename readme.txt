*        Dapper Engine           
* An OpenGL "game" engine using: *  
* Java, Spring, and Maven

ABOUT
The Dapper Engine is just a small side project of mine for learning new 
technologies in a moderately stable and portable environment using one of
my favorite aspects of software as a focus: interactive computer graphics.

While many of the various free systems out there have more features, that
is really besides the point. I like learning to build things from scratch,
so that is what I'm doing here.

CURRENT FEATURES
Basic 2D drawing and control
Swing supported modular injection of control
Maven2 build system
Simple 2d font system

INSTALLATION
The Dapper Engine uses maven to provide fairly simple setup in any maven 
build environment. You can either import it as a maven project into a maven
compatible IDE (Intellij or Eclipse, for example) or build it from the 
command line by running 'mvn clean install' in the dapper-parent directory 
(providing you have maven installed on your computer). A simple Maven 
install is typically enough to get things up and running, provided you 
have maven and java 1.7 sdk/jre installed.

RUNNING DEMOS
There are two major parts to the project: the engine, and a small application 
called a_star. The engine is made up of dapper-data and dapper-engine. 
"dapper-data: contains all of the primitives, interfaces, and mathematical 
calculations. "dappe-engine" implements the interfaces of dapper-data into 
with default objects and has a test running the system.

The other folder is a-star, which is an example project using the dapper 
engine. There is an executable in the target/a_star folder. The program
contains a simple grid/graphs of nodes whose weight increments when clicked 
on. It is primarily used to practice graph algorithms. 