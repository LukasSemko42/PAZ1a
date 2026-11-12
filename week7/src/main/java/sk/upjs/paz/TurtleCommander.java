package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;

public class TurtleCommander extends Turtle {

    public void listDirectory(File adresar){
        try {
            String[] dir = adresar.list();
            for (int i = 0; i < dir.length; i++) {
                System.out.println(dir[i]);
            }
        } catch (NullPointerException e){
            System.err.println(e.getMessage());
        }
    }

    public int countFiles(File adresar){
        int count=0;
        try {
            File[] dirs = adresar.listFiles();
            for (int i = 0; i < dirs.length; i++) {
                if (dirs[i].isFile()){
                    count++;
                }
            }
            return count;
        } catch (NullPointerException e){
            System.err.println(e.getMessage());
        }
        return count;
    }

    public long totalSizeOfFilesInDirectory(File adresar){
        long fileSizes=0;
        try {
            File[] dirs = adresar.listFiles();
            for (int i = 0; i < dirs.length; i++) {
                if (dirs[i].isFile()){
                    fileSizes+=dirs[i].length();
                }
            }
            return fileSizes;
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
        return fileSizes;
    }

    public void punishment(File output, String message, int n){
        try (PrintWriter pw = new PrintWriter(output)){
            for (int i = 0; i < n; i++) {
                pw.write(message+"\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }


}
