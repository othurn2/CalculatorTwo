/*
   *
   *
   * Calculator Honors Project one.
   * Oliver Thurn
   * 5529694
   * Start date: 9/2
   * This will create a calculator that can add, subtract, multiply and divide, as well as squaring and working with negatives.
   * It will use buttons for each number and opperators and a text string to display the answers at the top of the screen.
   * The textView answerView will change the size it is displayed in for longer numbers. (if there are so many num make text smaller)
   *
   *
   */



package com.example.oliverthurn.calculatortwo;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Creating value holder variables
    protected double answerNumber = 0.0;
    protected double firstNumPressed;
    protected double secondNumPressed;
    protected String answerText = "0.0";
    protected int lastOpPressed;

    // If operator pressed bools
    protected boolean operatorPressed = false;
    protected Boolean plusPressed = false;
    protected Boolean subPressed = false;
    protected Boolean multPressed = false;
    protected Boolean divPressed = false;
    //protected Boolean clearPressed = false;
    protected Boolean sqPressed = false;
    protected Boolean negPressed = false;
    protected Boolean equalsPressed = false;

    // Creating answer view
    protected TextView answerView;

    // Creating all buttons starting with numbers then operators
    protected Button zeroButton;
    protected Button oneButton;
    protected Button twoButton;
    protected Button threeButton;
    protected Button fourButton;
    protected Button fiveButton;
    protected Button sixButton;
    protected Button sevenButton;
    protected Button eightButton;
    protected Button nineButton;

    // Operators
    protected Button plusButton;
    protected Button subButton;
    protected Button divButton;
    protected Button multButton;
    protected Button decButton;
    protected Button negButton;
    protected Button sqButton;
    protected Button clearButton;
    protected Button equalsButton;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Initializing protected variables when the app creates
        answerView = (TextView) findViewById(R.id.answerView);

        zeroButton = (Button) findViewById(R.id.zeroButton);
        oneButton = (Button) findViewById(R.id.oneButton);
        twoButton = (Button) findViewById(R.id.twoButton);
        threeButton = (Button) findViewById(R.id.threeButton);
        fourButton = (Button) findViewById(R.id.fourButton);
        fiveButton = (Button) findViewById(R.id.fiveButton);
        sixButton = (Button) findViewById(R.id.sixButton);
        sevenButton = (Button) findViewById(R.id.sevenButton);
        eightButton = (Button) findViewById(R.id.eightButton);
        nineButton = (Button) findViewById(R.id.nineButton);

        // Operators
        plusButton = (Button) findViewById(R.id.plusButton);
        subButton = (Button) findViewById(R.id.subButton);
        divButton = (Button) findViewById(R.id.divButton);
        multButton = (Button) findViewById(R.id.multButton);
        clearButton = (Button) findViewById(R.id.clearButton);
        negButton = (Button) findViewById(R.id.negButton);
        sqButton = (Button) findViewById(R.id.sqButton);
        decButton = (Button) findViewById(R.id.decButton);
        equalsButton = (Button) findViewById(R.id.equalsButton);


        answerView.setText(answerText);
        answerText = "";

        // Setting listeners for number and operator buttons
        zeroButton.setOnClickListener(this);
        oneButton.setOnClickListener(this);
        twoButton.setOnClickListener(this);
        threeButton.setOnClickListener(this);
        fourButton.setOnClickListener(this);
        fiveButton.setOnClickListener(this);
        sixButton.setOnClickListener(this);
        sevenButton.setOnClickListener(this);
        eightButton.setOnClickListener(this);
        nineButton.setOnClickListener(this);
        plusButton.setOnClickListener(this);
        subButton.setOnClickListener(this);
        divButton.setOnClickListener(this);
        multButton.setOnClickListener(this);
        decButton.setOnClickListener(this);
        negButton.setOnClickListener(this);
        sqButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
        answerView.setOnClickListener(this);
        equalsButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Log.i("Info: start of switch", "" + answerText);

        // use a switch statement for each button when clicked and manipulate the number variable accordingly.
        // need to create listeners for all the buttons and textFields when they are pressed. Variables to
        // hold the values and reset the values when the clear button is pressed. Think about the clear and
        // all clear features (hold the last number so you can just clear the one entered incorrectly.
        // need to use variables local to each case and then put them inside of the first and second numbers and then delete at end


        switch (view.getId()) {

            // Setting all the numbered buttons to show in the answerView
            case R.id.zeroButton:
                answerText = answerText + "0";
                answerView.setText(answerText);
                break;

            case R.id.oneButton:
                answerText = answerText + "1";
                answerView.setText(answerText);
                break;

            case R.id.twoButton:
                answerText = answerText + "2";
                answerView.setText(answerText);
                break;

            case R.id.threeButton:
                answerText = answerText + "3";
                answerView.setText(answerText);
                break;

            case R.id.fourButton:
                answerText = answerText + "4";
                answerView.setText(answerText);
                break;

            case R.id.fiveButton:
                answerText = answerText + "5";
                answerView.setText(answerText);
                break;

            case R.id.sixButton:
                answerText = answerText + "6";
                answerView.setText(answerText);
                break;

            case R.id.sevenButton:
                answerText = answerText + "7";
                answerView.setText(answerText);
                break;

            case R.id.eightButton:
                answerText = answerText + "8";
                answerView.setText(answerText);
                break;

            case R.id.nineButton:
                answerText = answerText + "9";
                answerView.setText(answerText);
                break;

            // Setting cases for all the operator buttons
            // Recognize if they button has already been pressed or not, combine answerText to the apropriate int
            // Preform the pressed operator
            // Need a way of preforming an operator on the answerNum after being used by another operator

    /************************** PLUS BUTTON  **************************/

            case R.id.plusButton:

                lastOpPressed = view.getId(); // set to the ID int for each op case

                Log.i("Info: lastOpPressed + ", Integer.toString(lastOpPressed));

                if (view.getId() == R.id.plusButton) { // only used to keep int a, b local to this case

                    Log.i("Info: answerText + = ", answerText);

                    if (answerText.contentEquals("")) { // prevents crash when op is pressed with empty value
                        Log.i("Info + : ", "there was an empty string when plus was pressed");
                        break;
                    }

                    if (!plusPressed) {

                        firstNumPressed = Double.parseDouble(answerText); // setting to the number in view
                        answerNumber += firstNumPressed;
                        Log.i("Info + : answerNumber", Double.toString(answerNumber)); // LOG PRINT
                        plusPressed = true;
                        answerText = Double.toString(answerNumber);
                        answerView.setText(answerText); // setting view
                        answerText = ""; // setting answertext back to empty
                        firstNumPressed = 0;
                        secondNumPressed = 0;

                        Log.i("Info + : first number", Double.toString(firstNumPressed)); // LOG PRINT
                        break;

                    } else if (plusPressed) {

                        if (answerText.contentEquals("")) { // prevents crash when op is pressed with empty value
                            Log.i("Info + : ", "there was an empty string when plus was pressed");
                            break;
                        }

                        secondNumPressed = Double.parseDouble(answerText); // using second holder to get the new value in the view
                        answerNumber += secondNumPressed; // answerNumber is now the value of parsed int by way of b -> secondNum -> answerNum
                        answerText = "" + Double.toString(answerNumber);
                        answerView.setText(answerText); // setting view to the new value of answerNumber
                        plusPressed = false;
                        answerText = "";
                        break;
                    }
                }
                break;

    /************************** SUBTRACTION BUTTON  **************************/

            case R.id.subButton:

                lastOpPressed = view.getId();
                Log.i("Info: lastOpPressed - ", Integer.toString(lastOpPressed));

                if(lastOpPressed == R.id.subButton) {

                    if (answerText.contentEquals("")) { // prevents crash if the view is empty
                        Log.i("Info -: minus empty", Double.toString(firstNumPressed));
                        break;
                    }

                    if (!subPressed) {

                        firstNumPressed = Double.parseDouble(answerText); // using the holder variable local to the if statement
                        answerNumber = firstNumPressed; // putting the firstNum into the answerNum no math being done
                        Log.i("Info: - answerNumber", "answerNum from firstNum" + answerNumber); // LOG PRINT
                        answerText = "" + Double.toString(answerNumber);
                        answerView.setText(answerText); // set the answerText above then changing the view
                        subPressed = true;
                        answerText = ""; // setting view text back to nothing
                        //firstNumPressed = 0;

                    } else if (subPressed){

                       secondNumPressed = Integer.parseInt(answerText); // using holder variable local to the if statement
                        answerNumber = answerNumber - secondNumPressed; // subtracting the second number from the answer number which should just be the first number
                        Log.i("Info: - answerNumber", "answerNum from secondNum" + answerNumber); // LOG PRINT
                        answerText = "" + Double.toString(answerNumber);
                        answerView.setText(answerText);
                        subPressed = false;
                        answerText = "";
                        //secondNumPressed = 0;
                    }
                }
                break;

    /************************** MULTIPLICATION BUTTON  **************************/

            case R.id.multButton:

                lastOpPressed = view.getId();

                if (answerText.contentEquals("")){
                    Log.i("Mult switch: ", "Mult pressed with empty string");
                    break;
                }

                Log.i("Info: lastOpPressed X ", Integer.toString(lastOpPressed));

                    if (!multPressed) {
                        firstNumPressed = Double.parseDouble(answerText);
                        answerNumber = firstNumPressed;
                        answerText = Double.toString(firstNumPressed);
                        answerView.setText(answerText);
                        answerText = "";
                        //answerView.setText(answerText);
                        multPressed = true;
                        //firstNumPressed = 0;

                    } else if (multPressed) {
                        secondNumPressed = Double.parseDouble(answerText);
                        answerNumber = firstNumPressed * secondNumPressed;
                        answerText = Double.toString(answerNumber);
                        answerView.setText(answerText);
                        answerText = "";
                        multPressed = false;
                    }
                break;

    /************************** DIVISION BUTTON  **************************/

            case R.id.divButton:
                lastOpPressed = view.getId();
                Log.i("Info: lastOpPressed / ", Integer.toString(lastOpPressed));

                if(answerText.contentEquals("")){
                    Log.i("Info: / ", "Divide pressed with empty string");
                    break;
                }

                if(!divPressed){

                    firstNumPressed = Double.parseDouble(answerText);
                    answerNumber = firstNumPressed;
                    answerText = Double.toString(answerNumber);
                    answerView.setText(answerText);
                    answerText = "";
                    divPressed = true;

                } else {

                    secondNumPressed = Double.parseDouble(answerText);
                    answerNumber = answerNumber / secondNumPressed;
                    answerText = Double.toString(answerNumber);
                    answerView.setText(answerText);
                    divPressed = false;
                    answerText = "";
                }
                break;

    /************************** NEG BUTTON  **************************/

            case R.id.negButton:
                lastOpPressed = view.getId();
                Log.i("Info: lastOp (-1) ", Integer.toString(lastOpPressed));
                answerNumber = Double.parseDouble(answerText);
                answerNumber = answerNumber * (-1);
                answerText = Double.toString(answerNumber);
                answerView.setText(answerText);
                operatorPressed = true;
                break;

    /************************** SQ BUTTON  **************************/

            case R.id.sqButton:
                lastOpPressed = view.getId();
                answerNumber = Double.parseDouble(answerText);
                answerNumber = answerNumber * answerNumber;
                answerText = Double.toString(answerNumber);
                answerView.setText(answerText);
                answerText = "";
                Log.i("Info: lastOpPressed ^2 ", Integer.toString(lastOpPressed));
                //operatorPressed = true;
                break;


            case R.id.decButton:
                lastOpPressed = view.getId();
                Log.i("Info: lastOpPressed . ", Integer.toString(lastOpPressed));
                operatorPressed = true;
                break;

    /************************** CLEAR BUTTON  **************************/

            case R.id.clearButton:

                // setting value variables back to zero setting operator booleans back to start up state setting answerView text back to zero
                firstNumPressed = 0;
                secondNumPressed = 0;
                answerNumber = 0;
                plusPressed = false;
                subPressed = false;
                multPressed = false;
                answerText = "";
                answerView.setText("0.0");
                break;

    /************************** EQUALS BUTTON  **************************/
            case R.id.equalsButton: // Could use if statements or switch for a one time click of an operator if !pluspressed sum the numbers
                operatorPressed = true;
                        // this is all working. but after pressing equals it still uses the answerNum for the next set of addition. Must set answerNum back to zero
                Log.i("Info: lastOpPressed", "" + lastOpPressed);
                switch(lastOpPressed){

                    case R.id.plusButton:

                        if(!plusPressed){

                            answerNumber += firstNumPressed;
                            answerText = Double.toString(answerNumber);
                            answerView.setText(answerText);
                            answerText = "";
                            //plusPressed = false;

                        } else if(plusPressed) {

                            secondNumPressed = Double.parseDouble(answerText);
                            answerNumber += secondNumPressed;
                            answerText = Double.toString(answerNumber);
                            answerView.setText(answerText);
                            answerText = "";
                            answerNumber = 0;
                        }
                        break;

                    case R.id.subButton:

                        if(subPressed){
                            secondNumPressed = Double.parseDouble(answerText);
                            answerNumber -= secondNumPressed;
                            answerText = Double.toString(answerNumber);
                            Log.i("equals sub answerText",answerText);
                            Log.i("equals sub answerNum", Double.toString(answerNumber));
                            answerView.setText(answerText);
                            //answerNumber = 0; // this makes it so the after you press equal and then go back into a subtraction operation it resets.
                            answerText = "";

                        } else if(!subPressed) {

                            firstNumPressed = Double.parseDouble(answerText);
                            answerNumber -= firstNumPressed;
                            answerText = Double.toString(answerNumber);
                            answerView.setText(answerText);
                        }
                        break;

                    case R.id.multButton:

                        if(multPressed){
                            secondNumPressed = Double.parseDouble(answerText);
                            answerNumber *= secondNumPressed;
                            answerText = Double.toString(answerNumber);
                            answerView.setText(answerText);

                        } else if(!multPressed){
                            firstNumPressed = Double.parseDouble(answerText);
                            answerNumber *= firstNumPressed;
                            answerText = Double.toString(answerNumber);
                            answerView.setText(answerText);

                        }
                        break;

                    case R.id.divButton:

                        if(divPressed){
                            secondNumPressed = Double.parseDouble(answerText);
                            answerNumber /= secondNumPressed;
                            answerText = Double.toString(answerNumber);
                            answerView.setText(answerText);
                        } else {
                            firstNumPressed = Double.parseDouble(answerText);
                            answerNumber /= firstNumPressed;
                            answerText = Double.toString(answerNumber);
                            answerView.setText(answerText);

                        }

                    default:
                        Log.i("Info: Answer default", "Answer was pressed and reached default");
                        break;
                }
        }


    }
}