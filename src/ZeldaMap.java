
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lamon
 */
public class ZeldaMap {

    private ArrayList<Room> rooms;
    private Room currentRoom;
    
    public ZeldaMap(String filename){
        this.rooms = new ArrayList<>();
        
        Scanner input = null;
        try{
            input = new Scanner(new File(filename));
        }catch(Exception e){
            // print out red error message
            e.printStackTrace();
        }
        // get current room name
        String currentRoomName = input.nextLine();
        // if there are rooms left, create them
        while(input.hasNext()){
            // make the room
            Room r = new Room(input);
            // add to list
            this.rooms.add(r);
        }
        
        // set the current room
        this.currentRoom = findRoom(currentRoomName);
    }
    
    private Room findRoom(String name){
        for(Room r: this.rooms){
            // compare room names
            // if they are the same
            if(r.getName().equals(name)){
                return r;
            }
        }
        // room not found
        return null;
    }
    
    public boolean canMove(int direction){
        return this.currentRoom.canMove(direction);
    }
    
    public void move(int direction){
        if(canMove(direction)){
            String newRoomName = this.currentRoom.getNextRoomName(direction);
            this.currentRoom = findRoom(newRoomName);
        }
    }
    
    public BufferedImage getImage(){
        return this.currentRoom.getImage();
    }
    
}
