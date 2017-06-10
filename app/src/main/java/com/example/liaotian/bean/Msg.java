package com.example.liaotian.bean;

/**
 * Created by 丶凉城旧梦 on 2017/6/10.
 */
public class Msg {
    public static final  int TYPE_RECEIVEO = 0;
    public static final  int TYPE_SENT = 1;
    private String content;
    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public static int getTypeReceiveo() {
        return TYPE_RECEIVEO;
    }

    public static int getTypeSent() {
        return TYPE_SENT;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
