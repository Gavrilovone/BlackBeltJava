
package Multithreading_Monitor_and_synchronized_blocks;
/**
 * монитор это специальный механизм/сущность при котором достигается корректная работа при синхронизации
 * в java у каждого объекта есть привязанная к нему сущность, которая называется монитор, монитор может иметь статус свободен или занят
 * когда один поток заходит в область кода(или весь метод целиком) который помечен как synchronized монитор принимает состояние занято, в одно и тоже
 * время монитор может работать только с одним потоком.Важно запомнить! что любая блокровка происходит на уровне объекта, а не области кода.Для синхронизации
 * метода(так как у него нет никакого монитора) используются объекты или классы
 */
public class Monitor {
    
}