package main;

import flappy.Window;
import jdk.swing.interop.SwingInterOpUtils;
import util.ShaderUtils;

public class Main implements Runnable {
    public Thread game;
    public static Window window;
    public static final int WIDTH = 1280, HEIGHT = 720;

    public void start() {
        game = new Thread(this,"game");
        game.start();
    }

    public static void init() {
        System.out.println("Starting the game!");

        window = new Window(WIDTH, HEIGHT, "Flappy");
        window.create();
    }
    public void run() {
        init();
        int shader = ShaderUtils.load("shaders/shader.vert", "shaders/shader.frag");
        while (!window.closed()) {
            update();
            render();
        }
    }
    private void update(){
        //System.out.println("Updating game!");
        window.update();
    }
    private void render(){
        //System.out.println("Rendering game!");
        window.swapBuffers();
    }

    public static void main(String[] args) {
        new Main().start();
    }
}
