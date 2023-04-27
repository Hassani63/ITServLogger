# Logger Library

The Logger Library provides a simple and customizable logging solution for Java applications. It allows for the configuration of multiple log targets with different logging levels, and supports asynchronous logging.

## Usage

To use the Logger Library, follow these steps:

1. Add the library to your project's dependencies.
2. Create a new instance of the Logger class.
3. Use the `log()` method to log messages with the default logging level (DEBUG) to all log targets.
4. Use the `log(message, logLevel)` method to log messages with a specific logging level to all log targets that have a logging level equal to or greater than the specified logging level.

## Log Levels

The Logger Library supports the following log levels, in order of increasing severity:

- DEBUG
- INFO
- WARNING
- ERROR

## Log Targets

The Logger Library supports the following log targets:

- ConsoleLogTarget (logs messages to the console)
- EmailLogTarget (logs messages to an email address)
- FileLogTarget (logs messages to a file)
- ServerLogTarget (logs messages to a server)

## Configuration

The Logger Library can be configured at runtime using the following methods:

- `setMinimumLogLevel(logLevel)`: sets the minimum logging level for all log targets.
- `setLogLevel(logTarget, logLevel)`: sets the logging level for the specified log target.
- `addLogTarget(logTarget)`: adds a new log target.
- `removeLogTarget(logTarget)`: removes an existing log target.

## Improvements

Some possible improvements to the Logger Library include:

- Adding support for additional log targets, such as a database.
- Adding support for custom log levels.
- Adding support for logging contexts, which can be used to add additional metadata to log messages.
