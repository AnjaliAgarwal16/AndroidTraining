package com.example.hello;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment1 extends Fragment {
    private EditText editText;
    private Button buttonSub;
    private Fragment1Listener listener;

    public interface Fragment1Listener {
        void onInput1Sent (CharSequence input);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_1,container,false);
        editText=v.findViewById(R.id.text1);
        buttonSub=v.findViewById(R.id.button_submit);
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listener.onInput1Sent(input);
            }
        });
        return v;
    }
    public void updateEditText (CharSequence newText)
    {
        editText.setText(newText);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Fragment1Listener)
        {
            listener= (Fragment1Listener) context;
        }
        else
        {
            throw new RuntimeException(context.toString()
            + "must implement Fragment1Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;

    }
}
