package com.bomesmo.joguinho;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Lucas on 27/03/2018.
 */

public class GameView extends View implements View.OnTouchListener{

    private Player player;
    private Paint mPaint;
    private Rect character;

    public GameView(Context context) {
        super(context);
        player = new Player();
        mPaint = new Paint();
        character = new Rect();
        setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        mPaint.setColor(Color.BLACK);

        //creates a 80x80 square
        character.set(
                (int)player.getPosX() - 40,
                (int)player.getPosY() - 40,
                ((int)player.getPosX() + 40),
                ((int)player.getPosY()) + 40);
        canvas.drawRect(character, mPaint);
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (character.contains((int)event.getX(), (int)event.getY())){
            if (event.getAction() == MotionEvent.ACTION_MOVE){
                player.update(event.getX(), event.getY());
                invalidate();
            }
        }

        if (event.getAction() == MotionEvent.ACTION_UP){
            Toast.makeText(getContext(), player.toString(), Toast.LENGTH_SHORT).show();
        }

//        Toast.makeText(getContext(), getPlayer().toString(), Toast.LENGTH_SHORT).show();

        return true;
    }
}
