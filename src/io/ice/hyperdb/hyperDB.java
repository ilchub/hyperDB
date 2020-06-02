package io.ice.hyperdb;

import io.ice.hypercli.menuhandler.EditMenuSections;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class hyperDB {
    public static class DatabaseHandler{
        public static void CreateDB(String dbFilename){
            try {
                File database = new File(dbFilename + ".txt");
                database.createNewFile();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        public static void DeleteDB(String dbFilename){
            File database = new File(dbFilename);
            database.delete();
        }
        public static void GetDBContent(String dbFilename){
            File database = new File(dbFilename);
            try {
                List<String> dbContentList = Files.readAllLines(Paths.get(dbFilename));
                AtomicInteger i = new AtomicInteger();
                dbContentList.forEach(record -> System.out.println(i.getAndIncrement()+1 + ". " + record));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static class DatabaseRecordHandler{
        public static void AddDBRecord(String dbFilename, String dbRecord){
            try {
                String formattedDBRecord = dbRecord + "\n";
                Files.write(Paths.get(dbFilename), formattedDBRecord.getBytes(), StandardOpenOption.APPEND);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        public static void RemoveDBRecord(String dbFilename, int recordNumber){
            try {
                FileWriter dbHandler = new FileWriter(dbFilename);
                List<String> dbContent = Files.readAllLines(Paths.get(dbFilename));
                dbContent.remove(recordNumber-1);
                String[] dbContentFinal = dbContent.toArray(String[]::new);
                Files.write(Paths.get(dbFilename), dbContentFinal.toString().getBytes(), StandardOpenOption.WRITE);
            }
            catch (IOException | IndexOutOfBoundsException e){
                e.printStackTrace();
                EditMenuSections.EditMenu();
            }
        }
    }
}
