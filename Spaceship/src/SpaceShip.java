//*************************************************************
//  Spaceship.java       Author: Casey Proud
//	CS 111B
//  Draws a spaceship that fires lasers in random directions, and counts it's shots.

//  Declare class's variables
// +init loads class into system & further sets up program mousehandler, sounds, and settings
// +paint graphics and update shotCounter
// +set up mouse movement listener to track spaceship
// +set up mouse click listener to trigger laser, sound, and shotCounter
//*************************************************************

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;

public class SpaceShip extends Applet {

	private final int APPLET_WIDTH = 500;
	   private final int APPLET_HEIGHT = 500;
	   
	   private Point point1 = null;
	   private Point point3 = null;
	   AudioClip soundFile1; 
//	   boolean soundOn = false; //Related to Sound on/off toggle; couldn't figure this part out
	   public int shotCounter = 0;
	   
	   //--------------------------------------------------------
	   //  Initialize listeners for all mouse related events.
	   //--------------------------------------------------------
	   public void init()
	   {
		  addMouseListener (new MouseHandler());
	      addMouseMotionListener (new MouseMotionHandler());

	      setBackground (Color.black);
	      setSize (APPLET_WIDTH, APPLET_HEIGHT);
	      
//	      if (soundOn == true) //Related to Sound on/off toggle; couldn't figure this part out
	      soundFile1 = getAudioClip(getCodeBase(),"Pew_Pew-DKnight556-1379997159.wav"); 
//	      else if (soundOn == false) //Related to Sound on/off toggle; couldn't figure this part out
//	    	  soundFile1 = null;//Related to Sound on/off toggle; couldn't figure this part out
	      init2();
	   }
	 
	   //--------------------------------------------------------
	   //  Paints graphics based on the current position of the mouse
	   //   and if mouse is clicked
	   //--------------------------------------------------------
	   public void paint (Graphics page)
	   {		    
	      if (point3 != null){
	    page.setColor (Color.green);
	    page.fillOval (point3.x, point3.y, 20, 10);
	    page.setColor (Color.red);
	    page.fillOval (point3.x - 15, point3.y + 5, 50, 20);
	    page.setColor (Color.white);
	    page.drawLine (point3.x - 5, point3.y + 20, point3.x - 15, point3.y + 35);
	    page.drawLine (point3.x + 20, point3.y + 20, point3.x + 30, point3.y + 35);
	      }
	      
		    if (point1 != null){
		    	int targetx = (int) (Math.random() * (400) - 200);
		    	int targety = (int) (Math.random() * (400) - 200);		    

		    		shotCounter++;
		    		soundFile1.play();
		    		
		    		switch (shotCounter % 4){
		    		case 0: page.setColor (Color.green); 
			    	break;
			    	case 1: page.setColor (Color.red); 
			    	break;
			    	case 2: page.setColor (Color.blue); 
			    	break;
			    	case 3: page.setColor (Color.yellow); 
			    	break; 
		    		
		    		}
		    		
		    	page.drawLine (point1.x + 3, point1.y, point1.x + targetx, point1.y + targety);
		    	 
	    	}
		    page.setColor (Color.white); 
		    page.drawString ("Shot Counter: " + shotCounter, 50, 50);
	   }

	    //--------------------------------------------------------
	    // MouseMotionHandler is an inner class listening for mouse 
	    // motion events
	    //--------------------------------------------------------
	   private class MouseMotionHandler implements MouseMotionListener
	   {
		
		public void mouseDragged (MouseEvent event)	{}
		
		public void mouseMoved (MouseEvent event) {
			
			point3 = event.getPoint();
			repaint();
	  		}
	    }
	   
		//-----------------------------------------------------
		//  Provide empty definitions for unused event methods.
	   	//-----------------------------------------------------
	   
	   public void mouseEntered (MouseEvent event) {}
	   	public void mouseExited (MouseEvent event) {}
	   	
	   	private class MouseHandler implements MouseListener
		   {
			//--------------------------------------------------
		   	//  Captures the position at which the mouse is pushed.
		   	//---------------------------------------------------
			public void mousePressed (MouseEvent event)
		   	{	      								
				point1 = event.getPoint();
				repaint(); 		
		   	}
			public void mouseReleased (MouseEvent event) {
		   		point1 = null;
		   	}
			
		   	//-----------------------------------------------------
			//  Provide empty definitions for unused event methods.
		   	//-----------------------------------------------------
		   	public void mouseClicked (MouseEvent event) {}	   	
		   	public void mouseEntered (MouseEvent event) {}
		   	public void mouseExited (MouseEvent event) {}
		   }	   	
	   	
	   	Button butn = new Button("Clear");
//	   	Button butn2 = new Button("Toggle Sound"); //Related to Sound on/off toggle; couldn't figure this part out
	   	
	
		   public void init2() {
		        butn.addActionListener(new ButnHandler());
//		        butn2.addActionListener(new ButnHandler2()); //Related to Sound on/off toggle; couldn't figure this part out
			    this.add(butn); 
//		        this.add(butn2); //Related to Sound on/off toggle; couldn't figure this part out
		    }

		    class ButnHandler implements ActionListener {
		        public void actionPerformed(ActionEvent e) {
		            shotCounter = 0;
		        } 
		    }    
/*		        
	        class ButnHandler2 implements ActionListener { //Related to Sound on/off toggle; couldn't figure this part out
		        public void actionPerformed(ActionEvent e) {
		            
		        }  
		        
		}  
*/   	
}
