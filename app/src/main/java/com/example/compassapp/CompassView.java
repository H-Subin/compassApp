package com.example.compassapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CompassView extends View {
    public int azimuth;
    Bitmap bitmap;

    public CompassView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.compass);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int cx = getWidth()/2; //cx = center x
        int cy = getHeight()/2; //cy = center y  -> 이미지가 중앙에 들어가야하므로 중심좌표를 알기 위해서

        int x0 = cx - bitmap.getWidth()/2;
        int y0 = cy - bitmap.getHeight()/2;

        canvas.rotate(-azimuth,cx,cy); // ->폰이 돌아가는 방향과 반대로 돌아야하기 때문에
        canvas.drawBitmap(bitmap, x0, y0, null);
    }
}
