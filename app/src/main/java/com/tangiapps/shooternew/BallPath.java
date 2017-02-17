package com.tangiapps.shooternew;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;

import static com.tangiapps.shooternew.ApplicationView.cX;
import static com.tangiapps.shooternew.ApplicationView.cY;
import static com.tangiapps.shooternew.ApplicationView.displayW;

/**
 * Created by PC-T3 on 2/13/2017.
 */

public class BallPath {
    Bitmap ball=LoadImage.ballImg[3];

//    public void setBall(Bitmap ball) {
//        this.ball = ball;
//    }

    boolean flag;
    double slope1;
    int y,x=cX;
    int xb=cX,yb=cY;
    ArrayList<Point> amama=new ArrayList<Point>();


    void balldraw(Canvas c,double slope,boolean vv){
        slope1=slope;
        flag=vv;

        c.drawBitmap(ball,cX-ball.getWidth()/2,cY-ball.getHeight()/2,null);
        if (flag){
          y=  pointL(x,xb+ball.getWidth()/2,yb+ball.getHeight()/2,slope1);
            c.drawBitmap(ball,xb+ball.getWidth()/2,yb+ball.getHeight()/2,null);
            xb--;
            yb=y;
            if ((xb+ball.getWidth()/2)<0){
                flag=false;
                slope1*=-1;
            }
        }
        else{
            y=  pointR(x,xb,yb,slope1);
            c.drawBitmap(ball,xb+ball.getWidth()/2,yb+ball.getHeight()/2,null);
            xb++;
            yb=y;
            if ((xb+ball.getWidth()/2)<displayW){
                flag=true;
                slope1*=-1;
            }
        }
    }

//x1- cord of x at which y is to be found
    private int pointL(int x1,int xStsart, int yStart, double slope){
        // flag=false;
        int y11= (int) ((slope*(x1-xStsart))+yStart);
        return y11;
    }
    @Contract(pure = true)
    private int pointR(int x1,int xStsart, int yStart, double slope){
        // flag=true;
        int y11= (int) ((slope*(x1 - xStsart))+yStart);
        return y11;
    }



    //___________________________________________________________________________________________________________________________________________________
    void collision(Rect ball,Rect lvl){
        PointF c1;PointF c2;
        float speed=0;
        c1=new PointF();
        c2=new PointF();
        c1.x=ball.exactCenterX();
        c1.y=ball.exactCenterY();
        c2.x=lvl.exactCenterX();
        c2.y=lvl.exactCenterY();
        //LineC.distanceCalc();
        speed++;


    }
}