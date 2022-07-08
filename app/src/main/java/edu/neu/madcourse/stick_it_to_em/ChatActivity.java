package edu.neu.madcourse.stick_it_to_em;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    EditText editText;
    TextView alignText;
    ListView listview;
    //Button f_button;
    FloatingActionButton f_button;
    String[] ListElements = new String[] {
    };

    ImageView selectedImage;
    int images[] = {R.mipmap.sticker1 , R.mipmap.sticker2, R.mipmap.sticker3, R.mipmap.sticker4, R.mipmap.sticker5};

    static class ViewHolder {
        ImageView Image;
        TextView MsgType;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        editText = findViewById(R.id.txtMessageContent);
        editText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);

        alignText = findViewById(R.id.align);
        //alignText.setText("abcd");
        alignText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);

        listview = (ListView) findViewById(R.id.messageListView);
        f_button = findViewById(R.id.btnSendMessage);

        final List< String > ListElementsArrayList = new ArrayList< String >(Arrays.asList(ListElements));
        //final List< ImageView > ListElementsArrayList = new ArrayList< ImageView>();

        final ArrayAdapter< String > adapter = new ArrayAdapter < String >
                (ChatActivity.this, android.R.layout.simple_list_item_1,
                        ListElementsArrayList);

        listview.setAdapter(adapter);

        f_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //selectedImage.setImageResource(R.mipmap.sticker1);
                ListElementsArrayList.add(editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

    }
}