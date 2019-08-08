package client;

import lombok.extern.slf4j.Slf4j;
import server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SreceHandler implements Runnable
{
    Socket socket;
    public SreceHandler(Socket socket)
    {
        System.out.println(socket);
        this.socket = socket;
    }

    public void run()
    {
        BufferedReader in = null;
        try
        {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true)
            {
                String s = in.readLine();
                log.info("��һ���ͻ���::" + s);
                if (s.equals("asdfg"))
                {
                    log.info("�ͻ��˶Ͽ�");
                    break;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                TimeUnit.MICROSECONDS.sleep(100);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if (socket != null)
            {
                try
                {
                    log.info("�ͻ���socket�ر�");
                    socket.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (in != null)
            {
                try
                {
                    in.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
