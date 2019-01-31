package com.example.tictactoe;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;
public class MainActivity extends AppCompatActivity {
    String player;
    String computer; //r = rock, s= scissors, p= paper
    String message;
    int computerPick; // 1 = rock, 2 = paper, 3 = scissors
    int playerScore = 0;
    int computerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Rock(View v) {
        Random generator = new Random();
        player = "ROCK";
        computerPick = generator.nextInt(3) + 1;
        PaperRockScissors(computerPick);

        if (computer.equals("ROCK")) {
            message = "its a tie";
            setAll();
        }
        if(computer.equals("PAPER")){
            message = "Computer Wins!! Paper covers Rock";
            computerScore += 1;
            setAll();
        }
        if(computer.equals("SCISSORS")){
            message = "Player Wins!! Scissors cut Paper";
            playerScore += 1;
            setAll();
        }


    }

    public void Paper(View v){
        Random generator = new Random();
        player = "PAPER";
        computerPick = generator.nextInt(3) + 1;
        PaperRockScissors(computerPick);

        if(computer.equals("ROCK")){
            message = "Player Wins!! Paper cover Rock";
            playerScore += 1;
            setAll();
        }
        if(computer.equals("PAPER")){
            message = "its a tie";
            setAll();
        }
        if(computer.equals("SCISSORS")){
            message = "Computer Wins!! Scissors cut Paper";
            setAll();
        }

    }

    public void Scissors(View v){
        Random generator = new Random();
        player = "SCISSORS";
        computerPick = generator.nextInt(3) + 1;
        PaperRockScissors(computerPick);

        if(computer.equals("ROCK")){
            message = "Computer Wins!! Rock Smashes Scissors";
            computerScore += 1;
            setAll();
        }

        if(computer.equals("PAPER")){
            message = "Player wins!!! Scissors cuts Paper";
            playerScore += 1;
            setAll();
        }

        if(computer.equals("SCISSORS")){
            message = "its a tie!!";
            setAll();
        }
    }

    public String PaperRockScissors(int computerPick) {
        if (computerPick == 1) {
            computer = "ROCK";
        } else if (computerPick == 2) {
            computer = "PAPER";
        } else if (computerPick == 3) {
            computer = "SCISSORS";
        }
        return computer;
    }

    public void setPlayersScore(){
        TextView ps = (TextView) findViewById(R.id.PlayerScore);
        ps.setText("Player: " + Integer.toString(playerScore));
    }

    public void setComputersScore(){
        TextView cs = (TextView) findViewById(R.id.ComputerScore);
        cs.setText("Computer: " + Integer.toString(computerScore));
    }

    public void setPlayersWeapon(){
        TextView pw = (TextView) findViewById(R.id.PlayersWeapon);
        pw.setText("Player's weapon " + player);
    }

    public void setComputersWeapon(){
        TextView cw = (TextView) findViewById(R.id.ComputersWeapon);
        cw.setText("Computer's weapon " + computer);
    }

    public void setMessage(){
        TextView m = (TextView) findViewById(R.id.Message);
        m.setText(message);
    }

    public void setAll(){
        setPlayersScore();
        setComputersScore();
        setPlayersWeapon();
        setComputersWeapon();
        setMessage();
    }
}

