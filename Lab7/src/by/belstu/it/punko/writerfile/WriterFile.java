package by.belstu.it.punko.writerfile;

import java.io.FileWriter;
import java.io.IOException;

public class WriterFile
{
    private FileWriter ourfile;
    public WriterFile(String file) throws IOException {
// проверка наличия файла
        ourfile = new FileWriter(file, false);
    }
    public synchronized void dumping(String str, int i) {
        try {
            ourfile.append(str );
            System.out.print(str );
            Thread.sleep((long) (Math.random() * 50));

            ourfile.append(" записывает " + i + " итерацию \n");
            System.out.println(" записывает " + i + " итерацию\n");
        } catch (IOException e) {
            System.err.print("ошибка файла: " + e);
        } catch (InterruptedException e) {
            System.err.print("ошибка потока: " + e);
        }
    }
    public void close() {
        try {
            ourfile.close();
        } catch (IOException e) {
            System.err.print("ошибка закрытия файла: " + e);
        }
    }
}
