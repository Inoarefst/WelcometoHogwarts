package com.example.android.welcometohogwarts;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * This app displays a quiz constructed by 9 questions in order the user to play.
 */

public class MainActivity extends AppCompatActivity {
    RadioButton AnswerQuestion6;
    RadioButton AnswerQuestion2;
    RadioButton AnswerQuestion3;
    RadioButton AnswerQuestion4;
    RadioButton AnswerQuestion5;
    RadioButton AnswerQuestion7;
    RadioButton AnswerQuestion8;
    CheckBox AnswerQuestion9;
    CheckBox CorrectQuestion9;
    RadioGroup radioWhich;
    RadioGroup radioCommonRoom;
    RadioGroup radioEmblematic;
    RadioGroup radioElement;
    RadioGroup radioAbilities;
    RadioGroup radioEntrance;
    RadioGroup radioIgnatia;
    CheckBox checkBoxTom;
    EditText name;
    EditText year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnswerQuestion2 = findViewById(R.id.question2_answer);
        AnswerQuestion3 = findViewById(R.id.question3_answer);
        AnswerQuestion4 = findViewById(R.id.question4_answer);
        AnswerQuestion5 = findViewById(R.id.question5_answer);
        AnswerQuestion6 = findViewById(R.id.question6_answer);
        AnswerQuestion7 = findViewById(R.id.question7_answer);
        AnswerQuestion8 = findViewById(R.id.question8_answer);
        AnswerQuestion9 = findViewById(R.id.question9_answer);
        CorrectQuestion9 = findViewById(R.id.question9_correct);
        radioWhich = findViewById(R.id.radio_group_which);
        radioCommonRoom = findViewById(R.id.radio_group_common_room);
        radioEmblematic = findViewById(R.id.radio_group_emblematic);
        radioElement = findViewById(R.id.radio_group_element);
        radioAbilities = findViewById(R.id.radio_group_abilities);
        radioEntrance = findViewById(R.id.radio_group_entrance);
        radioIgnatia = findViewById(R.id.radio_group_ignatia);
        checkBoxTom = findViewById(R.id.question9_false);
        name = findViewById(R.id.users_name_view);
        year = findViewById(R.id.year);
    }

    /**
     * Method that displays the score.
     * This method is called when the score button is clicked.
     * Method makes a Toast displaying the total score.
     */

    public void showScore(View view) {
        int score = 0;
        //Get user's name.
        EditText usersName = findViewById(R.id.users_name_view);
        String name = usersName.getText().toString();

        EditText Riddle = findViewById(R.id.year);
        String year = Riddle.getText().toString();
        if(year.equals("1926")) score+=5;

        boolean hasAnswerQuestion2 = AnswerQuestion2.isChecked();
        if(hasAnswerQuestion2) score+=5;

        boolean hasAnswerQuestion3 = AnswerQuestion3.isChecked();
        if(hasAnswerQuestion3) score+=5;

        boolean hasAnswerQuestion4 = AnswerQuestion4.isChecked();
        if(hasAnswerQuestion4) score+=5;

        boolean hasAnswerQuestion5 = AnswerQuestion5.isChecked();
        if(hasAnswerQuestion5) score+=5;

        boolean hasAnswerQuestion6 = AnswerQuestion6.isChecked();
        if(hasAnswerQuestion6) score = score + 5;

        boolean hasAnswerQuestion7 = AnswerQuestion7.isChecked();
        if(hasAnswerQuestion7) score+=5;

        boolean hasAnswerQuestion8 = AnswerQuestion8.isChecked();
        if(hasAnswerQuestion8) score+=5;

        if((AnswerQuestion9.isChecked() && CorrectQuestion9.isChecked() && !checkBoxTom.isChecked())) score+=10;
        if((AnswerQuestion9.isChecked() && checkBoxTom.isChecked() && !CorrectQuestion9.isChecked()) ||(CorrectQuestion9.isChecked() && checkBoxTom.isChecked() && !AnswerQuestion9.isChecked())) score+=5;
        if((AnswerQuestion9.isChecked() && CorrectQuestion9.isChecked() && checkBoxTom.isChecked()))  score-=15;

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.themesong);
        mediaPlayer.start();

        if (score == 50) {
            Toast.makeText(this, " Perfect " + name + "\n Your score is " + score + " out of 50 " + "\n You should be Minister of Magic !", Toast.LENGTH_LONG).show();
        }

        if ((score <= 45) && (score > 25)) {
            Toast.makeText(this,  name + "\n your score is " + score + " out of 50 " + "\n You are going to be an excellent Wizard", Toast.LENGTH_LONG).show();
        }
        if (score == 25) {
            Toast.makeText(this,  name + "\n your score is " + score + " out of 50 " + "\n You have great skills . Keep up the good work .", Toast.LENGTH_LONG).show();
        } else if (score < 25) {
            Toast.makeText(this,  name + "\n your score is " + score + " out of 50 " + "\n You must try harder . Muggles can score better than this!", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Method that resets the  quiz .
     * This method is called when the restart button is clicked.
     */
    public void Reset(View view) {
        name.setText("");
        year.setText("");
        radioCommonRoom.clearCheck();
        radioEmblematic.clearCheck();
        radioElement.clearCheck();
        radioAbilities.clearCheck();
        radioWhich.clearCheck();
        radioEntrance.clearCheck();
        radioIgnatia.clearCheck();
        checkBoxTom.setChecked(false);
        AnswerQuestion9.setChecked(false);
        CorrectQuestion9.setChecked(false);
    }
}
