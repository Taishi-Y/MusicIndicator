package com.taishi.library;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yamasakitaishi on 2017/05/25.
 *
 * @author Taishi Yamasaki ( https://github.com/Taishi-Y )
 */

public class Indicator extends View {

	private Paint paint;
	private int stepNum = 10;

	private int duration = 3000;
	private int barNum = 3;
	private int barColor = 0xff000000;

	private int viewHeight;
	private int viewWidth;

	private List<ValueAnimator> animList;

	public Indicator(Context context) {
		super(context);
	}

	public Indicator(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);

		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Indicator, 0, 0);
		try {
			barNum = ta.getInt(R.styleable.Indicator_bar_num, 3);
			stepNum = ta.getInt(R.styleable.Indicator_step_num, 10);
			duration = ta.getInt(R.styleable.Indicator_duration, 3000);
			barColor = ta.getColor(R.styleable.Indicator_bar_color, 0xff000000);
		} finally {
			ta.recycle();
		}
	}

	public Indicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);

		List<Float> floatList = getGraduateFloatList(stepNum, viewHeight);
		generateAnim(floatList, barNum);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		paint = new Paint();
		paint.setColor(barColor);

		drawIndicator(canvas, barNum);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		viewWidth = MeasureSpec.getSize(widthMeasureSpec);
		viewHeight = MeasureSpec.getSize(heightMeasureSpec);
		this.setMeasuredDimension(viewWidth, viewHeight);

		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	// 1割ずつの数列を作る
	private List<Float> getGraduateFloatList(int arraySize, int max) {
		List<Float> floatList = new ArrayList();
		double dividedMax = max / arraySize;

		for(int i=1; i <= arraySize; i++){
			double a = i * dividedMax;
			floatList.add((float) a);
		}
		floatList.set(floatList.size()-1, floatList.get(0));

		return floatList;
	}

	private void generateAnim(List<Float> floatList, int barNum) {

		animList = new ArrayList<>();

		for (int i = 0; i < barNum; i++) {

			Collections.shuffle(floatList);
			floatList.set(floatList.size() - 1, floatList.get(0));

			float[] floatArray = new float[floatList.size()];
			int j = 0;
			for (Float f : floatList) {
				floatArray[j++] = (f != null ? f : Float.NaN);
			}

			ValueAnimator anim = new ValueAnimator();
			anim = ValueAnimator.ofFloat(floatArray);
			anim.setDuration(duration);
			anim.setRepeatCount(ValueAnimator.INFINITE);
			anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
				@Override
				public void onAnimationUpdate(ValueAnimator animation) {
					invalidate();
				}
			});
			anim.start();

			animList.add(anim);
		}
	}


	private void drawIndicator(Canvas canvas, int barNum) {

		// 一本あたりのすきま
		double spaceWidth = canvas.getWidth() * 0.2 / (barNum-1);
		// 一本のふとさ
		double barWidth = canvas.getWidth() * 0.8 / barNum;

		double sumWidth = spaceWidth + barWidth;

		for (int i=0; i<barNum - 1; i++) {
			float height = (Float) (animList.get(i).getAnimatedValue());

			canvas.drawRect(
					(float) (i*sumWidth), // left
					canvas.getHeight() - height,//height, // top
					(float) (i*sumWidth + barWidth), // right
					canvas.getHeight(), // bottom
					paint // Paint
			);

			if (i == barNum - 2) {
				float heightLast = (Float) (animList.get(i+1).getAnimatedValue());
				canvas.drawRect(
						(float) ((i+1)*sumWidth), // left
						canvas.getHeight() - heightLast,//height, // top
						(float) ((i+1)*sumWidth + barWidth), // right
						canvas.getHeight(), // bottom
						paint // Paint
				);
			}
		}
	}

	public void setStepNum(int stepNum) {
		this.stepNum = stepNum;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setBarNum(int barNum) {
		this.barNum = barNum;
	}

	public void setBarColor(int barColor) {
		this.barColor = barColor;
	}
}
