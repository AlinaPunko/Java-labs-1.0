package by.belstu.it.punko.main;

import by.belstu.it.punko.writer.WriterStream;
import by.belstu.it.punko.writerfile.WriterFile;
import task2.Client;
import task2.Restaurant;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Semaphore;


public class Main {

    public static final int AMOUNT_OF_TABLES = 3;
    public static final int AMOUNT_OF_CLIENTS = 10;

     public static void main(String[] args) {
       Random rand = new Random();
        //Чаще всего, семафоры необходимы, когда нужно ограничить доступ к некоторому общему ресурсу.
        Semaphore semaphore = new Semaphore(AMOUNT_OF_TABLES, true);
        Restaurant restaurant = new Restaurant(AMOUNT_OF_TABLES);
        try {
            for (int i = 0; i < AMOUNT_OF_CLIENTS; i++) {
                new Client(restaurant, semaphore, i).start();
                Thread.sleep(rand.nextInt(300) + 300 );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*public static void main(String[] args) {
        WriterFile s = null;
        try {
            s = new WriterFile("E:/лабы/СТП/Lab7/notes.txt");
            WriterStream t1 = new WriterStream("Поток 1", s);
            WriterStream t2 = new WriterStream("Поток 2", s);
            WriterStream t3 = new WriterStream("Поток 3", s);
            t1.start();
            t2.start();
            t3.start();
            t1.join();
            t2.join();
            t3.join();
        } catch (IOException e) {
            System.err.print("ошибка файла: " + e);
        } catch (InterruptedException e) {
            System.err.print("ошибка потока: " + e);
        } finally {
            s.close();
        }*/

    }

