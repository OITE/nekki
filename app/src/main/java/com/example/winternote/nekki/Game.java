package com.example.winternote.nekki;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

/**
 * Created by WinterNote on 2015/06/21.
 * �Q�[���̐i�s������N���X
 */
public class Game {

    //�R���e�L�X�g
    private Context context;

    //���\�[�X
    private Resources resource;

    //�w�i�摜
    private Bitmap background = null;

    //�^�[����
    private int turn;


    //�R���X�g���N�^
    public Game(Context context){
        this.context = context;
        this.resource = this.context.getResources();
        turn = 0;
    }

    //����
    public void run(){

    }

    //�`��
    public void draw(Canvas canvas){
        this.drawBackground(canvas);
    }

    //�w�i�摜�̕`��
    private void drawBackground(Canvas canvas){
        //�w�i�摜�������[�h�Ȃ烍�[�h����
        if(background==null){
            background = BitmapFactory.decodeResource(resource, R.drawable.background);
            background = Bitmap.createScaledBitmap(background,MainActivity.Size.x,MainActivity.Size.y,false);
        }
        //�w�i�摜��`�悷��
        canvas.drawBitmap(background,0,0,null);
    }

}
