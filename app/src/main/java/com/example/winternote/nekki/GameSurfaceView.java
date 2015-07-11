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

    //サーフェスホルダー
    SurfaceHolder surfaceHolder;
    //スレッド
    Thread thread;
    //スクリーンのサイズ
    int screen_width,screen_height;
    //ゲームのインスタンス
    Game game ;


    //コンストラクタ
    public GameSurfaceView(Context context){
        super(context);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        game = new Game(context);
    }

    //ゲーム画面の進行
    @Override
    public void run() {

        //描画の準備
        Canvas canvas = null;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);

        //FPSの準備
        long loopCount = 0;
        long waitTime = 0;
        long startTime = System.currentTimeMillis();

        //メインループ
        while (thread != null) {

            try {
                //描画・FPSの前処理
                loopCount++;
                canvas = surfaceHolder.lockCanvas();

                //-----処理開始-----//

                game.run();
                game.draw(canvas);

                //-----処理終了-----//

                //描画・FPSの後処理
                surfaceHolder.unlockCanvasAndPost(canvas);
                waitTime = (loopCount * FRAME_TIME) - (System.currentTimeMillis() - startTime);
                if (waitTime > 0) Thread.sleep(waitTime);

            } catch (Exception e) { /* キャッチ */ }

        }

    }

    //ゲーム画面変化時の処理
    @Override
     public void surfaceChanged(SurfaceHolder holder,int format,int width,int height){
        screen_width=width;
        screen_height=height;
    }

    //ゲーム画面作成時の処理
    @Override
    public void surfaceCreated(SurfaceHolder holder){
        thread = new Thread(this);
        thread.start();
    }

    //ゲーム画面破棄時の処理
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        thread = null;
    }
}
