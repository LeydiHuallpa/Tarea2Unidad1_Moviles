package com.example.tarea2_leydihuallpa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class PlayList extends AppCompatActivity {

    private Button b1,b2,b3,b4;
    private MediaPlayer mediaPlayer;
    private double startTime =0;
    private double finalTime =0;
    private  Handler myHandler = new Handler();
    private SeekBar seekBar;
    private TextView txt1, txt2, txt3;
    int canciones[]={
            R.raw.a,
            R.raw.b,
            R.raw.c,
            R.raw.d,
            R.raw.e};
    String can[]={"a.mp3", "b.mp3", "c.mp3", "d.mp3", "e.mp3"};
    int index=0;
    public static int oneTimeOnly=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);
        b1= (Button) findViewById(R.id.button);
        b2= (Button) findViewById(R.id.button2);
        b3= (Button) findViewById(R.id.button3);
        b4= (Button) findViewById(R.id.button4);
        txt1=(TextView) findViewById(R.id.textView2);
        txt2=(TextView) findViewById(R.id.textView3);
        txt3=(TextView) findViewById(R.id.textView4);
        txt3.setText(can[index]);
        mediaPlayer=MediaPlayer.create(this, canciones[index]);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                finalTime=mediaPlayer.getDuration();
                startTime=mediaPlayer.getCurrentPosition();
                if (oneTimeOnly==0){
                    seekBar.setMax((int) finalTime);
                    oneTimeOnly=1;
                }
                txt2.setText(String.format("%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finalTime)-
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                        finalTime))));

                txt1.setText(String.format("%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) startTime)-
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                        startTime))));

                seekBar.setProgress((int)startTime);
                myHandler.postDelayed(UpdateSongTime, 100);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });
        //adelante
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                if(index>4)index=0;
                mediaPlayer.stop();
                mediaPlayer=MediaPlayer.create(getApplication(), canciones[index]);
                finalTime=mediaPlayer.getDuration();
                startTime=mediaPlayer.getCurrentPosition();
                txt3.setText(can[index]);
            }
        });
        //atras
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index--;
                if(index<0)index=4;
                mediaPlayer.stop();
                mediaPlayer=MediaPlayer.create(getApplication(), canciones[index]);
                finalTime=mediaPlayer.getDuration();
                startTime=mediaPlayer.getCurrentPosition();
                txt3.setText(can[index]);
            }
        });
    }

    private Runnable UpdateSongTime = new Runnable() {
        @Override
        public void run() {
            startTime=mediaPlayer.getCurrentPosition();
            txt1.setText(String.format("%d:%d",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime)-
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                    startTime))));

            seekBar.setProgress((int)startTime);
            myHandler.postDelayed(UpdateSongTime, 100);
        }
    };
}

