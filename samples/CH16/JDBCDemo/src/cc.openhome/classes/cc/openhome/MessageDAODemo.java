package cc.openhome;

import static java.lang.System.out;
import java.util.Scanner;

public class MessageDAODemo {
    public static void main(String[] args) throws Exception {
        MessageDAO dao = new MessageDAO("jdbc:sqlite:demo.sqlite");
        // 在Windows的NetBeans中，其Output窗格的標準輸入編碼是MS950
        Scanner console = new Scanner(System.in, "MS950");
        while(true) {
            out.print("(1) 顯示留言 (2) 新增留言：");
            switch(Integer.parseInt(console.nextLine())) {
                case 1:
                    dao.get().forEach(message -> {
                        out.printf("%d\t%s\t%s\t%s%n", 
                                message.getId(), 
                                message.getName(), 
                                message.getEmail(), 
                                message.getMsg());
                    });
                    break;
                case 2:
                    out.print("姓名：");
                    String name = console.nextLine();
                    out.print("郵件：");
                    String email = console.nextLine();
                    out.print("留言：");
                    String msg = console.nextLine();
                    dao.add(new Message(name, email, msg));
            }
        }
    }
} 
