package org.example.Camera;

import java.util.ArrayList;

public class Watcher implements Subj{
    protected ArrayList<Msg> allMsg;
    protected ArrayList<CamObserver> observers;
    public Watcher(){
        allMsg = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addMsg(Msg msg){
        allMsg.add(msg);
        Notify();
    }

    public void seeMsg(){
        Notify();
    }

    public ArrayList<Msg> getState(){
        return allMsg;
    }

    public void Attach(CamObserver o){
        observers.add(o);
    }

    public void Dettach(CamObserver o){
        observers.remove(o);
    }


    public void Notify(){
        for (int i=0;i<observers.size();i++){
            observers.get(i).update(this);
        }
    }

}
