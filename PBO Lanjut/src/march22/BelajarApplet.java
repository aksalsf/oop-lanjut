/*
 * M3119004 - Aksal Syah Falah
 * */

package march22;

import java.awt.Color;  
import java.awt.Graphics;
import java.awt.Image;
import java.applet.Applet;  
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class BelajarApplet extends Applet implements KeyListener, Runnable {  
	Thread t;
  Image picture;
  int x, y;
  
  public void init() {  
    picture = getImage(getDocumentBase(),"gambar.png");
    x = 10;
    y = 10;
    addKeyListener(this);
  }  
    
  public void paint(Graphics g) {  
	g.fillOval(x,y,100,100);
    setBackground(Color.white);
    g.drawImage(picture, x, y, this);
  }

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	int key = e.getKeyCode();
	switch (key) {
	case KeyEvent.VK_RIGHT:showStatus("Kanan");
	x+=10;
	repaint();
	break;
	case KeyEvent.VK_LEFT:showStatus("Kiri");
	x-=10;
	repaint();
	break;
	case KeyEvent.VK_UP:showStatus("Atas");
	y-=10;
	repaint();
	break;
	case KeyEvent.VK_DOWN:showStatus("Bawah");
	y+=10;
	repaint();
	break;
	}
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
public void start()
{
t = new Thread(this);
t.start();
}

public void run()
{
  try
     {
     for(;;)
      {
               for(;;)
           {
                if(y == 120)
                    {
                     break;
                    }
   else if (x == 390)
       {
    x = 0;
    y = 0;
   repaint();
        }
            else
              {
                  y = y +3;
                  x = x +3;
                  Thread.sleep(100);
                repaint();
              }
               }
          for(;;)
             {
              if(y==0)
                  {
                       break;
                       }
              else if (x == 390)
          {
         x = 0;
         y = 0;
                repaint();
   }
   else
                {
       y = y-3;
              x = x +3;
              Thread.sleep(100);
               repaint();
              }
               } 
           run();
      }
 }

catch(InterruptedException e)
   {

   }
}
}  