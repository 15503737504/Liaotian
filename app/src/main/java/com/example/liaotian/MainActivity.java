package com.example.liaotian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.example.liaotian.adapter.MsgAdapter;
import com.example.liaotian.bean.Msg;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsg();

        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msg);
                    //当有新消息是刷新ListView中的显示
                    adapter.notifyItemInserted(msgList.size() - 1);
                    //将ListView定位到最后一行
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);
                    //清空输入框内容
                    inputText.setText("");
                }
            }
        });
    }

    private void initMsg() {
        Msg msg1 = new Msg("Hello tututu.", Msg.TYPE_RECEIVEO);
        msgList.add(msg1);
        Msg msg2 = new Msg("What are you 弄啥嘞.", Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("Guess what ？？", Msg.TYPE_RECEIVEO);
        msgList.add(msg3);
        Msg msg4 = new Msg("Rats ， screw you", Msg.TYPE_SENT);
        msgList.add(msg4);
        Msg msg5 = new Msg("FFFUK", Msg.TYPE_RECEIVEO);
        msgList.add(msg5);
        Msg msg6 = new Msg("1", Msg.TYPE_SENT);
        msgList.add(msg6);
        Msg msg7 = new Msg("2", Msg.TYPE_RECEIVEO);
        msgList.add(msg7);
        Msg msg8 = new Msg("3", Msg.TYPE_SENT);
        msgList.add(msg8);
        Msg msg9 = new Msg("QWER", Msg.TYPE_RECEIVEO);
        msgList.add(msg9);
        Msg msg10 = new Msg("DF", Msg.TYPE_SENT);
        msgList.add(msg10);
        Msg msg11 = new Msg("碧池", Msg.TYPE_RECEIVEO);
        msgList.add(msg11);

    }
}
