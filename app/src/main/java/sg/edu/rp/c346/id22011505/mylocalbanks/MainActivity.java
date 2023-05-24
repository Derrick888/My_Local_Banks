package sg.edu.rp.c346.id22011505.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;

    String wordClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.buttonDBS);
        btnOCBC = findViewById(R.id.buttonOCBC);
        btnUOB = findViewById(R.id.buttonOCBC);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);

    }

   @Override
       public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu_main,menu);
         return true;

   }

    @Override
        public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.EnglishSelection){
            btnDBS.setText("DBS");
            btnOCBC.setText("OCBC");
            btnUOB.setText("UOB");
            return true;

        } else if (id == R.id.ChineseSelection) {
            btnDBS.setText("星展银行");
            btnOCBC.setText("华侨银行");
            btnUOB.setText("大华银行");
            return true;
            
        } else {
             btnDBS.setText("Error translation");
             btnOCBC.setText("Error translation");
             btnUOB.setText("Error translation");
        }
        return super.onOptionsItemSelected(item);


    }

     @Override
         public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
         super.onCreateContextMenu(menu, v, menuInfo);

         menu.add(0,0,0, "Website");
         menu.add(0,1,1,"Contact the bank");

         if(v == btnDBS) {
             wordClicked = "DBS";
         } else if (v == btnOCBC) {
             wordClicked = "OCBC";
             
         } else if (v == btnUOB) {
             wordClicked = "UOB" ;

         }

     }

     @Override
     public boolean onContextItemSelected(MenuItem item) {
        long numLong = 0;
        if(wordClicked.equalsIgnoreCase("DBS")) {
            if(item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == 1) {
                numLong = 18001111111L;
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + numLong)) ;
                startActivity(intentCall);
                return true;
                
            }
        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if(item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
                return true;

            } else if (item.getItemId() == 1) {
                numLong =  18003633333L;
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + numLong));
                startActivity(intentCall);
                return true;

            }

        } else if (wordClicked.equalsIgnoreCase("UOB")) {
            if(item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == 1) {
                numLong = 18002222121L;
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + numLong)) ;
                startActivity(intentCall);
               return true;

            }

        }
        return super.onContextItemSelected(item);
     }



}