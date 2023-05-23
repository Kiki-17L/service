package com.example.demo.websocket;



import com.example.demo.Thread.QueryThread;
import com.example.demo.config.SpringBasedConfigurator;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;




@Component

@ServerEndpoint(value = "/test", configurator = SpringBasedConfigurator.class)
public class websocketEndpoint {

    Session session;
    @OnOpen

    public void onOpen(Session session) {
        this.session = session;

        try {
            session.getBasicRemote().sendText("连接成功");
        }
        catch (Exception e){


            e.printStackTrace();
        }

        System.out.println("连接成功");
        //当连接建立时,开启轮询Task
        Thread queryTask=new Thread(new QueryThread(websocketEndpoint.this));
        queryTask.start();
    }

    //监听数据变化
    public void listenForDataChanges(String Data) {

        pushDataToClient(Data);
    }

    private void pushDataToClient(String newData) {
        try {
            // 通过WebSocket连接发送数据给客户端
            session.getBasicRemote().sendText(newData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(Session session, String message) {

    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {

        System.out.println("连接关闭");
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
            throwable.printStackTrace();
    }



}
