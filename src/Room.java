
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lamon
 */
public class Room {

    // constants for directions
    public static final int N = 0;
    public static final int E = 1;
    public static final int S = 2;
    public static final int W = 3;

    // instance variables
    private String name;
    private BufferedImage image;
    private boolean[] canMove;
    private String[] moveName;

    public Room(Scanner input) {
        // get a room name
        this.name = input.nextLine();
        // load image file
        try{
            String filename = "images/" + this.name + ".gif";
            this.image = ImageIO.read(new File(filename));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        // initialize arrays
        this.canMove = new boolean[4];
        this.moveName = new String[4];

        // for each direction, Scan in the info
        for (int i = 0; i < this.canMove.length; i++) {
            // get direction
            String direction = input.next();
            // can move
            boolean move = input.nextBoolean();
            // scan in room name
            String nextRoomName = input.nextLine().trim();

            // switch case for direction
            switch (direction) {
                case "N":
                    this.canMove[Room.N] = move;
                    this.moveName[Room.N] = nextRoomName;
                    break;
                case "E":
                    this.canMove[Room.E] = move;
                    this.moveName[Room.E] = nextRoomName;
                    break;
                case "S":
                    this.canMove[Room.S] = move;
                    this.moveName[Room.S] = nextRoomName;
                    break;
                case "W":
                    this.canMove[Room.W] = move;
                    this.moveName[Room.W] = nextRoomName;
                    break;
            }
        }
    }
    
    public String getName(){
        return this.name;
    }
    
    public BufferedImage getImage(){
        return this.image;
    }
    
    public boolean canMove(int direction){
        return this.canMove[direction];
    }
    
    public String getNextRoomName(int direction){
        return this.moveName[direction];
    }
    
}
