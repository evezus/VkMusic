package vne.vkmusic.utils;

import android.util.Log;

/**
 * Created by evezus on 19.12.2015.
 */
public class Duration {

    public static String secondsToTimer(long milliseconds){
        String finalTimerString = "";
        String secondsString = "";

        int hours = (int)( milliseconds / (60*60));
        int minutes = (int)(milliseconds % (60*60)) / (60);
        int seconds = (int) ((milliseconds % (60*60)) % (60));
        if(hours > 0) finalTimerString = hours + ":";

        if(seconds < 10)
            secondsString = "0" + seconds;
        else
            secondsString = "" + seconds;

        finalTimerString = finalTimerString + minutes + ":" + secondsString;
        Log.d("time",finalTimerString);
        return finalTimerString;
    }

    public static String milliSecondsToTimer(long milliseconds){
        String finalTimerString = "";
        String secondsString = "";

        int hours = (int)( milliseconds / (1000*60*60));
        int minutes = (int)(milliseconds % (1000*60*60)) / (1000*60);
        int seconds = (int) ((milliseconds % (1000*60*60)) % (1000*60) / 1000);
        if(hours > 0) finalTimerString = hours + ":";

        if(seconds < 10)
            secondsString = "0" + seconds;
        else
            secondsString = "" + seconds;

        finalTimerString = finalTimerString + minutes + ":" + secondsString;
        Log.d("time",finalTimerString);
        return finalTimerString;
    }

    public static int getProgressPercentage(long currentDuration, long totalDuration){
        Double percentage = (double) 0;

        long currentSeconds = (int) (currentDuration / 1000);
        long totalSeconds = (int) (totalDuration / 1000);

        percentage =(((double)currentSeconds)/totalSeconds)*100;

        return percentage.intValue();
    }

    public static int progressToTimer(int progress, int totalDuration) {
        int currentDuration = 0;
        totalDuration = (int) (totalDuration / 1000);
        currentDuration = (int) ((((double)progress) / 100) * totalDuration);
        return currentDuration * 1000;
    }
}
