1. Настройка
Для проекта можно выставить уровень логирования, директорию логирования и URL для работы с REST API. 
Конфигурационный файл для логирования \stackexchangeApiClient\src\main\resources\log4j.properies  
Конфигурационный файл для URL \stackexchangeApiClient\src\main\resources\config.properies

2. Компиляция
Сборка проекта осуществляется с помощью Gradle. Используется JDK 1.8.
Для сборки необходимо из директории с проектом набрать в консоли команду gradle build

3. Запуск
Скомпилированный JAR будет помещён в диреторию \stackexchangeApiClient\build\libs 
Запускать нужно с командной строки из директории с архивом командой java -jar stackexchangeApiClient-1.0.jar
Можно также запустить приложение с параметром - номером порта, на котором оно будет развёрнуто
Пример java -jar stackexchangeApiClient-1.0.jar 81