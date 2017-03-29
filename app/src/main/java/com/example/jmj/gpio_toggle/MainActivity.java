package com.example.jmj.gpio_toggle;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;


import net.calit2.mooc.iot_db410c.db410c_gpiolib.GpioProcessor;

public class MainActivity extends AppCompatActivity {

    private Button buttonPin24;
    private Button buttonPin30;
    private Button buttonPin32;
    private Button buttonPin34;
    private Button buttonPin23;
    private Button buttonPin27;
    private Button buttonPin29;
    private Button buttonPin31;
    private Button buttonPin33;

    boolean pin24 = false;
    boolean pin30 = false;
    boolean pin32 = false;
    boolean pin34 = false;
    boolean pin23 = false;
    boolean pin27 = false;
    boolean pin29 = false;
    boolean pin31 = false;
    boolean pin33 = false;

    private static boolean DRAGONBOARD_FLG = true;//false runs on the phone or simulator (do nothing on GPIO)

    GpioProcessor gpioProcessor = new GpioProcessor();

    GpioProcessor.Gpio led24 = gpioProcessor.getPin24();
    GpioProcessor.Gpio led30 = gpioProcessor.getPin30();
    GpioProcessor.Gpio led32 = gpioProcessor.getPin32();
    GpioProcessor.Gpio led34 = gpioProcessor.getPin34();
    GpioProcessor.Gpio led23 = gpioProcessor.getPin23();
    GpioProcessor.Gpio led27 = gpioProcessor.getPin27();
    GpioProcessor.Gpio led29 = gpioProcessor.getPin29();
    GpioProcessor.Gpio led31 = gpioProcessor.getPin31();
    GpioProcessor.Gpio led33 = gpioProcessor.getPin33();

    Uart1Access uart1Access = new Uart1Access();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("DRAGONBOARD MEZZANINE VersC GPIO Set/Reset v0.0");

        uart1Access.sendMessage("\n" + getTitle() + "\n");//send the hello message

        //initialise available pins
        if(DRAGONBOARD_FLG) {
            led24.out();
            led24.low();
            led30.out();
            led30.low();
            led32.out();
            led32.low();
            led34.out();
            led34.low();
            led23.out();
            led23.low();
            led27.out();
            led27.low();
            led29.out();
            led29.low();
            led31.out();
            led31.low();
            led33.out();
            led33.low();
        }

        // Initialize the pin button with a listener that click events
        buttonPin24 = (Button) findViewById(R.id.button_pin_24);

