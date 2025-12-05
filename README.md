
# Object Oriented Design Final Project

## Overview
This is a Java application for language learning using flashcards. It demonstrates key Object Oriented Design principles and patterns, including Factory, Strategy, Observer, and Singleton. The project is modular, extensible, and designed for maintainability.

## Features
- Multiple language support (Italian, Turkish, Portuguese)
- Flashcard deck creation and management
- Progress tracking and session management
- Extensible design for adding new languages
- UI separation and helpers for clean code
- Country Flag specific UI design!!

## Project Demo
![ood_gif](https://github.com/user-attachments/assets/1930effa-e036-46b2-8f69-488a86c66698)

## Object Oriented Design Concepts Used
- **Single Responsibility Principle:** Each class has a clear, focused responsibility (e.g., `Deck` manages flashcards, `SessionManager` manages session state).
- **Open-Closed Principle:** The system is open for extension (e.g., adding new languages via new strategy and factory classes) but closed for modification.
- **Factory Pattern:** Used for deck creation (`DeckFactory`, `ItalianDeckFactory`, etc.).
- **Observer Pattern:** `DeckObserver` interface, `Deck` as subject, `SessionManager` as observer/subscriber.
- **Strategy Pattern:** Language selection and session logic are handled via strategies (`LanguageSelectionStrategy`, `ItalianStrategy`, etc.).
- **Singleton Pattern:** `SessionManager` ensures only one session manager instance exists.

## How to Run
Clone the repository and compile the project:
```sh
cd FinalProject
javac $(find . -name "*.java") -d .
java Main
```

## How to Test
Run the functional test class to verify application features:
```sh
javac $(find . -name "*.java")
java Test
```
This will test deck creation, singleton behavior, language selection, flashcard loading(Factory pattern), progress tracking(observer pattern), and session reset.

## Java Specifics
- `SwingUtilities.invokeLater` is used to execute UI updates on the AWT event-dispatching thread for thread safety.
- Callbacks and modular helpers are used to decouple UI logic from business logic, supporting SRP and OCP.

## Extending the Project
To add a new language:
- Create a new strategy class (e.g., `FrenchStrategy`)
- Create a new factory class (e.g., `FrenchDeckFactory`)
- Add a new CSV file with phrases
- Update the UI and selection logic if needed

## Resources Used
- [Java 8 Consumer Interface](https://www.geeksforgeeks.org/java/java-8-consumer-interface-in-java-with-examples/)
- [SwingUtilities.invokeLater](https://stackoverflow.com/questions/6567870/what-does-swingutilities-invokelater-do)
- [Runnable Interface (Java Docs)](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html)
- [Runnable Interface (GeeksforGeeks)](https://www.geeksforgeeks.org/java/runnable-interface-in-java/)
