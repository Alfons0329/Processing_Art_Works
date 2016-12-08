//need vars
int cx,cy;
float secondsRadius;
float minutesRadius;
float hoursRadius;
float clockDiameter;
float clockRadius;
void setup()
{
  size(500,500);
  noStroke();
  clockRadius=min(width,height)/2;
  hoursRadius=clockRadius*0.48;
  minutesRadius=clockRadius*0.68;
  secondsRadius=clockRadius*0.78;
  
  
  clockDiameter=clockRadius*2.0;

  cx=width/2;
  cy=height/2;
}

void draw()
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
    float x=cx+clockRadius*0.9*(cos(angle));
    float y=cy+clockRadius*0.9*(sin(angle));
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
    case(0):{stroke(#AA0000);  arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(1):{stroke(#CC0000);  arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(2):{stroke(#FF0000);  arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(3):{stroke(#FF3333);  arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(4):{stroke(#E63F00);  arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(5):{stroke(#FF5511);  arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(6):{stroke(#FF7744);  arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(7):{stroke(#EE7700);  arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(8):{stroke(#FF8800);  arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(9):{stroke(#FFAA33);  arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(10):{stroke(#DDAA00); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(11):{stroke(#FFBB00); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(12):{stroke(#FFCC22); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(13):{stroke(#EEEE00); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(14):{stroke(#FFFF00); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(15):{stroke(#FFEE33); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(16):{stroke(#99DD00); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(17):{stroke(#BBFF00); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(18):{stroke(#CCFF33); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(19):{stroke(#66DD00); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(20):{stroke(#77FF00); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(21):{stroke(#99FF33); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(22):{stroke(#00DD00); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(23):{stroke(#00FF00); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(24):{stroke(#33FF33); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(25):{stroke(#00DD77); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(26):{stroke(#00FF99); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(27):{stroke(#33FFAA); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(28):{stroke(#00DDAA); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(29):{stroke(#00FFCC); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(30):{stroke(#33FFDD); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(31):{stroke(#00DDDD); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(32):{stroke(#00FFFF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(33):{stroke(#33FFFF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(34):{stroke(#009FCC); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(35):{stroke(#00BBFF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(36):{stroke(#33CCFF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(37):{stroke(#0044BB); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(38):{stroke(#0066FF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(39):{stroke(#5599FF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(40):{stroke(#0000CC); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(41):{stroke(#0000FF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(42):{stroke(#5555FF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(43):{stroke(#4400CC); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(44):{stroke(#5500FF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(45):{stroke(#7744FF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(46):{stroke(#5500DD); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(47):{stroke(#7700FF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(48):{stroke(#9955FF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(49):{stroke(#7700BB); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(50):{stroke(#9900FF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(51):{stroke(#B94FFF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(52):{stroke(#A500CC); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(53):{stroke(#CC00FF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(54):{stroke(#B94FFF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(55):{stroke(#CC00CC); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(56):{stroke(#FF00FF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(57):{stroke(#FF3EFF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(58):{stroke(#FF77FF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
    case(59):{stroke(#FFB3FF); arc(250,250,clockRadius*1.6,clockRadius*1.6,-HALF_PI,sec_in_rad); break;}
  }
  //arc(250,250,clockRadius,clockRadius,0,PI);
  
  //2.------------minutes in rainbow------------------------------------------------------
  strokeWeight(20); //select the srtoke weight for second(thinnest)
  switch(minute())
  {
    case(0):{stroke(#AA0000);  arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(1):{stroke(#CC0000);  arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(2):{stroke(#FF0000);  arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(3):{stroke(#FF3333);  arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(4):{stroke(#E63F00);  arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(5):{stroke(#FF5511);  arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(6):{stroke(#FF7744);  arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(7):{stroke(#EE7700);  arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(8):{stroke(#FF8800);  arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(9):{stroke(#FFAA33);  arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(10):{stroke(#DDAA00); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(11):{stroke(#FFBB00); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(12):{stroke(#FFCC22); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(13):{stroke(#EEEE00); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(14):{stroke(#FFFF00); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(15):{stroke(#FFEE33); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(16):{stroke(#99DD00); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(17):{stroke(#BBFF00); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(18):{stroke(#CCFF33); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(19):{stroke(#66DD00); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(20):{stroke(#77FF00); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(21):{stroke(#99FF33); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(22):{stroke(#00DD00); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(23):{stroke(#00FF00); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(24):{stroke(#33FF33); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(25):{stroke(#00DD77); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(26):{stroke(#00FF99); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(27):{stroke(#33FFAA); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(28):{stroke(#00DDAA); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(29):{stroke(#00FFCC); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(30):{stroke(#33FFDD); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(31):{stroke(#00DDDD); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(32):{stroke(#00FFFF); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(33):{stroke(#33FFFF); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(34):{stroke(#009FCC); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(35):{stroke(#00BBFF); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(36):{stroke(#33CCFF); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(37):{stroke(#0044BB); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(38):{stroke(#0066FF); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(39):{stroke(#5599FF); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(40):{stroke(#0000CC); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(41):{stroke(#0000FF); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(42):{stroke(#5555FF); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(43):{stroke(#4400CC); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(44):{stroke(#5500FF); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(45):{stroke(#7744FF); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(46):{stroke(#5500DD); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(47):{stroke(#7700FF); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(48):{stroke(#9955FF); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(49):{stroke(#7700BB); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(50):{stroke(#9900FF); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(51):{stroke(#B94FFF); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(52):{stroke(#A500CC); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(53):{stroke(#CC00FF); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(54):{stroke(#B94FFF); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(55):{stroke(#CC00CC); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(56):{stroke(#FF00FF); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(57):{stroke(#FF3EFF); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(58):{stroke(#FF77FF); arc(250,250,clockRadius*1.4,clockRadius*1.4,-HALF_PI,min_in_rad); break;}
    case(59):{clear(); break;}
  }
  
  //3.---------Hours in window
  strokeWeight(20); //select the srtoke weight for second(thinnest)
  switch(hour())
  {
    case(0):{stroke(#AA0000);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(1):{stroke(#FF8800);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(2):{stroke(#FFDD55);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(3):{stroke(#BBFF00);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(4):{stroke(#66DD00);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(5):{stroke(#227700);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(6):{stroke(#00DD77);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(7):{stroke(#00FFCC);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(8):{stroke(#33FFFF);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(9):{stroke(#CCEEFF);  arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(10):{stroke(#5555FF); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(11):{stroke(#0000FF); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(12):{stroke(#9955FF); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(13):{stroke(#B94FFF); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(14):{stroke(#E38FFF); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(15):{stroke(#FF3EFF); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(16):{stroke(#FF00FF); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(17):{stroke(#CC00CC); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(18):{stroke(#FF88C2); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(19):{stroke(#FF0000); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(20):{stroke(#AA0000); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(21):{stroke(#FF8800); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(22):{stroke(#FFDD55); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(23):{stroke(#BBFF00); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    case(24):{stroke(#66DD00); arc(250,250,clockRadius*1,clockRadius*1,-HALF_PI,hour_in_rad); break;}
    
  }
  
  
  //Hand of clock with polar coordinate
  stroke(255);
  strokeWeight(2);
  line(cx, cy, cx + cos(sec_in_rad) * secondsRadius, cy + sin(sec_in_rad) * secondsRadius);
  stroke(#33FFFF);
  strokeWeight(4);
  line(cx, cy, cx + cos(min_in_rad) * minutesRadius, cy + sin(min_in_rad) * minutesRadius);
  stroke(255,255,0);
  strokeWeight(6);
  line(cx, cy, cx + cos(hour_in_rad) * hoursRadius, cy + sin(hour_in_rad) * hoursRadius);
}