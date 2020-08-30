# Описание задачи
 Имеется некая система, которая обрабатывает авиа перелёты. Перелёт — это перевозка пассажира из одной точки в другую с возможными промежуточными посадками. Т. о. перелёт можно представить как набор из одного или нескольких элементарных перемещений, называемых сегментами. Сегмент — это атомарная перевозка, которая для простоты характеризуется всего двумя атрибутами: дата/время вылета и дата/время прилёта.
 
 Необходимо написать модуль, который будет занимаеться фильтрацией набора перелётов согласно различным правилам. Правил фильтрации может быть очень много. Также наборы перелётов могут быть очень большими. Правила могут выбираться и задаваться динамически в зависимости от контекста выполнения операции фильтрации.
 
   Продумать структуру модуля, создать необходимые классы и интерфейсы. Покрыть код тестами. Пользовательский интерфейс не рассматривается. Информации выводится в консоль. Сторонние библиотеки не используются.
   
  Пакет initial содержит упрощённые модельные классы и фабрику для получения тестовых образцов.
  
  Из тестового набора перелёты исключаются по следующим правилам (по каждому правилу нужен отдельный вывод списка перелётов):
1.	Вылет до текущего момента времени;
2.	Имеются сегменты с датой прилёта раньше даты вылета;
3.	Общее время, проведённое на земле превышает два часа (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним).

# Запуск
```sh
$ ./mvnw package
$ java -jar ./target/testing-1.0.jar 
```
# Пример вывода
![Снимок экрана 2020-08-30 в 20 08 28](https://user-images.githubusercontent.com/66326889/91665402-f407d180-eafd-11ea-8ddf-d1f649f4076e.png)
