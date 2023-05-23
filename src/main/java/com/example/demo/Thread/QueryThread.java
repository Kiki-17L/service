package com.example.demo.Thread;

//这是查询线程


import com.example.demo.database.DataBase;
import com.example.demo.websocket.websocketEndpoint;
import jakarta.websocket.Session;

public class QueryThread implements Runnable{

    websocketEndpoint endpoint;
    String data;
    String newData;

    public QueryThread(websocketEndpoint endpoind){

        this.endpoint=endpoind;
    }

    @Override
    public void run() {

        DataBase dataBase=new DataBase();

        data=dataBase.fetchdata();


        while (true) {

            try {
                newData=dataBase.fetchdata();

                if (!data.equals(newData)) {
                    System.out.println("一条新数据: "+newData);
                    data=newData;

                    endpoint.listenForDataChanges(newData);
                    //发消息
                }

                Thread.sleep(1000);
            } catch (Exception e) {

                e.printStackTrace();
                System.exit(0);
            }

        }
    }
}

