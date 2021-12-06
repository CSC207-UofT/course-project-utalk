package runner;

import interfaceadaptor.readers.AllReader;
import outerlayer.userinterface.MainUI;

public class Executer {
    public static void main(String[] args){
        AllReader.readAll();
        System.out.println("\n================================================================================================================================\nWelcome to U talk!\n\n");
        MainUI.registerSigninUi();
    }
}
