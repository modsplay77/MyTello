package com.example.mytello;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.support.v7.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;

import java.util.ArrayList;

public class ItemAdapter<ListEntry> extends AdapterView {
    private ArrayList<ListEntry> mData;
    public ItemAdapter(ArrayList<ListEntry> data){

        this.mData = data;
    }
    @Override
    public MenuView.ItemView onCreateView(ViewGroup parent,int viewtype){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list, parent,false);
        MenuView.ItemView ivh =new Item(itemView);
        return ivh;
    }

    @Override
    public Adapter getAdapter() {
        return null;
    }

    @Override
    public void setAdapter(Adapter adapter) {

    }

    @Override
    public View getSelectedView() {
        return null;
    }

    @Override
    public void setSelection(int position) {

    }
}
