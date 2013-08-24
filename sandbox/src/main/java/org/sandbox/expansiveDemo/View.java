package org.sandbox.expansiveDemo;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.*;

// Calculate the movement of the camera.
// Here we ignore roll when moving.
public class View 
{
  //////////////// Variables /////////////////////////

  // Update RightVec is not used for correct movement,
  // as roll is ignored only rightVecProject is used.
  final boolean keepRightVecUpdated = false;
  final boolean enableRoll = true;
  // How to move and rotate the model or the camera.
  final boolean operatenOnModel = true;

  // Camera position.
  float camX = 0.0f;
  float camY = 0.0f;
  float camZ = 3.0f;

  // Camera angle in degree (0-360).
  float camPitch = 0.0f; // up-down
  float camHeading = 0.0f; // left-right
  float camRoll = 0.0f;

  // Vector in camera direction: look-at-vector
  float lookatVecX = 0f;
  float lookatVecY = 0f;
  float lookatVecZ = -1f;

  // Vector perpendicular to look-at-vecor
  float rightVecX = 1f;
  float rightVecY = 0f;
  float rightVecZ = 0f;

  // Normalized projection of the right vector 
  // on the X-Z-plane.
  // Used to change heading.
  float rightVecProjectX = 1f;
  float rightVecProjectY = 0f;
  float rightVecProjectZ = 0f;

  // Step velocity when moving the camera 
  // (relative to look at vec).
  final float dCam = 0.1f; // Translation.
  final float dCamAngle = 3.0f; // Rotation.

  // Sensibility to turning the camera with the mouse.
  final float factorMouseTurn = 0.05f;
  // Let the camera turn straight up automatically.
  final float rollDecay = 0.9f;

  ///////////////// Functions /////////////////////////

  public View()
    {
      calcRightVecProject();
      calcLookatVec();
      if( keepRightVecUpdated ) { calcRightVec(); }
    }

  void calcLookatVec()
    {
      float camHeadingRad = (float) Math.toRadians( camHeading );
      float camPitchRad = (float) Math.toRadians( camPitch );
      float cosPitch = (float) Math.cos( camPitchRad );
      //
      lookatVecX = (float) ( Math.sin(camHeadingRad) * cosPitch );
      lookatVecY = (float)   Math.sin( camPitchRad );
      lookatVecZ = (float) ( - Math.cos(camHeadingRad) * cosPitch );

      //printDebug();//ddd
    }

  void calcRightVec()
    {
      float camHeadingRad = (float) Math.toRadians( camHeading );
      float camRollRad = (float) Math.toRadians( camRoll );
      float cosRoll = (float) Math.cos( camRollRad );
      //
      rightVecX = (float) ( Math.cos( camHeadingRad ) * cosRoll );
      rightVecY = (float) Math.sin( camRollRad );
      rightVecZ = (float) ( Math.sin( camHeadingRad ) * cosRoll );

      //printDebug();//ddd
    }

  // Projection on the X-Z-Plane.
  // Roll is ignored.
  void calcRightVecProject()
    {
      float camHeadingRad = (float) Math.toRadians( camHeading );
      //float camRollRad = (float) Math.toRadians( camRoll );
      //
      rightVecProjectX = (float) Math.cos( camHeadingRad );
      rightVecProjectY = 0f;
      rightVecProjectZ = (float) Math.sin( camHeadingRad );

      //printDebug();//ddd
    }

  ////////// move - translation /////////////////////

  // Camera up and down is absolute, 
  // also if we do not look straight ahead.
  public void moveDown( float dist ) { moveUp( -dist ); }
  public void moveDown() { moveUp( -1f ); }
  public void moveUp() { moveUp( 1f ); }
  public void moveUp( float dist ) 
    { 
      camY += dist * dCam; 
    }

  // The following movements are relative to 
  // the vector where we lool at.
  public void moveLeft( float dist ) { moveRight( -dist ); }
  public void moveLeft() { moveRight( -1f ); }
  public void moveRight() { moveRight( 1f ); }
  public void moveRight( float dist)
    { 
      if( operatenOnModel ) { return; } // only zoom makes sense
      
      camX += dist * dCam * rightVecProjectX;
      //camY += 0; // Ignore roll.     
      camZ += dist * dCam * rightVecProjectZ;      
    }

