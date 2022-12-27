package org.example.Camera;

public class Msg {
    String receiverName;
    String content;

    public Msg(String name, String content){
        this.receiverName = name;
        this.content=content;
    }
}
