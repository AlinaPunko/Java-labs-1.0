package by.belstu.it.punko.main;

import Site.WorkingWithSite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        WorkingWithSite worker = new WorkingWithSite();
        worker.getLocalHost();
        worker.getByName("www.belstu.by");
        byte ip[] = {(byte)127,(byte)0,(byte)0,(byte)7};
        worker.getByAdress("Unknown",ip);
        worker.ReadHTML("https://www.tut.by");
        worker.getInfo("https://www.tut.by");
    }
}
