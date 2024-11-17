# Design Patterns:

----
## Table of Contents:

1. [Command Factory](#Command Factory)
2. [Builder](#Builder)
3. [MVC](#MVC)
4. [Builder (Jline)](#Builder (Jline))
5. [Singleton](#Singleton)

----
# Command Factory:

### Location: CommandFactory
<p>

**Description:** 
Factory to create different command instances based on what string is passed into the method.
----
# Builder: 

### Location: UMLBUilderController
<p>

**Description:**
Builder Class to allow user to add and manipulate nodes in the GUI
----

# MVC:

### Location: Package Structure
<p>

**Description:**
package structure organizes code into three distinct categories, 
each only performing their required tasks.
----

# Builder (JLine)

### Location: SimpleAutoComplete
<p>

**Description:**
Create LineReader method in class, uses builder pattern to build a new line reader
object.
----

# Singleton

### Location: Storage
<p>

**Description:**
Singleton Storage class create a single instance of storage. Ensures that UMLEditor only has one
instance of Storage, and creates global access to the instance. 

**Singleton Aspects**: 
  * private static field for storing singleton instance
  * public static creation method getInstance()
  * private Storage constructor

---