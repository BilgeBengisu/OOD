### Object Oriented Design Final Project
This Java Swing application

## Project Gif:
![ood_gif](https://github.com/user-attachments/assets/1930effa-e036-46b2-8f69-488a86c66698)


## OOD Concepts used:
Single Responsibility Principle:

Open-Closed Principle:

Factory Pattern - DeckFactory:

Observer Pattern - DeckObserver:
The subject is the UI

Strategy Pattern - LanguageSelectionStrategy:

Singleton Pattern - SessionController:


# How to Run:
clone the repository
```cd Final Project 
javac $(find . -name "*.java") -d . && java Main
```

# Java Specifics:
Invoke Later was used to execute Runnable objects on the AWT event-dispatching thread because Swing data structures are not thread-safe by default.

Moreover, callbacks have been implemented to modularize/decouple the code and avoid the various UI functionalities all being stored in FlashcardUI. This helps protect both the O/C and the Single Responsibility Principle.

# Resources Used:
Consumer interface = https://www.geeksforgeeks.org/java/java-8-consumer-interface-in-java-with-examples/
Invoke Later = https://stackoverflow.com/questions/6567870/what-does-swingutilities-invokelater-do
Runnable = https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html
Runnable = https://www.geeksforgeeks.org/java/runnable-interface-in-java/
