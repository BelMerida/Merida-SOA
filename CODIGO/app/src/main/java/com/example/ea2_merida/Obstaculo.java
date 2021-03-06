package com.example.ea2_merida;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Obstaculo extends View{
    private boolean horizontal;
    private Bitmap bitmap;
    private Bitmap obstaculo;
    private int mHeigth;
    private int mWidth;
    private int divAlto;
    private int divAncho;
    private float posX;
    private float posY;
    Paint paint;

    public Obstaculo(Context context, float posX, float posY, int divAlto, int divAncho, boolean horizontal){
        super(context);
        this.posX = posX;
        this.posY = posY;
        this.horizontal = horizontal;
        this.divAlto = divAlto;
        this.divAncho = divAncho;

        if(horizontal)
            bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.obstaculo);
        else
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.obstaculo1);
    }

    public void onSizeChanged(int a, int b, int c, int d){
        mHeigth = getHeight() / divAlto;
        mWidth = getWidth() / divAncho;
        obstaculo = Bitmap.createScaledBitmap(bitmap, mWidth, mHeigth, true);
    }

    public float getPosY(){ return this.posY;}

    public float getPosX(){ return this.posX;}

    public int getmHeigth(){ return this.mHeigth;}

    public int getmWidth(){ return this.mWidth;}

    public void onDraw(Canvas canvas){
        canvas.drawBitmap(obstaculo, posX, posY, null);
        //canvas.drawCircle(posX,posY,50,paint);
    }

    public boolean existeObstaculo(float posX, float posY){
        if(posY >= this.posY && posY <= this.posY + this.mHeigth && posX >= this.posX && posX <= this.posX + mWidth)
            return true;
        return false;
    }

}
