import java.awt.*;
import java.awt.event.*;
import java.applet.*;


public class TwoButtons extends Applet {
	   Button butn1 = new Button("Btn 1"), //created 2 buttons
	           butn2 = new Button("Btn 2");
	    Label lab = new Label("My Label");

	    public void init() {
	        butn1.addActionListener(new Butn1Handler());
	        butn2.addActionListener(new Butn2Handler());
		//add buttons to be visibile in applet
	        this.add(butn1);  //'this' refers to this applet
	    	add(butn2);   //but is not necessary
		add(lab);
	    }

	    class Butn1Handler implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            lab.setText("BUTN-1");
	        }
	    }

	    class Butn2Handler implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            lab.setText("BUTN-2");
	        }
	     }
}
