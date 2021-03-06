package com.aerimmmmon;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class AExample extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {
        String token = "OTQwMzg4NzQwNzc2NDkzMDc3.YgGrQw.wia3-dE0br5lb-VYdgf2M6Zq-YM";

        try {
            JDA jb = JDABuilder.createDefault(token).build();
            // JDABuilder jb = (JDABuilder) JDABuilder.createDefault(token).build();

            jb.setAutoReconnect(true);
            jb.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
            jb.addEventListener(new AListner());

        } catch (LoginException e1) {
            e1.printStackTrace();
        }
    }
}
