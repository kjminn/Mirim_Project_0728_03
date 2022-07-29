package kr.hs.emirim.kjminn.mirim_project_0728_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView tvTitle = findViewById(R.id.text_title);
        ImageView imgv = findViewById(R.id.imgv);
        Intent intent = getIntent();
        String[] imgName = intent.getStringArrayExtra("imgName");
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        int[] imgRes = {R.drawable.img01, R.drawable.img02,R.drawable.img03,
                         R.drawable.img04, R.drawable.img05,R.drawable.img06,
                         R.drawable.img07, R.drawable.img08,R.drawable.img09};

        int max = voteCount[0];
        int maxIndex = 0;
        for (int i=0; i<voteCount.length;i++){
            if(voteCount[i] > max){
                max = voteCount[i];
                maxIndex = i;
            }
        }


        tvTitle.setText(imgName[maxIndex]);
        imgv.setImageResource(imgRes[maxIndex]);

        TextView[] tv = new TextView[imgName.length];
        int[] textId = {R.id.text01, R.id.text02, R.id.text03,
                        R.id.text04, R.id.text05, R.id.text06,
                        R.id.text07, R.id.text08, R.id.text09};
        RatingBar[] rb = new RatingBar[voteCount.length];
        int[] rbId = {R.id.rb1, R.id.rb2, R.id.rb3,
                        R.id.rb4, R.id.rb5, R.id.rb6,
                        R.id.rb7, R.id.rb8, R.id.rb9};

        for (int i=0;i<imgName.length;i++){
            tv[i] = findViewById(textId[i]);
            rb[i] = findViewById(rbId[i]);
            tv[i].setText(imgName[i]);
            rb[i].setRating(voteCount[i]);
        }
        Button btnHome = findViewById(R.id.btn_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}