        buttonPin24.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonChangeState(24);
            }
        });

        buttonPin30 = (Button) findViewById(R.id.button_pin_30);

        buttonPin30.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonChangeState(30);
            }
        });

        buttonPin32 = (Button) findViewById(R.id.button_pin_32);

        buttonPin32.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonChangeState(32);
            }
        });

        buttonPin34 = (Button) findViewById(R.id.button_pin_34);

        buttonPin34.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonChangeState(34);
            }
        });

        buttonPin23 = (Button) findViewById(R.id.button_pin_23);

        buttonPin23.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonChangeState(23);
            }
        });

        buttonPin27 = (Button) findViewById(R.id.button_pin_27);

        buttonPin27.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonChangeState(27);
            }
        });

        buttonPin29 = (Button) findViewById(R.id.button_pin_29);

        buttonPin29.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonChangeState(29);
            }
        });

        buttonPin31 = (Button) findViewById(R.id.button_pin_31);

        buttonPin31.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonChangeState(31);
            }
        });

        buttonPin33 = (Button) findViewById(R.id.button_pin_33);

        buttonPin33.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonChangeState(33);
            }
        });

        try{
            Thread.sleep(500);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        buttonChangeState(34);
        try{
            Thread.sleep(500);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        buttonChangeState(34);

        new Thread(new Runnable() {
            @Override
            public void run(){

                while(true) {
                    uart1Access.sendMessage("hello");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //String message = uart1Access.readMessage();

                }

            }
        }).start();

    }


    private void buttonChangeState(int pin)
    {

        switch(pin) {

            case 24:
                if (!pin24) {
                    //Toast.makeText(this, "Pin 24 ON", Toast.LENGTH_SHORT).show();
                    pin24 = true;
                    buttonPin24.setTextColor(Color.WHITE);
                    buttonPin24.setBackgroundResource(R.drawable.roundedbutton_on);
                    if(DRAGONBOARD_FLG) led24.high();
                    uart1Access.sendMessage("pin " + pin + " ON\n");
                } else {
                    //Toast.makeText(this, "Pin 24 OFF", Toast.LENGTH_SHORT).show();
                    pin24 = false;
                    buttonPin24.setTextColor(Color.BLUE);
                    buttonPin24.setBackgroundResource(R.drawable.roundedbutton_off);
                    if(DRAGONBOARD_FLG) led24.low();
                    uart1Access.sendMessage("pin " + pin + " OFF\n");
                }
                break;

            case 30:
                if (!pin30) {
                    //Toast.makeText(this, "Pin 30 ON", Toast.LENGTH_SHORT).show();
                    pin30 = true;
                    buttonPin30.setTextColor(Color.WHITE);
                    buttonPin30.setBackgroundResource(R.drawable.roundedbutton_on);
                    if(DRAGONBOARD_FLG) led30.high();
                    uart1Access.sendMessage("pin " + pin + " ON\n");
                } else {
                    //Toast.makeText(this, "Pin 30 OFF", Toast.LENGTH_SHORT).show();
                    pin30 = false;
                    buttonPin30.setTextColor(Color.BLUE);
                    buttonPin30.setBackgroundResource(R.drawable.roundedbutton_off);
                    if(DRAGONBOARD_FLG) led30.low();
                    uart1Access.sendMessage("pin " + pin + " OFF\n");
                }
                break;

            case 32:
                if (!pin32) {
                    //Toast.makeText(this, "Pin 32 ON", Toast.LENGTH_SHORT).show();
                    pin32 = true;
                    buttonPin32.setTextColor(Color.WHITE);
                    buttonPin32.setBackgroundResource(R.drawable.roundedbutton_on);
                    if(DRAGONBOARD_FLG) led32.high();
                    uart1Access.sendMessage("pin " + pin + " ON\n");
            } else {
                    //Toast.makeText(this, "Pin 32 OFF", Toast.LENGTH_SHORT).show();
                    pin32 = false;
                    buttonPin32.setTextColor(Color.BLUE);
                    buttonPin32.setBackgroundResource(R.drawable.roundedbutton_off);
                    if(DRAGONBOARD_FLG) led32.low();
                    uart1Access.sendMessage("pin " + pin + " OFF\n");
            }
                break;

            case 34:
                if (!pin34) {
                    //Toast.makeText(this, "pin 34 ON", Toast.LENGTH_SHORT).show();
                    pin34 = true;
                    buttonPin34.setTextColor(Color.WHITE);
                    buttonPin34.setBackgroundResource(R.drawable.roundedbutton_on);
                    if(DRAGONBOARD_FLG) led34.high();
                    uart1Access.sendMessage("pin " + pin + " ON\n");
                } else {
                    //Toast.makeText(this, "pin 34 OFF", Toast.LENGTH_SHORT).show();
                    pin34 = false;
                    buttonPin34.setTextColor(Color.BLUE);
                    buttonPin34.setBackgroundResource(R.drawable.roundedbutton_off);
                    if(DRAGONBOARD_FLG) led34.low();
                    uart1Access.sendMessage("pin " + pin + " OFF\n");
                }
                break;

            case 23:
                if (!pin23) {
                    //Toast.makeText(this, "pin 23 ON", Toast.LENGTH_SHORT).show();
                    pin23 = true;
                    buttonPin23.setTextColor(Color.WHITE);
                    buttonPin23.setBackgroundResource(R.drawable.roundedbutton_on);
                    if(DRAGONBOARD_FLG) led23.high();
                    uart1Access.sendMessage("pin " + pin + " ON\n");
                } else {
                    //Toast.makeText(this, "pin 23 OFF", Toast.LENGTH_SHORT).show();
                    pin23 = false;
                    buttonPin23.setTextColor(Color.BLUE);
                    buttonPin23.setBackgroundResource(R.drawable.roundedbutton_off);
                    if(DRAGONBOARD_FLG) led23.low();
                    uart1Access.sendMessage("pin " + pin + " OFF\n");
                }
                break;

            case 27:
                if (!pin27) {
                    //Toast.makeText(this, "pin 27 ON", Toast.LENGTH_SHORT).show();
                    pin27 = true;
                    buttonPin27.setTextColor(Color.WHITE);
                    buttonPin27.setBackgroundResource(R.drawable.roundedbutton_on);
                    if(DRAGONBOARD_FLG) led27.high();
                    uart1Access.sendMessage("pin " + pin + " ON\n");
                } else {
                    //Toast.makeText(this, "pin 27 OFF", Toast.LENGTH_SHORT).show();
                    pin27 = false;
                    buttonPin27.setTextColor(Color.BLUE);
                    buttonPin27.setBackgroundResource(R.drawable.roundedbutton_off);
                    if(DRAGONBOARD_FLG) led27.low();
                    uart1Access.sendMessage("pin " + pin + " OFF\n");
                }
                break;

            case 29:
                if (!pin29) {
                    //Toast.makeText(this, "pin 29 ON", Toast.LENGTH_SHORT).show();
                    pin29 = true;
                    buttonPin29.setTextColor(Color.WHITE);
                    buttonPin29.setBackgroundResource(R.drawable.roundedbutton_on);
                    if(DRAGONBOARD_FLG) led29.high();
                    uart1Access.sendMessage("pin " + pin + " ON\n");
                } else {
                    //Toast.makeText(this, "pin 29 OFF", Toast.LENGTH_SHORT).show();
                    pin29 = false;
                    buttonPin29.setTextColor(Color.BLUE);
                    buttonPin29.setBackgroundResource(R.drawable.roundedbutton_off);
                    if(DRAGONBOARD_FLG) led29.low();
                    uart1Access.sendMessage("pin " + pin + " OFF\n");
                }
                break;

            case 31:
                if (!pin31) {
                    //Toast.makeText(this, "pin 31 ON", Toast.LENGTH_SHORT).show();
                    pin31 = true;
                    buttonPin31.setTextColor(Color.WHITE);
                    buttonPin31.setBackgroundResource(R.drawable.roundedbutton_on);
                    if(DRAGONBOARD_FLG) led31.high();
                    uart1Access.sendMessage("pin " + pin + " ON\n");
                } else {
                    //Toast.makeText(this, "pin 31 OFF", Toast.LENGTH_SHORT).show();
                    pin31 = false;
                    buttonPin31.setTextColor(Color.BLUE);
                    buttonPin31.setBackgroundResource(R.drawable.roundedbutton_off);
                    if(DRAGONBOARD_FLG) led31.low();
                    uart1Access.sendMessage("pin " + pin + " OFF\n");
                }
                break;

            case 33:
                if (!pin33) {
                    //Toast.makeText(this, "pin 33 ON", Toast.LENGTH_SHORT).show();
                    pin33 = true;
                    buttonPin33.setTextColor(Color.WHITE);
                    buttonPin33.setBackgroundResource(R.drawable.roundedbutton_on);
                    if(DRAGONBOARD_FLG) led33.high();
                    uart1Access.sendMessage("pin " + pin + " ON\n");
                } else {
                    //Toast.makeText(this, "pin 33 OFF", Toast.LENGTH_SHORT).show();
                    pin33 = false;
                    buttonPin33.setTextColor(Color.BLUE);
                    buttonPin33.setBackgroundResource(R.drawable.roundedbutton_off);
                    if(DRAGONBOARD_FLG) led33.low();
                    uart1Access.sendMessage("pin " + pin + " OFF\n");
                }
                break;

            default:


        }

    }
}



/*
        new Thread(new Runnable() {
            @Override
            public void run(){
                GpioProcessor gpioProcessor = new GpioProcessor();

                GpioProcessor.Gpio led = gpioProcessor.getPin32();
                led.out();
                led.low();

                for(int i = 0; i < 10; i++){
                    led.high();
                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    led.low();
                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        */