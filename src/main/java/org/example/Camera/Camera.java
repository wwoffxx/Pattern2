package org.example.Camera;

import java.util.ArrayList;
import java.util.Random;

public class Camera implements CamObserver {
    String name;
    String Detector = "Detector:";
    String pixels = "Pixels:";

    int[][] matrix = new int[10][10];

    private void outputCamera(String name) {
        System.out.println(name + "\n");

        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                System.out.print(this.matrix[i][j] + " ");
            }

            System.out.print("\n");
        }

    }

    public Camera(String name) {
        this.name = name;

        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                this.matrix[i][j] = 0;
            }
        }
        this.outputCamera(name);
    }

    public String seeSomething() {
        Random random = new Random();
        int count = 0;

        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                this.matrix[i][j] = random.nextInt(2);
                if (this.matrix[i][j] == 1) {
                    ++count;
                    this.pixels = this.pixels + "(" + (i + 1) + "," + (j + 1) + ")";
                }
            }
        }
        this.outputCamera(this.name);
        System.out.print("\n");
        if (count >= 2) {
            this.Detector = this.Detector + "/n ALARM!";
            return "\nmovement: " + count + " " + this.pixels + "\n" + this.Detector;
        } else {
            this.Detector = this.Detector + "keep watching...";
            return this.Detector;
        }
    }
    public void checkMsg(ArrayList<Msg> msg){
        for (int i=0; i<msg.size();i++){
            if (name.compareTo(msg.get(i).receiverName)==0)
                System.out.println(name+": "+msg.get(i).content);
        }
    }
    public void update(Object obj){
        if(obj instanceof  Watcher){
            Watcher sp = (Watcher) obj;
            checkMsg(sp.getState());
        }
    }

}


