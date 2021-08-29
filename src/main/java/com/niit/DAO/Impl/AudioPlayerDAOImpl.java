package com.niit.DAO.Impl;

import com.niit.DAO.AudioPlayerDAO;
import com.niit.helper.MySqlConnection;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;


public class AudioPlayerDAOImpl implements AudioPlayerDAO {
    private Connection connection;

    Long currentFrame;
    Clip clip;

    // current status of clip
    String status;

    AudioInputStream audioInputStream;
      static String filePath;

    // constructor to initialize streams and clip
    public AudioPlayerDAOImpl(String sPath) throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        this.filePath=sPath;
        connection = MySqlConnection.getConnection();
        // create AudioInputStream object
        audioInputStream =
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);

    }

    @Override
    public void play() {
        //start the clip
        clip.start();

        status = "play";
    }

    @Override
    public void pause() {
        if (status.equals("paused"))
        {
            System.out.println("audio is already paused");
        }
        //it obtains the current position in the audio data ,in microposition
        this.currentFrame =
                this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    @Override
    public void resumeAudio() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        if (status.equals("play"))
        {
            System.out.println("Audio is already being played");
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }

    @Override
    public void restart()throws IOException, LineUnavailableException,
            UnsupportedAudioFileException {
        clip.stop();
        clip.close();
        resetAudioStream();
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        this.play();
    }

    @Override
    public void stop() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException{
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    @Override
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException,
            LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(
                new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
    }

    @Override
    public void gotoChoice(int c) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        switch (c)
        {
            case 1:
                pause();
                break;
            case 2:
                resumeAudio();
                break;
            case 3:
                restart();
                break;
            case 4:
                stop();
                break;


        }

    }
}
