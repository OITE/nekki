package com.example.winternote.nekki;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

/**
 * Created by WinterNote on 2015/06/21.
 * ゲームの進行をするクラス
 */
public class Game {

    //コンテキスト
    private Context context;

    //リソース
    private Resources resource;

    //背景画像
    private Bitmap background = null;

    //ターン数
    private int turn;


    //コンストラクタ
    public Game(Context context){
        this.context = context;
        this.resource = this.context.getResources();
        turn = 0;
    }

    //処理
    public void run(){

    }

    //描画
    public void draw(Canvas canvas){
        this.drawBackground(canvas);
    }

    //背景画像の描画
    private void drawBackground(Canvas canvas){
        //背景画像が未ロードならロードする
        if(background==null){
            background = BitmapFactory.decodeResource(resource, R.drawable.background);
            background = Bitmap.createScaledBitmap(background,MainActivity.Size.x,MainActivity.Size.y,false);
        }
        //背景画像を描画する
        canvas.drawBitmap(background,0,0,null);
    }

}
