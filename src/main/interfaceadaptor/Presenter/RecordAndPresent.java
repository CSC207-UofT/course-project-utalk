package interfaceadaptor.Presenter;
import interfaceadaptor.boundaries.WriteIntoTxtFile;


public class RecordAndPresent {
    /** record input into txt file and print it.
     * @param input the input String
     * @param data_path the data_path of the file
     */
    public void recordAndPresent(String input, String data_path){
        System.out.print(input);
        WriteIntoTxtFile wf = new WriteIntoTxtFile();
        wf.writeIntoTxtFile(input, data_path);
    }
}
