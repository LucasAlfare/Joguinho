package com.bomesmo.joguinho;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Lucas on 27/03/2018.
 */

public class GameView extends View implements View.OnTouchListener{

    private Entity player, enemie;
    private Paint mPaint;
    private Rect playerChar, enemieChar;
    private Random r;

    int ra;
    int rb;

    public GameView(Context context) {
        super(context);

        mPaint = new Paint();

        player = new Player("player");
        enemie = new Enemie("enemie");

        playerChar = new Rect();
        enemieChar = new Rect();

        r = new Random();

        setOnTouchListener(this);

        ra = r.nextInt(300);
        rb = r.nextInt(300);
    }

    private void teste(){
        boolean top = r.nextBoolean();
        boolean right = r.nextBoolean();

        int a = top ? ((int) player.getX() - ra) - 40 : ((int) player.getX() - ra) + 40;
        int b = top ? ((int) player.getY() - rb) - 40 : ((int) player.getY() - rb) + 40;
        int c = right ? ((int) player.getX() - ra) - 40 : ((int) player.getX() - ra) + 40;
        int d = right ? ((int) player.getY() - rb) - 40 : ((int) player.getY() - rb) + 40;

        enemie.setX(enemieChar.centerX());
        enemie.setY(enemieChar.centerY());

        enemieChar.set(a, b, c, d);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        mPaint.setColor(Color.BLACK);

        drawEntity(player, canvas);
        drawEntity(enemie, canvas);
    }

    /*
   X
    |--------------|
    |              |
    |              |
    |              |
    |              |
    |              |
    |--------------|
                    X
     */
    private void drawEntity(Entity entity, Canvas canvas){
        if (entity.getName().equals("player")){
            mPaint.setColor(Color.BLACK);
            playerChar.set(
                    (int) player.getX() - 40,
                    (int) player.getY() - 40,
                    ((int) player.getX() + 40),
                    ((int) player.getY()) + 40);
            canvas.drawRect(playerChar, mPaint);
        } else {
            mPaint.setColor(Color.RED);
            canvas.drawRect(enemieChar, mPaint);
        }
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (playerChar.contains((int)event.getX(), (int)event.getY())){
            if (event.getAction() == MotionEvent.ACTION_MOVE){
                player.update(event.getX(), event.getY());

                boolean top = r.nextBoolean();
                boolean right = r.nextBoolean();

                if (!playerChar.contains(enemieChar)){
                    int a = top ? ((int) player.getX() - ra) - 40 : ((int) player.getX() - ra) + 40;
                    int b = top ? ((int) player.getY() - rb) - 40 : ((int) player.getY() - rb) + 40;
                    int c = right ? ((int) player.getX() - ra) - 40 : ((int) player.getX() - ra) + 40;
                    int d = right ? ((int) player.getY() - rb) - 40 : ((int) player.getY() - rb) + 40;

                    enemieChar.set(a, b, c, d);
                }

                enemie.setX(enemieChar.centerX());
                enemie.setY(enemieChar.centerY());

                invalidate();
            }
        }

        if (event.getAction() == MotionEvent.ACTION_UP){
            Toast.makeText(getContext(), player.toString(), Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}
