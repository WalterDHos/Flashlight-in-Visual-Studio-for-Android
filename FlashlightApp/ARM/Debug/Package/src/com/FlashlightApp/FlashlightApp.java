
package com.FlashlightApp;

import android.app.Activity;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;

import android.os.Bundle;

public class FlashlightApp extends Activity
{
    private CameraManager cameraManager;
    private String getCameraID;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //This portion of the code creates the button and sets its properties
        Button button = new Button (this);
        button.setBackgroundColor(Color.RED);
        button.setTextColor(Color.GREEN);
        button.setText("Flashlighttest by Walter Hoskins");
        setContentView(button);
        // This portion of code initializes the flashlight on your device and then gets the ID
        cameraManager = (CameraManager) getSystemService(FlashlightApp.CAMERA_SERVICE);
        try 
        {
	        getCameraID = cameraManager.getCameraIdList()[0];
        } 
        catch (CameraAccessException e) 
        {
	    e.printStackTrace();
        }

         button.setOnClickListener(new View.OnClickListener() // Checks for when any button is clicked
        {
            int i = 2;// Used for button logic
            public void onClick(View button) // Checks for when the button called "button" is clicked
            {
                if(i%2 == 0) // When button is pressed
                {
                    button.setBackgroundColor(Color.BLACK); // Sets background color to black
                    i++;
                    // This portion of code is for setting the camera on
                    try 
                    {
                        cameraManager.setTorchMode(getCameraID, false); // Sets flashlight off
                    } 
                    catch (CameraAccessException e) 
                    {
                        e.printStackTrace();
                    }

                }
                else // When button is pressed again
                {
                    button.setBackgroundColor(Color.WHITE); // Sets background color to white
                    i++;
                    // This portion of code is for seting the camera on
                    try 
                    {
                        cameraManager.setTorchMode(getCameraID, true); // Sets flashlight on 
                    } 
                    catch (CameraAccessException e) 
                    {
                        e.printStackTrace();
                    }

                }
            }
        });
    }
}


