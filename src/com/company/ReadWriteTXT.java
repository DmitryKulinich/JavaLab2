package com.company;

import java.io.*;

/**
 * Created by dmitry on 9/19/17.
 */

public class ReadWriteTXT extends metroStation {

    public ReadWriteTXT(String name, Integer yearOfOpening){
        super(name,yearOfOpening);
    }

    public ReadWriteTXT() {
    }

    public void writeTXT(String filename){
        try(FileWriter writer = new FileWriter(filename+".txt", false))
        {
            // запись всей строки
            String text = this.toString();
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public ReadWriteTXT readTXT(String fileName){
        String NameOFStation;
        Integer yearOfOpening;
        ReadWriteTXT forRet = new ReadWriteTXT();
        try {
            File file = new File(fileName + ".txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            NameOFStation = line;
            line = reader.readLine();
            yearOfOpening = Integer.parseInt(line);
            line = reader.readLine();
            forRet  = new ReadWriteTXT(NameOFStation,yearOfOpening);
            for(int i = 0; i < 24; i++){
                forRet.getHours()[i].setOclock(Integer.parseInt(line));
                line = reader.readLine();
                forRet.getHours()[i].setComment(line);
                line = reader.readLine();
                forRet.getHours()[i].setNumberOfPassenger(Integer.parseInt(line));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return forRet;
    }

}

