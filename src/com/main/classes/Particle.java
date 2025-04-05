package com.main.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Objects;
import java.util.Random;

public class Particle {
    private int x, y, width, height, speed = 2, lifeSpan = 255;

    public Particle() {
        Random r = new Random();
        this.x = (int) (Math.random() * 500);
        this.y = r.nextInt(0, 500);
        this.width = r.nextInt(10, 20);
        this.height = r.nextInt(10, 20);
        this.speed = r.nextInt(1, 2);
    }

    public int getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(int lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public void update() {
        this.y += this.speed;
        if (this.y > 600) {
            Random r = new Random();
            this.x = (int) (Math.random() * 500);
            this.y = r.nextInt(0, 500);
            this.width = r.nextInt(10, 20);
            this.height = r.nextInt(10, 20);
            this.speed = r.nextInt(1, 2);
            this.lifeSpan = 255; // Reset lifespan when particle resets
        }

        // Gradually decrease lifespan
        if (this.lifeSpan > 0) {
            this.lifeSpan -= 5; // Decrease alpha value
        }
    }

    public void render1(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int alpha = Math.max(this.lifeSpan, 0); // Ensure alpha is not negative
        g2d.setColor(new Color(alpha, alpha, alpha)); // Gradually fade to black
        g2d.fillRect(this.x, this.y, this.width, this.height);
        g2d.rotate(45 * Math.PI / 180);
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int alpha = Math.max(this.lifeSpan, 0); // Ensure alpha is not negative
        g2d.setColor(new Color(alpha, alpha, alpha)); // Gradually fade to black
        g2d.fillRect(this.x, this.y, this.width, this.height);
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Particle speed(int speed) {
        setSpeed(speed);
        return this;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Particle x(int x) {
        setX(x);
        return this;
    }

    public Particle y(int y) {
        setY(y);
        return this;
    }

    public Particle width(int width) {
        setWidth(width);
        return this;
    }

    public Particle height(int height) {
        setHeight(height);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Particle)) {
            return false;
        }
        Particle particle = (Particle) o;
        return x == particle.x && y == particle.y && width == particle.width && height == particle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, width, height);
    }

    @Override
    public String toString() {
        return "{" +
                " x='" + getX() + "'" +
                ", y='" + getY() + "'" +
                ", width='" + getWidth() + "'" +
                ", height='" + getHeight() + "'" +
                "}";
    }

}
