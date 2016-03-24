package com.necis.firebasesample.item;

/**
 * Created by Jarcode on 2016-03-24.
 */
public class Item {
    String title, content;

    public Item() {
    }

    public Item(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {

        return content;
    }

    public String getTitle() {

        return title;
    }
}
