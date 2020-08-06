package sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class new_server_main {
    private int port;
    private Set<String> username=new HashSet<String>();
    private Set<user_thread>userthread=new HashSet<user_thread>();

    public new_server_main(int Port)
    {
        this.port=Port;
    }
    public void execute()
    {
        try(ServerSocket server=new ServerSocket(port))
        {
            System.out.println("liestening to port" + port);
            while (true)
            {
                Socket socket=server.accept();
                System.out.println("new user connected...");

                user_thread user=new user_thread(socket,this);
                userthread.add(user);
                user.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void broadcast(String msg,user_thread exclude)
    {
        for(user_thread auser : userthread)
        {
            if(auser!=exclude)
            {
                auser.sendmessege(msg);
            }
        }
    }
    public void adduser(String user_name)
    {
        username.add(user_name);
    }
    public void removeuser(String user_name,user_thread user)
    {
        username.remove(user_name);
        userthread.remove(user);
    }
    Set<String> getusernames()
    {
        return this.username;
    }
    boolean has_user()
    {
        return !this.username.isEmpty();
    }


}
