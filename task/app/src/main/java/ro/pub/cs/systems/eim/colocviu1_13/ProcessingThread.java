package ro.pub.cs.systems.eim.colocviu1_13;

import android.content.Context;
import android.content.Intent;

import java.util.Date;

public class ProcessingThread extends Thread {
    private Context context = null;
    private boolean isRunning = true;

    private String str;

    public ProcessingThread(Context context, String s) {
        this.context = context;
        str = s;
    }

    @Override
    public void run() {
        while (isRunning) {
            sendMessage();
            sleep();
        }
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.putExtra(Constants."broadcast_receiver",
                new Date(System.currentTimeMillis()) + " " str);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
}
