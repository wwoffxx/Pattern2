package org.example.Camera;

public interface Subj {
    void Attach(CamObserver o);

    void Dettach(CamObserver o);
    void Notify();

}
