package a.mytodos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextId;
    EditText editTextPw;
    Button btnLogin;
    String ID_correct;
    SharedPreferences sharedPref;
    String packageName = "a.mytodos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextId = (EditText)findViewById(R.id.editTextId);
        editTextPw = (EditText)findViewById(R.id.editTextPw);
        btnLogin = (Button)findViewById(R.id.btnLogin);

        sharedPref = this.getSharedPreferences(packageName, Context.MODE_PRIVATE);
        String ID = sharedPref.getString("ID", "");//id라는 키가 존재하면 가져오고 없으면 빈칸으로 셋팅
        String PW = sharedPref.getString("PW", "");
        editTextId.setText(ID);
        editTextPw.setText(PW);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID_correct = "lgm";
                String PW_correct = "a123";
                String ID = editTextId.getText().toString();
                String PW = editTextPw.getText().toString();
                if(ID.equals(ID_correct) && PW.equals( PW_correct)){


                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("ID", ID_correct);
                    editor.putString("PW", PW_correct);
                    editor.commit();


                    Activity fromActivity = MainActivity.this;
                    Class toActivity = TodoActivity.class;
                    Intent intent = new Intent(fromActivity, toActivity);
                    intent.putExtra("message", ID_correct);
                    startActivity(intent);
                }else if(ID.equals(ID_correct) && !PW.equals(PW_correct)){
                    Toast.makeText(getApplicationContext(), "아이디를 다시 확인하십시오"
                            ,Toast.LENGTH_SHORT).show();
                }else if(!ID.equals(ID_correct) && PW.equals(PW_correct)){
                    Toast.makeText(getApplicationContext(), "비밀번호를 다시 확인하십시오"
                            ,Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "아이디와 비밀번호를 다시 확인하십시오"
                            ,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
