package com.dodgeball.game.objects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.dodgeball.game.utils.World;

/**
 * Created by samuel on 6/13/16.
 */
public class Bullet extends DynamicGameObject{
    World world;
    public final int SPEED = 1400;
    public static final int BULLET_WIDTH = 13;
    public static final int BULLET_HEIGHT = 54;
    public int timer =0;

    public Bullet(float x, float y,float rotation, World world){

        super(x,y,BULLET_WIDTH,BULLET_HEIGHT);
        velocity.x=world.mathUtils.sinDeg(rotation)*SPEED;
        velocity.y=world.mathUtils.cosDeg(rotation)*SPEED;
        this.world = world;
        this.rotation = 360-rotation;

    }
    public void update(float deltaTime){
        position.add(velocity.x*deltaTime*world.speed, velocity.y*deltaTime*world.speed,0);
        bounds.setPosition(position.x, position.y);
        bounds.setRotation(rotation);

        timer++;
    }
    public boolean isColliding(Polygon target){
        return Intersector.overlapConvexPolygons(this.bounds,target);
    }
}