  public void moveBack( float dist ) { moveFwd( -dist ); }
  public void moveBack() { moveFwd( -1f ); }
  public void moveFwd() { moveFwd( 1f ); }
  public void moveFwd( float dist )  
    { 
      if( operatenOnModel ) { camZ += dist * dCam; return; }

	camX += dist * dCam * lookatVecX;
	camY += dist * dCam * lookatVecY;
	camZ += dist * dCam * lookatVecZ;
    }

  ////////// look - rotation /////////////////////

  // Move should be negative to look down.
  public void lookDown( float angle ) { lookUp( -angle ); } 
  public void lookDown() { lookUp( -1f ); } 
  public void lookUp() { lookUp( 1f ); } 
  public void lookUp( float angle ) 
    { 
      camPitch += dCamAngle * angle * factorMouseTurn; 
      if( camPitch > 360 ) { camPitch -= 360; }
      if( camPitch < -360 ) { camPitch += 360; }

      calcLookatVec();
    }

  public void lookLeft( float angle ) { lookRight( -angle ); } 
  public void lookLeft() { lookRight( -1f ); } 
  public void lookRight() { lookRight( 1f ); } 
  public void lookRight( float angle ) 
    { 
      camHeading += dCamAngle * angle * factorMouseTurn; 
      if( camHeading > 360 ) { camHeading -= 360; }
      if( camHeading < -360 ) { camHeading += 360; }

      calcLookatVec();
      calcRightVecProject();
      if( keepRightVecUpdated ) { calcRightVec(); }
    }

  // Not used, not implemented properly, not tested.
  public void roll()    { camRoll += dCamAngle; }
  public void rollNeg() { camRoll -= dCamAngle; }
  public void decayRoll() { camRoll *= 0.9; }


  /////////////////// Set Current View ////////////////////
    
  public void setCamera( GL2 gl ) 
    {      
      if( operatenOnModel ) {
	gl.glTranslatef( -camX, -camY , -camZ ); 
      }

      gl.glRotatef( - camPitch, 1.0f, 0.0f, 0.0f );
      gl.glRotatef( camHeading, 0.0f, 1.0f, 0.0f );
      if( enableRoll ) {
	gl.glRotatef( camRoll,  0.0f, 0.0f, 1.0f ); 
	decayRoll(); 
      }
      // Camera is pointing in neg z-axis,
      // thus we have a neg sign when we step fwd.
      if( ! operatenOnModel ) {
	gl.glTranslatef( -camX, -camY , -camZ ); }


    }

  public void setCameraLookAt( GLU glu ) 
    {
      glu.gluLookAt( 
	camX, camY , camZ, // eye
	0.0f, 0.0f, 0.0f,  // center
	1.0f, 1.0f, 0.0f   // up
	);
    }

  //////////////////////////////////////////////////////

  public void printDebug()
    {

      System.out.println("\nDebug View:");

      System.out.println("camX:"+camX);
      System.out.println("camY:"+camY);
      System.out.println("camZ:"+camZ);
      System.out.println("--------------------");
      System.out.println("camPitch:"+camPitch);
      System.out.println("camHeading:"+camHeading);
      System.out.println("camRoll:"+camRoll);
      System.out.println("--------------------");
      System.out.println("lookatVecX:"+lookatVecX);
      System.out.println("lookatVecY:"+lookatVecY);
      System.out.println("lookatVecZ:"+lookatVecZ);
      System.out.println("--------------------");
      System.out.println("rightVecX:"+rightVecX);
      System.out.println("rightVecY:"+rightVecY);
      System.out.println("rightVecZ:"+rightVecZ);
      System.out.println("--------------------");
      System.out.println("rightVecProjectX:"+rightVecProjectX);
      System.out.println("rightVecProjectY:"+rightVecProjectY);
      System.out.println("rightVecProjectZ:"+rightVecProjectZ);
    }
}