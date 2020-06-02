package io.ice.hypercli;

import io.ice.hypercli.menuhandler.GeneralMenuSections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class main {
    public static void main(String[] args){
        System.out.print("HyperDB Client is starting up...");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("done");
        System.out.println("Create a new database - n");
        System.out.println("Edit existing database - e");
        System.out.println("Delete database - d");
        System.out.print("Please enter your selection(n/e/d) : ");
        //n - 110
        //e - 101
        //d - 100
        try {
            while (true) {
                int key = bufferedReader.read();
                if(key == 110){
                    GeneralMenuSections.CreateDB();
                }
                else if (key == 101){
                    GeneralMenuSections.EditDB();
                }
                else if (key == 100){
                    GeneralMenuSections.DeleteDB();
                }
                else {
                    System.out.println(key);
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void MainMenu(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Create a new database - n");
        System.out.println("Edit existing database - e");
        System.out.println("Delete database - d");
        System.out.print("Please enter your selection(n/e/d) : ");
        //n - 110
        //e - 101
        //d - 100
        try {
            while (true) {
                int key = bufferedReader.read();
                if(key == 110){
                    GeneralMenuSections.CreateDB();
                }
                else if (key == 101){
                    GeneralMenuSections.EditDB();
                }
                else if (key == 100){
                    GeneralMenuSections.DeleteDB();
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
