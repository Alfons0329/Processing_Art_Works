import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Analog_Clock_main extends PApplet {

//need vars
int cx,cy;
float secondsRadius;
float minutesRadius;
float hoursRadius;
float clockDiameter;
float clockRadius;
public void setup()
{
  
  noStroke();
  clockRadius=min(width,height)/2;
  hoursRadius=clockRadius*0.48f;
  minutesRadius=clockRadius*0.68f;
  secondsRadius=clockRadius*0.78f;
  
  
  clockDiameter=clockRadius*2.0f;

  cx=width/2;
  cy=height/2;
}

public void draw()
{
  //black background (Grey 0~255)
  background(0);
  //choose the watch color, grey background (Grey 0~255)
  //draw the main circle
  fill(50); 
  noStroke();//wothout border line
  ellipse(cx,cy,clockDiameter,clockDiameter);
  
  
  //end the task of such
  //Draw the 12 dots like ROLEX XD
  stroke(255); //Center White dot
  strokeWeight(8);
  point(250,250);
  
  
  //Draw the 12 dots like real watch XD
  beginShape(POINTS); //Directly draw a point according to strokeWeright 5
  for(int i=0;i<360;i+=6)
  {
    float angle=radians(i); //a conversion
    //Polar coordinate conversion (Polar to x,y in Cartesian)
    float x=cx+clockRadius*0.9f*(cos(angle));
    float y=cy+clockRadius*0.9f*(sin(angle));
    if(i%30==0)
    {
      stroke(255,255,0);
      strokeWeight(15);
    }
    else
    {
      stroke(255);
      strokeWeight(8);
    }
    vertex(x,y);
  }
  endShape();
  
  
  //angle from 3'oclock since there is 0PI , and use map functinon to convert R(int)->R(rad in polar coordinate)
  // Angles for sin() and cos() start at 3 o'clock;
  // subtract HALF_PI to make them start at the top , norm is used to normalize the lower-level time for carry-on
  //adjust the graph

  
  
  float sec_in_rad = map(second(), 0, 60, 0, TWO_PI) - HALF_PI;
  float min_in_rad = map(minute() + norm(second(), 0, 60), 0, 60, 0, TWO_PI) - HALF_PI; 
  float hour_in_rad = map(hour() + norm(minute(), 0, 60), 0, 24, 0, TWO_PI*2) - HALF_PI; 
  
  
  
  
  //Draw clock with time-dependent colour change
  strokeWeight(20); //select the srtoke weight for second(thinnest)
  noFill();
  //1.-----second in rainbow----------------------------------------------------------------------------------------------
  switch(second())
  {
    case(0):{stroke(0xffAA0000);  arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(1):{stroke(0xffCC0000);  arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(2):{stroke(0xffFF0000);  arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(3):{stroke(0xffFF3333);  arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(4):{stroke(0xffE63F00);  arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(5):{stroke(0xffFF5511);  arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(6):{stroke(0xffFF7744);  arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(7):{stroke(0xffEE7700);  arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(8):{stroke(0xffFF8800);  arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(9):{stroke(0xffFFAA33);  arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(10):{stroke(0xffDDAA00); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(11):{stroke(0xffFFBB00); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(12):{stroke(0xffFFCC22); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(13):{stroke(0xffEEEE00); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(14):{stroke(0xffFFFF00); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(15):{stroke(0xffFFEE33); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(16):{stroke(0xff99DD00); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(17):{stroke(0xffBBFF00); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(18):{stroke(0xffCCFF33); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(19):{stroke(0xff66DD00); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(20):{stroke(0xff77FF00); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(21):{stroke(0xff99FF33); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(22):{stroke(0xff00DD00); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(23):{stroke(0xff00FF00); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(24):{stroke(0xff33FF33); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(25):{stroke(0xff00DD77); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(26):{stroke(0xff00FF99); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(27):{stroke(0xff33FFAA); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(28):{stroke(0xff00DDAA); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(29):{stroke(0xff00FFCC); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(30):{stroke(0xff33FFDD); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(31):{stroke(0xff00DDDD); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(32):{stroke(0xff00FFFF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(33):{stroke(0xff33FFFF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(34):{stroke(0xff009FCC); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(35):{stroke(0xff00BBFF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(36):{stroke(0xff33CCFF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(37):{stroke(0xff0044BB); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(38):{stroke(0xff0066FF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(39):{stroke(0xff5599FF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(40):{stroke(0xff0000CC); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(41):{stroke(0xff0000FF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(42):{stroke(0xff5555FF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(43):{stroke(0xff4400CC); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(44):{stroke(0xff5500FF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(45):{stroke(0xff7744FF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(46):{stroke(0xff5500DD); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(47):{stroke(0xff7700FF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(48):{stroke(0xff9955FF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(49):{stroke(0xff7700BB); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(50):{stroke(0xff9900FF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(51):{stroke(0xffB94FFF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(52):{stroke(0xffA500CC); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(53):{stroke(0xffCC00FF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(54):{stroke(0xffB94FFF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(55):{stroke(0xffCC00CC); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(56):{stroke(0xffFF00FF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(57):{stroke(0xffFF3EFF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(58):{stroke(0xffFF77FF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
    case(59):{stroke(0xffFFB3FF); arc(250,250,clockRadius*1.6f,clockRadius*1.6f,-HALF_PI,sec_in_rad); break;}
  }
  //arc(250,250,clockRadius,clockRadius,0,PI);
  
  //2.------------minutes in rainbow------------------------------------------------------
  strokeWeight(20); //select the srtoke weight for second(thinnest)
  switch(minute())
  {
    case(0):{stroke(0xffAA0000);  arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(1):{stroke(0xffCC0000);  arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(2):{stroke(0xffFF0000);  arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(3):{stroke(0xffFF3333);  arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(4):{stroke(0xffE63F00);  arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(5):{stroke(0xffFF5511);  arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(6):{stroke(0xffFF7744);  arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(7):{stroke(0xffEE7700);  arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(8):{stroke(0xffFF8800);  arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(9):{stroke(0xffFFAA33);  arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(10):{stroke(0xffDDAA00); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(11):{stroke(0xffFFBB00); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(12):{stroke(0xffFFCC22); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(13):{stroke(0xffEEEE00); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(14):{stroke(0xffFFFF00); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(15):{stroke(0xffFFEE33); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(16):{stroke(0xff99DD00); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(17):{stroke(0xffBBFF00); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(18):{stroke(0xffCCFF33); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(19):{stroke(0xff66DD00); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(20):{stroke(0xff77FF00); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(21):{stroke(0xff99FF33); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(22):{stroke(0xff00DD00); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(23):{stroke(0xff00FF00); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(24):{stroke(0xff33FF33); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(25):{stroke(0xff00DD77); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(26):{stroke(0xff00FF99); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(27):{stroke(0xff33FFAA); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(28):{stroke(0xff00DDAA); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(29):{stroke(0xff00FFCC); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(30):{stroke(0xff33FFDD); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(31):{stroke(0xff00DDDD); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(32):{stroke(0xff00FFFF); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(33):{stroke(0xff33FFFF); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(34):{stroke(0xff009FCC); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(35):{stroke(0xff00BBFF); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(36):{stroke(0xff33CCFF); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(37):{stroke(0xff0044BB); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(38):{stroke(0xff0066FF); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(39):{stroke(0xff5599FF); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(40):{stroke(0xff0000CC); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(41):{stroke(0xff0000FF); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(42):{stroke(0xff5555FF); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(43):{stroke(0xff4400CC); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(44):{stroke(0xff5500FF); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(45):{stroke(0xff7744FF); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(46):{stroke(0xff5500DD); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(47):{stroke(0xff7700FF); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(48):{stroke(0xff9955FF); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(49):{stroke(0xff7700BB); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(50):{stroke(0xff9900FF); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(51):{stroke(0xffB94FFF); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(52):{stroke(0xffA500CC); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(53):{stroke(0xffCC00FF); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(54):{stroke(0xffB94FFF); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(55):{stroke(0xffCC00CC); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(56):{stroke(0xffFF00FF); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(57):{stroke(0xffFF3EFF); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(58):{stroke(0xffFF77FF); arc(250,250,clockRadius*1.4f,clockRadius*1.4f,-HALF_PI,min_in_rad); break;}
    case(59):{clear(); break;}
  }
  
  //3.---------Hours in window
  strokeWeight(20); //select the srtoke weight for second(thinnest)
  switch(hour())
  {
    case(0):{stroke(0xffAA0000);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(1):{stroke(0xffFF8800);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(2):{stroke(0xffFFDD55);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(3):{stroke(0xffBBFF00);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(4):{stroke(0xff66DD00);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(5):{stroke(0xff227700);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(6):{stroke(0xff00DD77);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(7):{stroke(0xff00FFCC);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(8):{stroke(0xff33FFFF);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(9):{stroke(0xffCCEEFF);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(10):{stroke(0xff5555FF); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(11):{stroke(0xff0000FF); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(12):{stroke(0xff9955FF); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(13):{stroke(0xffB94FFF); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(14):{stroke(0xffE38FFF); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(15):{stroke(0xffFF3EFF); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(16):{stroke(0xffFF00FF); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(17):{stroke(0xffCC00CC); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(18):{stroke(0xffFF88C2); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(19):{stroke(0xffFF0000); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(20):{stroke(0xffAA0000); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(21):{stroke(0xffFF8800); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(22):{stroke(0xffFFDD55); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(23):{stroke(0xffBBFF00); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(24):{stroke(0xff66DD00); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    
  }
  
  
  //Hand of clock with polar coordinate
  stroke(255);
  strokeWeight(2);
  line(cx, cy, cx + cos(sec_in_rad) * secondsRadius, cy + sin(sec_in_rad) * secondsRadius);
  stroke(0xff33FFFF);
  strokeWeight(4);
  line(cx, cy, cx + cos(min_in_rad) * minutesRadius, cy + sin(min_in_rad) * minutesRadius);
  stroke(255,255,0);
  strokeWeight(6);
  line(cx, cy, cx + cos(hour_in_rad) * hoursRadius, cy + sin(hour_in_rad) * hoursRadius);
}
  public void settings() {  size(500,500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Analog_Clock_main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
