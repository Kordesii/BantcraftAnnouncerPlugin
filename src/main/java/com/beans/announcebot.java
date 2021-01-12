package com.beans;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.TimerTask;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public final class announcebot extends JavaPlugin {

    public ConfigModel cm;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage("BRUH YOU SPILLED THE BEANS!!! wtf (Plugin enabled)");

        CheckPluginFolder();

        cm = new ConfigModel();
        try {
            cm.ReadAndSetConfig();
            AnnouncerTimer myAnnounceTimer = new AnnouncerTimer(this);
            Timer myTimer = new Timer();
            myTimer.scheduleAtFixedRate(myAnnounceTimer, 0, cm.minutes * 60 * 1000 );
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void TestPlugin()
    {
        for (Iterator<String> i = cm.messages.iterator(); i.hasNext();) {
            String item = i.next();
            Bukkit.getConsoleSender().sendMessage(item);
        }
    }

    public void CheckPluginFolder()
    {
        File pluginFolder = new File("plugins/AnnounceBot");
        if(!pluginFolder.exists())
        {
            pluginFolder.mkdir();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void AnnounceMessage() throws InterruptedException {
        cm.currentMessageIndex++;
        if(cm.currentMessageIndex > cm.messages.size()-1)
        {
            cm.currentMessageIndex = 0;
        }
        //System.out.println(cm.messages.size());
        //System.out.println(cm.currentMessageIndex);

        String message = (String)cm.messages.get((int)cm.currentMessageIndex);
        Bukkit.broadcastMessage(message);
    }

}
