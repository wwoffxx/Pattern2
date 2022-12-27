package org.example.Camera;

public class Main {
    public static void main(String[] args) {
        Watcher sp = new Watcher();
        Camera cam1 = new Camera("Cam1");
        sp.Attach(cam1);
        Msg msg = new Msg("Cam1",  cam1.seeSomething()+"\n");
        sp.addMsg(msg);

        System.out.println("cam2");
        Camera cam2 = new Camera("Cam2");
        sp.Attach(cam2);
        Msg msg2 = new Msg("Cam2",  cam2.seeSomething()+"\n");
        sp.addMsg(msg2);

    }
}