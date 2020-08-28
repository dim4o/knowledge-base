package kb.design_patterns.decorator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import kb.design_patterns.decorator.io.CommaInputStream;
import kb.design_patterns.decorator.io.LowerCaseInputStream;

public class JavaIOApp {
    

    public static void main(String[] args) throws IOException {
        System.out.println("USER DIR: " + System.getProperty("user.dir") + "\n");
        final String filePath = "./src/kb/design_patterns/decorator/test.txt";
        
        int c = 0;
        try (InputStream in = new LowerCaseInputStream(new CommaInputStream(
                new FileInputStream(filePath)))) {
            while ((c = in.read()) >= 0)
                System.out.print((char) c);
        }

        System.out.println();

        c = 0;
        try (InputStream in = new LowerCaseInputStream(
                new FileInputStream(filePath))) {
            while ((c = in.read()) >= 0)
                System.out.print((char) c);
        }
    }

}
