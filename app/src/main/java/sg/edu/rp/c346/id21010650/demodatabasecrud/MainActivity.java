package sg.edu.rp.c346.id21010650.demodatabasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button buttonAdd, buttonEdit, buttonRetrieve;
    TextView textViewDatabase;
    EditText editContent;
    ArrayList<Note> arraylist;
    ListView listview;
    ArrayAdapter<Note> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arraylist = new ArrayList<Note>();
        aa = new ArrayAdapter<Note>(this,
                android.R.layout.simple_list_item_1, arraylist);
        listview.setAdapter(aa);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editContent.getText().toString();
                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertNote(data);

                if (inserted_id != -1){
                    arraylist.clear();
                    arraylist.addAll(dbh.getAllNotes());
                    aa.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                    buttonRetrieve.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            DBHelper dbh = new DBHelper(MainActivity.this);
                            arraylist.clear();
                            // al.addAll(dbh.getAllNotes());
                            String filterText = editContent.getText().toString().trim();
                            if(filterText.length() == 0) {
                                arraylist.addAll(dbh.getAllNotes());
                            }
                            else{
                                arraylist.addAll(dbh.getAllNotes());
                            }
                                arraylist.addAll(dbh.getAllNotes());
                            aa.notifyDataSetChanged();

                            buttonEdit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Note target = arraylist.get(0);

                                    Intent i = new Intent(MainActivity.this,
                                            EditActivity.class);
                                    i.putExtra("data", target);
                                    startActivity(i);
                                }

                            });
                        }

                    });} ;};});}
    @Override
protected void onResume() {
    super.onResume();
    buttonRetrieve.performClick();
   }
}

