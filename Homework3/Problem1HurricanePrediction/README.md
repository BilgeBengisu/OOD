The design patterns implemented are Command and Template

Command class has subclasses:
    - FetchDataCommand --> uses WeatherDataFetcher class
    - PredictionCommand --> uses PredictionModel class
    - SaveResultsCommand --> uses ResultsSaver class

PredictionInvoker class provides flexibility to track, add, or remove individual steps without changing the overall workflow. The structure is as follows
    Fields:
        commands: List<Command>
    Methods:
        addCommand(Command command): Adds a command to the list.
        executeCommands(): Executes each command in the list in sequence.

Template pattern is implemented through HurricanePredictionTemplate class with concrete subclasses:
    - MachineLearningPrediction
    - StatisticalPrediction
    which override the steps outlined in the HurricanePredictionTemplate

Test1 acts as the main, executing and testing the functionality of the program.

resources used: 
https://refactoring.guru/design-patterns/template-method
https://refactoring.guru/design-patterns/composite