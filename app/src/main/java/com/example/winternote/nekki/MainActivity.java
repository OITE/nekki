package com.example.winternote.nekki;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;


public class MainActivity extends Activity {

    //ゲーム画面
    GameSurfaceView surfaceView ;

    //画面サイズ
    static Point Size ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //画面サイズの計算
        calcSize();

        //ゲーム画面の初期化
        surfaceView = new GameSurfaceView(this);

        //ゲーム画面の表示
        setContentView(surfaceView);
    }

    //画面サイズ計算
    private void calcSize(){
        Size = new Point(0,0);
        this.getWindowManager().getDefaultDisplay().getSize(this.Size);
    }

}
