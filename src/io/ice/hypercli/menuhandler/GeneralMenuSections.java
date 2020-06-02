package io.ice.hypercli.menuhandler;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;
import io.ice.hyperdb.hyperDB;

public class GeneralMenuSections {
    public static void CreateDB(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter database name: ");
        String dbName = scan.nextLine();
        hyperDB.DatabaseHandler.CreateDB(dbName);
        io.ice.hypercli.main.MainMenu();
    }
    public static void DeleteDB(){
        GetDBList();
        System.out.println("Please enter database name(with .txt extension) you want to delete: ");
        Scanner scan = new Scanner(System.in);
        String dbName = scan.nextLine();
        hyperDB.DatabaseHandler.DeleteDB(dbName);
        io.ice.hypercli.main.MainMenu();
    }
    public static void EditDB(){
        GetDBList();
        System.out.println("Please enter database name(with .txt extension) you want to edit: ");
        Scanner scan = new Scanner(System.in);
        String dbName = scan.nextLine();
        EditMenuSections.dbName = dbName;
        EditMenuSections.EditMenu();
    }
    public static void GetDBList(){
        File dir = new File(".");
        System.out.println(Arrays.toString(dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                return filename.endsWith(".txt");
            }
        })));
    }
}
