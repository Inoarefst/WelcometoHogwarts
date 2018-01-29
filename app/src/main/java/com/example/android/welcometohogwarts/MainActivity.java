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
    RadioButton AnswerQuestion1;
    RadioButton AnswerQuestion2;
    RadioButton AnswerQuestion3;
    RadioButton AnswerQuestion4;
    RadioButton AnswerQuestion5;
    RadioButton AnswerQuestion6;
    RadioButton AnswerQuestion7;
    RadioButton AnswerQuestion8;
    CheckBox AnswerQuestion9;
    RadioGroup radioWhich;
    RadioGroup radioCommonRoom;
    RadioGroup radioEmblematic;
    RadioGroup radioElement;
    RadioGroup radioAbilities;
    RadioGroup radioStudent;
    RadioGroup radioEntrance;
    RadioGroup radioIgnatia;
    CheckBox checkBoxTom;
    EditText name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnswerQuestion1 = findViewById(R.id.question1_answer);
        AnswerQuestion2 = findViewById(R.id.question2_answer);
        AnswerQuestion3 = findViewById(R.id.question3_answer);
        AnswerQuestion4 = findViewById(R.id.question4_answer);
        AnswerQuestion5 = findViewById(R.id.question5_answer);
        AnswerQuestion6 = findViewById(R.id.question6_answer);
        AnswerQuestion7 = findViewById(R.id.question7_answer);
        AnswerQuestion8 = findViewById(R.id.question8_answer);
        AnswerQuestion9 = findViewById(R.id.question9_answer);
        radioWhich = findViewById(R.id.radio_group_which);
        radioCommonRoom = findViewById(R.id.radio_group_common_room);
        radioEmblematic = findViewById(R.id.radio_group_emblematic);
        radioElement = findViewById(R.id.radio_group_element);
        radioAbilities = findViewById(R.id.radio_group_abilities);
        radioStudent = findViewById(R.id.radio_group_hufflepuff_student);
        radioEntrance = findViewById(R.id.radio_group_entrance);
        radioIgnatia = findViewById(R.id.radio_group_ignatia);
        checkBoxTom = findViewById(R.id.question9_false);
        name = findViewById(R.id.users_name_view);
    }

    /**
     * This method is called when the score button is clicked.
     * Method makes a Toast displaying the total score.
     */

    public void showScore(View view) {

        //Get user's name.
        EditText usersName = findViewById(R.id.users_name_view);
        String name = usersName.getText().toString();

        boolean hasAnswerQuestion1 = AnswerQuestion1.isChecked();

        boolean hasAnswerQuestion2 = AnswerQuestion2.isChecked();

        boolean hasAnswerQuestion3 = AnswerQuestion3.isChecked();

        boolean hasAnswerQuestion4 = AnswerQuestion4.isChecked();

        boolean hasAnswerQuestion5 = AnswerQuestion5.isChecked();

        boolean hasAnswerQuestion6 = AnswerQuestion6.isChecked();

        boolean hasAnswerQuestion7 = AnswerQuestion7.isChecked();

        boolean hasAnswerQuestion8 = AnswerQuestion8.isChecked();

        boolean hasAnswerQuestion9 = AnswerQuestion9.isChecked();


        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.themesong);
        mediaPlayer.start();

        int score = numberOfCorrectAnswers(hasAnswerQuestion1, hasAnswerQuestion2, hasAnswerQuestion3, hasAnswerQuestion4, hasAnswerQuestion5, hasAnswerQuestion6, hasAnswerQuestion7, hasAnswerQuestion8, hasAnswerQuestion9) * 5;

        if (score == 45) {
            Toast.makeText(this, "Perfect " + name + "\n Your score is " + score + " out of 45 " + "\n You should be Minister of Magic !", Toast.LENGTH_LONG).show();
        }

        if ((score <= 40) && (score > 25)) {
            Toast.makeText(this, name + "\n your score is " + score + " out of 45 " + "\n You are going to be an excellent Wizard", Toast.LENGTH_LONG).show();
        }
        if (score == 25) {
            Toast.makeText(this, name + "\n your score is " + score + " out of 45 " + "\n You have great skills . Keep up the good work .", Toast.LENGTH_LONG).show();
        } else if (score < 25) {
            Toast.makeText(this, name + "\n your score is " + score + " out of 45 " + "\n You must try harder . Muggles can score better than this!", Toast.LENGTH_LONG).show();
        }

    }


    /**
     * This method is used to count the number of correct answers of the user.
     *
     * @param AnswerQuestion1 is whether or not the user has answered question1 correctly.
     * @param AnswerQuestion2 is whether or not the user has answered question2 correctly.
     * @param AnswerQuestion3 is whether or not the user has answered question3 correctly.
     * @param AnswerQuestion4 is whether or not the user has answered question4 correctly.
     * @param AnswerQuestion5 is whether or not the user has answered question5 correctly.
     * @param AnswerQuestion6 is whether or not the user has answered question6 correctly.
     * @param AnswerQuestion7 is whether or not the user has answered question7 correctly.
     * @param AnswerQuestion8 is whether or not the user has answered question8 correctly.
     * @param AnswerQuestion9 is whether or not the user has answered question9 correctly.
     * @return number of correct answers .
     */
    private int numberOfCorrectAnswers(boolean AnswerQuestion1, boolean AnswerQuestion2, boolean AnswerQuestion3, boolean AnswerQuestion4, boolean AnswerQuestion5, boolean AnswerQuestion6, boolean AnswerQuestion7, boolean AnswerQuestion8, boolean AnswerQuestion9) {
        int numberOfCorrectAnswers = 0;

        if (AnswerQuestion1) {
            numberOfCorrectAnswers += 1;
        }
        if (AnswerQuestion2) {
            numberOfCorrectAnswers += 1;
        }
        if (AnswerQuestion3) {
            numberOfCorrectAnswers += 1;
        }
        if (AnswerQuestion4) {
            numberOfCorrectAnswers += 1;
        }
        if (AnswerQuestion5) {
            numberOfCorrectAnswers += 1;
        }
        if (AnswerQuestion6) {
            numberOfCorrectAnswers += 1;
        }
        if (AnswerQuestion7) {
            numberOfCorrectAnswers += 1;
        }
        if (AnswerQuestion8) {
            numberOfCorrectAnswers += 1;
        }
        if (AnswerQuestion9) {
            numberOfCorrectAnswers += 1;
        }
        return numberOfCorrectAnswers;
    }

    /**
     * This method resets the  quiz .
     * This method is called when the restart button is clicked.
     */
    public void Reset(View view) {
        radioWhich.clearCheck();
        radioCommonRoom.clearCheck();
        radioEmblematic.clearCheck();
        radioElement.clearCheck();
        radioAbilities.clearCheck();
        radioStudent.clearCheck();
        radioEntrance.clearCheck();
        radioIgnatia.clearCheck();
        checkBoxTom.setChecked(false);
        AnswerQuestion9.setChecked(false);
        name.setText("");

    }

}
