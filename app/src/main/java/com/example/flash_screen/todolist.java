package com.example.flash_screen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.util.Strings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class todolist extends AppCompatActivity {

    final List<String> list  = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);
        ListView listView = findViewById(R.id.listview);
        final TextAdapter adapter = new TextAdapter();

        readInfo();

        adapter.setData(list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog dialog = new AlertDialog.Builder(todolist.this)
                        .setTitle("DELETE THIS TASK ")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                list.remove(position);
                                adapter.setData(list);
                            }
                        })
                        .setNegativeButton("No",null)
                        .create();
                dialog.show();
            }
        });

        final Button savebutton = findViewById(R.id.savebutton);

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText taskInput = new EditText(todolist.this);
                taskInput.setSingleLine();
                AlertDialog dialog = new AlertDialog.Builder(todolist.this)
                        .setTitle(" ADD A TASK ")
                        .setMessage("What is your new task ?")
                        .setView(taskInput)
                        .setPositiveButton("ADD Task ", new DialogInterface.OnClickListener() {
                        @Override
                            public void onClick(DialogInterface dialog, int which) {
                            list.add(taskInput.getText().toString());
                            adapter.setData(list);
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();
            }
        });
    }

    @Override
    protected void  onPause()
    {
        super.onPause();
        saveInfo();
    }
    private void saveInfo()
    {
        try{
            File file = new File(this.getFilesDir(), "saved");
            FileOutputStream fout = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fout));

            for(int i=0;i<list.size();i++)
            {
                bw.write(list.get(i));
                bw.newLine();
            }
            bw.close();
            fout.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void readInfo() {
        File file = new File(this.getFilesDir(),"saved");
        if(!file.exists()) {
            return;
        }
        try
        {
            FileInputStream is = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader((is)));
            String line =reader.readLine();
            while(line!= null)
            {
                list.add(line);
                line = reader.readLine();
            }


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    class TextAdapter extends BaseAdapter
    {
        List<String> list = new ArrayList<>();

        void setData(List<String> mlist)
        {
            list.clear();
            list.addAll(mlist);
            notifyDataSetChanged();
        }
        @Override
        public int getCount(){
            return list.size();
        }
        public Object getItem(int position){
            return null;
        }
        @Override
        public long getItemId(int position)
        {
            return 0;
        }
        @Override
        public View getView(int position , View convertView, ViewGroup parent ){
            LayoutInflater inflater = (LayoutInflater)todolist.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View rowView = inflater .inflate(R.layout.item,parent,false);
            final TextView textView = rowView.findViewById(R.id.task);
            textView.setText(list.get(position));
            return  rowView;
        }
    }

}
