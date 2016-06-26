package a.mytodos;

import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TodoActivity extends ListActivity {
    Button btnAdd;
    TextView textViewIntro;
    ArrayList<String> todos;
    SharedPreferences sharedPref;
    String packageName = "a.mytodos";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        textViewIntro = (TextView)findViewById(R.id.textViewIntro);

        Bundle extras = getIntent().getExtras();
        String message = "";
        if(extras != null){
            message = extras.getString("message");
        }
        textViewIntro.setText("Hello " + message);

        sharedPref = this.getSharedPreferences(packageName, Context.MODE_PRIVATE);
        todos = new ArrayList<String>();
        loadArrayList();
        updateList();

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                showAddDialog();
            }
        });
    }

    protected  void onListItemClick(ListView l, View v, final int position, long id){
        super.onListItemClick(l, v, position, id);
        String work = todos.get(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("이 일이 다 끝났나요?");
        builder.setPositiveButton("Done", new DialogInterface.OnClickListener(){
           @Override
            public void onClick(DialogInterface dialog, int which){
               todos.remove(position);
               saveArrayList();
               updateList();
           }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
               dialog.cancel();
            }
        });
        builder.show();
    }

    public void showAddDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("추가");
        builder.setMessage("할 일을 추가해주세요");

        final EditText todo_input = new EditText(this);
        todo_input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(todo_input);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                String input = todo_input.getText().toString();
                todos.add(input);
                logLibrary.printEach(todos);
                saveArrayList();
                updateList();
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                dialog.cancel();
            }
        });
        builder.show();
    }

    public void updateList() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, todos);
        setListAdapter(adapter);
    }

    public void saveArrayList(){
        String todo_str = "";
        for(String todo : todos){
            todo_str = todo_str + todo + "$$$";
            logLibrary.print(todo_str);
        }
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("todo", todo_str);
        editor.commit();
    }

    public void loadArrayList(){
        String todo = sharedPref.getString("todo", "");
        String [] todo_arr = todo.split("$$$");
        logLibrary.printEach(todo_arr);
        for(String work : todo_arr){
            todos.add(work);
        }
    }
}
