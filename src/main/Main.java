package main;

import entities.Player;
import render.Camera;
import render.RenderableObject;
import render.WalkingObject;
import util.SpriteSheet;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Main extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    private MainFrame frame;
    private Thread thread;
    private boolean isRunning;

    public static final int WIDTH = 160;
    public static final int HEIGHT = 160;
    private final int SCALE = 3;

    public static List<RenderableObject> entities;
    public static SpriteSheet spriteSheet;
    public static Player player;

    private static World world;

    private Main() {
        addKeyListener(new KeyboardControl());
        setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
        frame = new MainFrame(this);
        //inicializando objetos.
        entities = new ArrayList<>();
        spriteSheet = new SpriteSheet("/SpriteSheet.png");
        player = new Player(0, 0, 16, 16);
        entities.add(player);
        world = new World("/TileMap.png");
    }

    private synchronized void start() {
        thread = new Thread(this);
        isRunning = true;
        thread.start();
        if(isRunning) {
            System.out.println("Está rodando!");
        }
    }

    public synchronized void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    private void move() {
        for(int i = 0; i < entities.size(); i++) {
            RenderableObject renderableObject = entities.get(i);
            if (renderableObject instanceof WalkingObject) {
                WalkingObject walkingObject = (WalkingObject) renderableObject;
                walkingObject.move();
            }
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.black);
        g.fillRect(0,0, WIDTH, HEIGHT);

        world.render(g);

        for(int i = 0; i < entities.size(); i++) {
            RenderableObject renderableObject = entities.get(i);
            renderableObject.render(g);
        }

        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
        bs.show();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int frames = 0;
        double timer = System.currentTimeMillis();

        requestFocus();

        while(isRunning) {
            long now = System.nanoTime();
            delta+= (now - lastTime) / ns;
            lastTime = now;

            if(delta >= 1) {
                move();
                render();
                Camera.moveCamera(player.getX(), player.getY());
                frames++;
                delta--;
            }

            if(System.currentTimeMillis() - timer >= 1000) {
                System.out.println("FPS: "+ frames);
                frames = 0;
                timer+=1000;
            }

        }
        stop();
    }
}
