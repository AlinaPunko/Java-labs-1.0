package by.belstu.it.punko.writer;

import by.belstu.it.punko.writerfile.WriterFile;

import java.io.*;

public class WriterStream extends Thread
{
    private WriterFile file;
    public WriterStream(String name, WriterFile rs) {
        super(name);
        this.file = rs;
    }
    public void run() {
        for (int i = 1; i < 30; i++) {
            file.dumping(getName(), i);
// место срабатывания синхронизации
        }
    }
}

