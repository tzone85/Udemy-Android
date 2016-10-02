package com.example.android.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {
        int number;

        /**
         * isSquare
         */

        public boolean isSquare() {
            double theSquareRoot = Math.sqrt(number);

            if (theSquareRoot == Math.floor(theSquareRoot)) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * triangula number, the sequence terms difference increases by 1 on each iteration
         */
        public boolean isTriangular() {
            int x = 1;
            int triangularNumber = 1;

            while (triangularNumber < number) {
                x++;
                triangularNumber += x;
            }

            if (triangularNumber == number) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void squareOrTrianglular(View view){
        EditText usersNumber = (EditText) findViewById(R.id.editText);
        //Log.i("The user input ", usersNumber.getText().toString());

        String message="";
        if(usersNumber.getText().toString().isEmpty()){
            message = "Please enter a number";
        }else{
            Number inani = new Number();
            //inani.number=6;

            inani.number = Integer.parseInt(usersNumber.getText().toString());

            if(inani.isSquare()){
                if(inani.isTriangular()){
                    message = inani.number +" is both Triangular and Square!!";
                }
                else{
                    message = inani.number + " is Square but not Triangular.";
                }
            }

            else{
                if(inani.isTriangular()){
                    message = inani.number +" is not Square!";
                }
                else{
                    message = inani.number + " is not Square nor Triangular.";
                }
            }
        }

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        //System.out.println(inani.isTriangular());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
