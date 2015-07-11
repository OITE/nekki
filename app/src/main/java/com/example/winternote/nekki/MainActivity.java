package com.example.winternote.nekki;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;


public class MainActivity extends Activity {

    //�Q�[�����
    GameSurfaceView surfaceView ;

    //��ʃT�C�Y
    static Point Size ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //��ʃT�C�Y�̌v�Z
        calcSize();

        //�Q�[����ʂ̏�����
        surfaceView = new GameSurfaceView(this);

        //�Q�[����ʂ̕\��
        setContentView(surfaceView);
    }

    //��ʃT�C�Y�v�Z
    private void calcSize(){
        Size = new Point(0,0);
        this.getWindowManager().getDefaultDisplay().getSize(this.Size);
    }

}
