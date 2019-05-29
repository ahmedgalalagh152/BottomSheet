package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private BottomSheetBehavior mBottomSheetBehavior;
    private TextView mTextViewState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View bottomSheet=findViewById(R.id.bottom_sheet);
        mBottomSheetBehavior=BottomSheetBehavior.from(bottomSheet);
        mTextViewState=findViewById(R.id.text_behavior);
        Button buttonExpand=findViewById(R.id.button_expand);
        Button buttonCollapse=findViewById(R.id.button_collapse);

        buttonExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

            }
        });

        buttonCollapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                switch (i){
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        mTextViewState.setText("collapsed");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        mTextViewState.setText("Draggig");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        mTextViewState.setText("Expanded");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        mTextViewState.setText("Setlining ....");
                                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        mTextViewState.setText("Hidden ");
                        break;


                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                mTextViewState.setText("Sliding ....");
            }
        });

    }
}
