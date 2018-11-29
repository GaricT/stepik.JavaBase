package chapter4;
import java.util.logging.*;


/*
Требуется выставить такие настройки, чтобы:
    - Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
    - Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
    - Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java", независимо от серьезности
    сообщения печатались в консоль в формате XML (*) и не передавались вышестоящим обработчикам на уровнях
    "org.stepic", "org" и "".

 */
public class Exercise_43_1 {
    public static void main(String[] args) {
        /*
        Инициализируем переменную для логгера класса А
        Устанавливаем ему заданный уровень логирования
        */
        Logger loggerA = Logger.getLogger("org.stepic.java.logging.ClassA");
        loggerA.setLevel(Level.ALL);

        /*
        Инициализируем переменную для логгера класса B
        Устанавливаем ему заданный уровень логирования
        */
        Logger loggerB = Logger.getLogger("org.stepic.java.logging.ClassB");
        loggerB.setLevel(Level.WARNING);

        /*
        Создаем форматтер
        */
        Formatter simpleXml = new XMLFormatter();

        /*
        Создаем консольный логгер
        Устанавливаем уровень вывода
        Задаем форматтер
         */
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(simpleXml);

        /*
        Инициализируем переменную для логгера класса "org.stepic.java"
        Отключаем передачу сообщений родителям класса
        Подключаем консольный логгер
        */
        Logger logger = Logger.getLogger("org.stepic.java");
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
    }
}
