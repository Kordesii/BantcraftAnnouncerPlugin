package com.beans;

import java.util.TimerTask;

public class AnnouncerTimer extends TimerTask {

    public announcebot bukkitStuff;

    public AnnouncerTimer(announcebot ref)
    {
        bukkitStuff = ref;
    }

    @Override
    public void run() {
        bukkitStuff.AnnounceMessage();
    }
}
