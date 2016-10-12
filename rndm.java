
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class rndm implements ActionListener{
int randomNum;
JFrame ranm;
JLabel num;
JButton gen;

	public rndm(){
       ranm = new JFrame("Generate Random number");
       gen = new JButton("Generate");
       num = new  JLabel();
       
       ranm.setLayout(new FlowLayout());
       
       ranm.add(gen);
       ranm.add(num);
       
       ranm.setSize(600,600);
       ranm.setVisible(true);
       gen.addActionListener(this);
        
	}final Runnable tarea = new Runnable() {
		public void run() {
			randomNum = 1 + (int)(Math.random() * 10); 
	        System.out.println(randomNum);
			
		}
			};

	public void waiting(){
		
        ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
        timer.scheduleAtFixedRate(tarea, 900, 900, TimeUnit.MILLISECONDS);
	}
	public static void main(String[] args) {
		rndm obj=new  rndm();

	}
	
	public void actionPerformed(ActionEvent e) {
		waiting();
			
		
	}

}
