// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class lightSubsystem extends SubsystemBase {

  public AddressableLED led = new AddressableLED(9);;
  public AddressableLEDBuffer buffer = new AddressableLEDBuffer(48);

  /** Creates a new lightSystem. */
  //Önde 26 LED
  //Sağ ve sol 11
  public lightSubsystem() {
	led.setLength(buffer.getLength());
	led.setData(buffer);
	led.start();
  }

  @Override
  public void periodic() {
  }

  public void startLED() {
	for (var i = 0; i < buffer.getLength(); i++) {
	  buffer.setRGB(i, 255, 255, 0);
	  led.setData(buffer);
	  System.out.println("led geldii");
	}
  }

  public void stopLED() {
	for (var i = 0; i < buffer.getLength(); i++) {
	  buffer.setRGB(i, 0, 0, 0);
	  led.setData(buffer);
	}
  }
  public void frontLED(int red, int green, int blue){
	for (var i = 0; i <= 25; i++) {
	  buffer.setRGB(i, red, green, blue);
	}
	led.setData(buffer);
  }
  public void rightLED(int red, int green, int blue){
	for (var i = 26; i <= 36; i++) {
	  buffer.setRGB(i, red, green, blue);
	}
	led.setData(buffer);
  }
  public void leftLED(int red, int green, int blue){
	for (var i = 37; i < 48; i++) {
	  buffer.setRGB(i, red, green, blue);
	}
	led.setData(buffer);
  }
  public void rainbow(double delay){
	int c[];
	int i, j;
  
	for(j=0; j<256*5; j++) {
	  for(i=0; i< buffer.getLength(); i++) {
		c=Wheel(((i * 256 / buffer.getLength()) + j) & 255);
		buffer.setRGB(i, c[0], c[1], c[2]);
	  }
	  led.setData(buffer);
	  Timer.delay(delay);
	}
  }
  public int[] Wheel(int WheelPos) {
	int[] c = new int[3];
	if(WheelPos < 85) {
	 c[0]=WheelPos * 3;
	 c[1]=255 - WheelPos * 3;
	 c[2]=0;
	} else if(WheelPos < 170) {
	 WheelPos -= 85;
	 c[0]=255 - WheelPos * 3;
	 c[1]=0;
	 c[2]=WheelPos * 3;
	} else {
	 WheelPos -= 170;
	 c[0]=0;
	 c[1]=WheelPos * 3; 
	 c[2]=255 - WheelPos * 3;
	}
	return c;
  }
}
