package com.example.winternote.nekki;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by WinterNote on 2015/06/21.
 *
 */
public class GameSurfaceView extends SurfaceView implements Runnable,SurfaceHolder.Callback{

    //FPS
    static final long FPS = 20;
    static final long FRAME_TIME = 1000/FPS;

    //�T�[�t�F�X�z���_�[
    SurfaceHolder surfaceHolder;
    //�X���b�h
    Thread thread;
    //�X�N���[���̃T�C�Y
    int screen_width,screen_height;
    //�Q�[���̃C���X�^���X
    Game game ;


    //�R���X�g���N�^
    public GameSurfaceView(Context context){
        super(context);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        game = new Game(context);
    }

    //�Q�[����ʂ̐i�s
    @Override
    public void run() {

        //�`��̏���
        Canvas canvas = null;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);

        //FPS�̏���
        long loopCount = 0;
        long waitTime = 0;
        long startTime = System.currentTimeMillis();

        //���C�����[�v
        while (thread != null) {

            try {
                //�`��EFPS�̑O����
                loopCount++;
                canvas = surfaceHolder.lockCanvas();

                //-----�����J�n-----//

                game.run();
                game.draw(canvas);

                //-----�����I��-----//

                //�`��EFPS�̌㏈��
                surfaceHolder.unlockCanvasAndPost(canvas);
                waitTime = (loopCount * FRAME_TIME) - (System.currentTimeMillis() - startTime);
                if (waitTime > 0) Thread.sleep(waitTime);

            } catch (Exception e) { /* �L���b�` */ }

        }

    }

    //�Q�[����ʕω����̏���
    @Override
     public void surfaceChanged(SurfaceHolder holder,int format,int width,int height){
        screen_width=width;
        screen_height=height;
    }

    //�Q�[����ʍ쐬���̏���
    @Override
    public void surfaceCreated(SurfaceHolder holder){
        thread = new Thread(this);
        thread.start();
    }

    //�Q�[����ʔj�����̏���
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        thread = null;
    }
}
