package com.cryptoanalizator.service;

import com.cryptoanalizator.transformer.TextTransformer;

import java.io.*;

public class EncryptService {

    TextTransformer textTransformer = new TextTransformer();
    public void encrypt (File file, int key){
        String fileName = file.getName();
        File f = new File("D:\\JavaRushProjects\\test.txt");
        f.renameTo(new File(fileName));
        String text = "";

        try (FileReader reader = new FileReader(file); FileWriter writer = new FileWriter(text); FileWriter fileWriter = new FileWriter(f)){
            char [] buffer = new char[65536];
            while (reader.ready())
            {
                int real = reader.read(buffer);
                writer.write(buffer, 0, real);
            }
            textTransformer.mooveLettersOnRhightPosition(key,text);
            fileWriter.write(text);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //as result fil should be stored in root folder
    }

}
