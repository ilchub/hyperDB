package io.ice.hypercli.menuhandler;

import io.ice.hyperdb.hyperDB;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EditMenuSections {
    public static String dbName;
    public static void EditMenu(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Create new database record - n");
        System.out.println("Delete database record - d");
        System.out.println("List full database content - l");
        System.out.println("Return to main menu - m");
        try{
            while (true){
                int key = bufferedReader.read();
                if (key == 110){
                    CreateNewDBRecord();
                }
                else if (key == 100){
                    DeleteDBRecord();
                }
                else if (key == 108){
                    ListDBContent();
                }
                else if (key == 109){
                   io.ice.hypercli.main.MainMenu();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void CreateNewDBRecord(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please specify name: ");
        String name = scan.nextLine();
        System.out.print("Please specify birth date: ");
        String birthDate = scan.nextLine();
        System.out.print("Please specify numberic identifier: ");
        int id = Integer.parseInt(scan.nextLine());
        System.out.print("Please specify item name: ");
        String itemName = scan.nextLine();
        hyperDB.DatabaseRecordHandler.AddDBRecord(dbName, name + " " + birthDate + " " + id + " " + itemName);
        EditMenu();
    }
    public static void DeleteDBRecord(){
        Scanner scan = new Scanner(System.in);
        hyperDB.DatabaseHandler.GetDBContent(dbName);
        System.out.print("Please specify record number, you want to delete: ");
        int recordNumber = Integer.parseInt(scan.nextLine());
        hyperDB.DatabaseRecordHandler.RemoveDBRecord(dbName, recordNumber);
        EditMenu();
    }
    public static void ListDBContent(){
        hyperDB.DatabaseHandler.GetDBContent(dbName);
        EditMenu();
    }
}
