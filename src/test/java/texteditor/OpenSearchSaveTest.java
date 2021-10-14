package texteditor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.test.util.ReflectionTestUtils;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

class OpenSearchSaveTest {
    public static void main(String[] args) {

    }
    @Test
    @EnabledIfEnvironmentVariable(named = "DISPLAY",matches =":0")
    public void open() throws IOException {
        Main main = new Main();
        String path = ".\\testfolder\\opentest.txt";
        File filenew = new File(path);
        if(!filenew.exists()){
            filenew.getParentFile().mkdirs();
        }
        filenew.createNewFile();

        // write
        FileWriter fw = new FileWriter(filenew, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("this is a little test");
        bw.flush();
        bw.close();
        fw.close();

        // read
        FileReader fr = new FileReader(main.openFile(filenew));
        BufferedReader br = new BufferedReader(fr);
        String str = br.readLine();
        br.close();
        fr.close();

        filenew.delete();

        assertEquals(str,"this is a little test");

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "DISPLAY",matches =":0")
    public void save() throws IOException {
        Main main = new Main();
        String path = ".\\testfolder\\testsave.txt";
        String path2 = ".\\testfolder\\testsavetwo.txt";
        File fileone = new File(path);
        File filetwo = new File(path2);
        if(!fileone.exists()){
            fileone.getParentFile().mkdirs();
        }
        fileone.createNewFile();

        // write
        FileWriter fw = new FileWriter(fileone, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("this is a little test");
        bw.flush();
        bw.close();
        fw.close();

        FileReader fr = new FileReader(fileone);
        BufferedReader br = new BufferedReader(fr);
        String strexception = br.readLine();
        br.close();
        fr.close();


        main.openFile(fileone);
        FileReader fre = new FileReader(main.saveFile(filetwo));
        BufferedReader bre = new BufferedReader(fre);
        String stractually = bre.readLine();
        bre.close();
        fre.close();

        fileone.delete();
        //find and delete the txt you saved
        filetwo.delete();



        assertEquals(strexception,stractually);
    }
    @Test
    @EnabledIfEnvironmentVariable(named = "DISPLAY",matches =":0")
    public void search() throws IOException {
        JTextPane area = new JTextPane();
        Main main = new Main();
        Main.FindAndReplace far = main.new FindAndReplace(area) ;
        String path = ".\\testfolder\\SearchTest.txt";
        File filenew = new File(path);
        if(!filenew.exists()){
            filenew.getParentFile().mkdirs();
        }
        filenew.createNewFile();

        // write
        FileWriter fw = new FileWriter(filenew, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("this is a little test");
        bw.flush();
        bw.close();
        fw.close();

        // read
        FileReader fr = new FileReader(filenew);
        BufferedReader br = new BufferedReader(fr);
        String str = br.readLine();
        br.close();
        fr.close();

        String want = "a";
        boolean result = str.contains(want);

        main.openFile(filenew);
        boolean resultactually = ReflectionTestUtils.invokeMethod(far,"Search");

        filenew.delete();

        assertEquals(result,resultactually);

    }
}

