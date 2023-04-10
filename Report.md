# Lawnmower Simulation using State and Observer Design Patterns

<h1>Introduction</h1>

This project aims to create a lawnmower simulation that follows a right-left mowing pattern on a lawn grid. The program uses Java Swing for creating a simple graphical interface and employs the State and Observer design patterns to create a flexible and maintainable solution.

# State Pattern

The State pattern is used to manage the lawnmower's behavior as it moves across the lawn. The lawnmower can be in one of three states: MowingRightState, MowingLeftState, or MovingDownState. The state of the lawnmower determines its next move and whether it needs to change its state.

MowingRightState: In this state, the lawnmower moves right across the lawn. When it reaches the right edge, it transitions to the MovingDownState.

MowingLeftState: In this state, the lawnmower moves left across the lawn. When it reaches the left edge, it transitions to the MovingDownState.

MovingDownState: In this state, the lawnmower moves down one row to the next row, then changes its state to either MowingRightState or MowingLeftState, depending on its previous state.

The State pattern allows us to encapsulate the behavior of the lawnmower for each state into separate classes, making it easier to extend or modify the behavior in the future.

# Observer Pattern

The Observer pattern is employed to keep the graphical interface (LawnView) updated with the lawnmower's position on the lawn. The Lawnmower class acts as the subject, and the LawnView class acts as the observer.

The Lawnmower class maintains a list of observers (in this case, only one observer, the LawnView) and provides methods to register and unregister observers. Whenever the lawnmower's position changes, it notifies all registered observers by calling their update() method.

The LawnView class implements the Observer interface and updates the display whenever the update() method is called. This allows the graphical interface to react to the changes in the lawnmower's position, ensuring that the display remains up-to-date.

# Implementation

The program is implemented in Java and uses the following classes:

Lawn: Represents the lawn as a grid of rows and columns.
Lawnmower: Represents the lawnmower and manages its state and position on the lawn.
Cutter: A simple class that represents the cutting action of the lawnmower.
State: An interface implemented by the MowingRightState, MowingLeftState, and MovingDownState classes.
Observer: An interface implemented by the LawnView class.
LawnView: A Java Swing JFrame that displays the lawn and the lawnmower's position, as well as provides Start and Stop buttons to control the simulation.
Main: The main class that initializes the simulation and displays the LawnView.
# Conclusion

The lawnmower simulation demonstrates the effective use of the State and Observer design patterns in creating a flexible, maintainable, and easy-to-understand solution. By employing these design patterns, the program can be easily extended or modified to accommodate new requirements, such as changing the mowing pattern or adding additional observers.