package com.beans;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.*;
import java.nio.file.*;

public class ConfigModel {

    public String configFilePath = "plugins/AnnounceBot/config.cfg";

    public int minutes = 0;

    public List messages;

    public int currentMessageIndex = 0;

    public ConfigModel()
    {
        messages = new ArrayList<String>();
    }

    public void ReadAndSetConfig() throws IOException {
        File configFile = new File(configFilePath);
        if(configFile.createNewFile()){
            System.out.println("new config file created! please edit it! " + configFilePath);
            // create basic config file
            //timerInMinutes:
            //messages:

            PrintWriter configWriter = new PrintWriter(configFilePath, "UTF-8");
            configWriter.println("timerInMinutes:1");
            configWriter.println("messages:");
            configWriter.println("i love beans!");
            configWriter.println("man i love beans");
            configWriter.println("wheres your daily dose of beans?");
            configWriter.println("beans are healthy!");
            configWriter.println("YOU ATE ALL MY BEANS NIGGER!!");
            configWriter.close();
        }else{
            //System.out.println("config file found! loading...");
            List<String> rawConfigContent = Files.readAllLines(new File(configFilePath).toPath(), Charset.defaultCharset() );
            //System.out.println("before getting the minutes");
            //System.out.println(rawConfigContent.get(0));
            String rawMinute = rawConfigContent.get(0);
            rawConfigContent.remove(0);
            rawMinute = rawMinute.split(":")[1];
            //System.out.println(rawMinute);
            minutes = Integer.parseInt(rawMinute);
            //System.out.println("before manipulating the rawConfigContent");
            //System.out.println("now trying to load all messages...");
            rawConfigContent.remove(0); // removing the messages: line
            for (Iterator<String> i = rawConfigContent.iterator(); i.hasNext();) {
                String item = i.next();
                if(item != "message:");
                messages.add(item);
            }
        }
    }





}
