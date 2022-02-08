package com.aerimmmmon;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class AListner extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User user = event.getAuthor();
        TextChannel tc = event.getTextChannel();
        Message msg = event.getMessage();

        // Hello world
        /*if(user.isBot()) return;
        if(msg.getContentRaw().equalsIgnoreCase("hello")) {
            tc.sendMessage("Hello, " + user.getAsMention()).queue();
        }*/

        // 접두사 -> !
        if(msg.getContentRaw().charAt(0) == '!') {
            String[] args = msg.getContentRaw().substring(1).split(" ");
            if(args.length <= 0) return;

            /*// !test 입력 -> Hello, "유저이름" 출력
            if(args[0].equalsIgnoreCase("test")) {
                tc.sendMessage("Hello, " + user.getAsMention()).queue();
            }

            // !hello bot 입력 -> Hello, Sir! 출력
            // !hello human 입력 -> I'M NOT HUMAN! 출력
            else if(args[0].equalsIgnoreCase("hello")) {
                if(args.length < 2) return;
                if(args[1].equalsIgnoreCase("bot")) {
                    tc.sendMessage("Hello, Sir!").queue();
                } else if(args[1].equalsIgnoreCase("human")) {
                    tc.sendMessage("I'M NOT HUMAN!").queue();
                }
            }*/

            // !경매 "참여 인원" "금액" 입력
            if(args[0].equalsIgnoreCase("경매")) {
                if(args.length < 2) return;
                int person = Integer.parseInt(args[1]);
                int price = Integer.parseInt(args[2]);
                int profit1; // n빵
                int profit2; // n빵 선점
                if(person <= 8) {
                    profit1 = (int)((price-(price * 0.05)) * (double)(person - 1) / person);
                    profit2 = (int)(profit1 / 1.1);
                    tc.sendMessage("**" + Integer.toString(profit1) + "** 골드 이상 입찰하면 손해!").queue();
                    tc.sendMessage("**" + Integer.toString(profit2) + "** 골드 선점하면 그만이야~~!").queue();
                } else {
                    tc.sendMessage("경매 참여 인원 오류!").queue();
                }

                /*if(args[2].equalsIgnoreCase("bot")) {
                    tc.sendMessage("Hello, Sir!").queue();
                }*/
            }
        }
    }
}
