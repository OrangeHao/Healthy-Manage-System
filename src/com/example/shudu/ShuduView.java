package com.example.shudu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.view.View;

public class ShuduView extends View{

	private float width;
	private float heigth;
	
	private GameData game=new GameData();
	
	public ShuduView(Context context) {
		 super(context);
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		
		this.width=w/9f;
		this.heigth=h/9f;
		
		super.onSizeChanged(w, h, oldw, oldh);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		
		//画背景	
		Paint backgroundPaint=new Paint();
		backgroundPaint.setColor(this.getResources().getColor(R.color.shudu_background));
		canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), backgroundPaint);
		
		
		Paint darkPaint=new Paint();
		darkPaint.setColor(this.getResources().getColor(R.color.shudu_dark));
		
		Paint hilitePaint = new Paint();  
        hilitePaint.setColor(this.getResources().getColor(R.color.shudu_hilite));  
          
        Paint lightPaint = new Paint();  
        lightPaint.setColor(this.getResources().getColor(R.color.shudu_light));
        
        //画白色的线
        for (int i = 0; i < 9; i++) {
			canvas.drawLine(0, i*heigth, this.getWidth(), i*heigth, lightPaint);
			canvas.drawLine(0, i*heigth+1, this.getWidth(), i*heigth+1, hilitePaint);
			
			canvas.drawLine(i*width, 0, i*width, this.getHeight(), lightPaint);
			canvas.drawLine(i*width+1, 0, i*width+1, this.getHeight(), lightPaint);
		}
        
        //画黑色的线
        for (int i = 0; i < 9; i++) {
        	
        	if (i%3!=0) {
				continue;
			}
        	
			canvas.drawLine(0, i*heigth, this.getWidth(), i*heigth, darkPaint);
			canvas.drawLine(0, i*heigth+1, this.getWidth(), i*heigth+1, hilitePaint);
			
			canvas.drawLine(i*width, 0, i*width, this.getHeight(), darkPaint);
			canvas.drawLine(i*width+1, 0, i*width+1, this.getHeight(), lightPaint);
		}
        
        Paint numberPaint=new Paint();
        numberPaint.setColor(Color.BLACK);
        numberPaint.setStyle(Paint.Style.STROKE);
        numberPaint.setTextSize(heigth*0.75f);
        numberPaint.setTextAlign(Paint.Align.CENTER);
        
        
        FontMetrics fMetrics=numberPaint.getFontMetrics();
        float y=heigth/2f-(fMetrics.ascent+fMetrics.descent)/2;
		float x=width/2f;
		
		//初始化数独数据
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				canvas.drawText(game.getTitleString(i, j), i*width+x, j*heigth+y, numberPaint);
			}
		}
		
		super.onDraw(canvas);
	}

}
