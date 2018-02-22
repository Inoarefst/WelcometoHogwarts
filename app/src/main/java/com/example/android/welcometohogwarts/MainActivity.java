package com.example.android.welcometohogwarts;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    RadioButton answerQuestion6;
    RadioButton answerQuestion2;
    RadioButton answerQuestion3;
    RadioButton answerQuestion4;
    RadioButton answerQuestion5;
    RadioButton answerQuestion7;
    RadioButton answerQuestion8;
    CheckBox answerQuestion9;
    CheckBox correctQuestion9;
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
        answerQuestion2 = findViewById(R.id.rb_question2_answer);
        answerQuestion3 = findViewById(R.id.rb_question3_answer);
        answerQuestion4 = findViewById(R.id.rb_question4_answer);
        answerQuestion5 = findViewById(R.id.rb_question5_answer);
        answerQuestion6 = findViewById(R.id.rb_question6_answer);
        answerQuestion7 = findViewById(R.id.rb_question7_answer);
        answerQuestion8 = findViewById(R.id.rb_question8_answer);
        answerQuestion9 = findViewById(R.id.cb_question9_answer);
        correctQuestion9 = findViewById(R.id.cb_question9_correct);
        radioWhich = findViewById(R.id.radio_group_which);
        radioCommonRoom = findViewById(R.id.radio_group_common_room);
        radioEmblematic = findViewById(R.id.radio_group_emblematic);
        radioElement = findViewById(R.id.radio_group_element);
        radioAbilities = findViewById(R.id.radio_group_abilities);
        radioEntrance = findViewById(R.id.radio_group_entrance);
        radioIgnatia = findViewById(R.id.radio_group_ignatia);
        checkBoxTom = findViewById(R.id.cb_question9_false);
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
        if (year.equals("1926")) score += 5;

        boolean hasAnswerQuestion2 = answerQuestion2.isChecked();
        if (hasAnswerQuestion2) score += 5;

        boolean hasAnswerQuestion3 = answerQuestion3.isChecked();
        if (hasAnswerQuestion3) score += 5;

        boolean hasAnswerQuestion4 = answerQuestion4.isChecked();
        if (hasAnswerQuestion4) score += 5;

        boolean hasAnswerQuestion5 = answerQuestion5.isChecked();
        if (hasAnswerQuestion5) score += 5;

        boolean hasAnswerQuestion6 = answerQuestion6.isChecked();
        if (hasAnswerQuestion6) score = score + 5;

        boolean hasAnswerQuestion7 = answerQuestion7.isChecked();
        if (hasAnswerQuestion7) score += 5;

        boolean hasAnswerQuestion8 = answerQuestion8.isChecked();
        if (hasAnswerQuestion8) score += 5;

        if ((answerQuestion9.isChecked() && !correctQuestion9.isChecked() && !checkBoxTom.isChecked()))
            score += 5;
        if ((answerQuestion9.isChecked() && checkBoxTom.isChecked() && !correctQuestion9.isChecked()) || (correctQuestion9.isChecked() && checkBoxTom.isChecked() && !answerQuestion9.isChecked()))
            score += 0;
        if ((answerQuestion9.isChecked() && correctQuestion9.isChecked() && checkBoxTom.isChecked()))
            score -= 5;

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.themesong);
        mediaPlayer.start();

        if (score == 50) {
            Toast.makeText(this, " Perfect " + name + "\n Your score is " + score + " out of 50 " + "\n You should be Minister of Magic !", Toast.LENGTH_LONG).show();
        }

        if ((score <= 45) && (score > 25)) {
            Toast.makeText(this, name + "\n your score is " + score + " out of 50 " + "\n You are going to be an excellent Wizard", Toast.LENGTH_LONG).show();
        }
        if (score == 25) {
            Toast.makeText(this, name + "\n your score is " + score + " out of 50 " + "\n You have great skills . Keep up the good work .", Toast.LENGTH_LONG).show();
        } else if (score < 25) {
            Toast.makeText(this, name + "\n your score is " + score + " out of 50 " + "\n You must try harder . Muggles can score better than this!", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Method that resets the  quiz .
     * This method is called when the restart button is clicked.
     */
    public void reset(View view) {
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
        answerQuestion9.setChecked(false);
        correctQuestion9.setChecked(false);
    }
}
