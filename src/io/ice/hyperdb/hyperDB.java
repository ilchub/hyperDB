package io.ice.hyperdb;

import io.ice.hypercli.menuhandler.EditMenuSections;
import jdk.jshell.spi.ExecutionControl;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

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
        public static void RemoveDBRecord(String dbFilename, int recordNumber) throws ExecutionControl.NotImplementedException {
            throw new ExecutionControl.NotImplementedException("Removing records not yet implemented");
        }
    }
}