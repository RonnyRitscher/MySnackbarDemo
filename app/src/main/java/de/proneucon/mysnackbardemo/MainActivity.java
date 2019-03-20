package de.proneucon.mysnackbardemo;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //MEMBER
    String forUndo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void clear(View view) {
        //Das Clear soll die TextView löschen...
        final TextView tv = findViewById(R.id.tv);
        forUndo = tv.getText().toString();      //speichern in dem Objekt zum wiederherstellen
        tv.setText("");

        //SNACKBAR  -> einer Snackbar kann eine Action mitgegeben werden!
        Snackbar sb = Snackbar.make(
                //findViewById(R.id.constraintLayout) ,   //welches Layout -> wenn ConstraintLayout, dann sollte sich der FloatingButton NICHT mit verschieben
                findViewById(R.id.coordinatorLayout) ,   //welches Layout -> wenn coordinatorLayout, dann sollte sich der FloatingButton mit verschieben
                "Rückgängig" ,  //AnzeigeText
                Snackbar.LENGTH_LONG ); //AnzeigeLänge

        //SNACKBAR-ACTION: fügt der Anzeige "undo" hinzu und macht das löschen rückgängig
        sb.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(forUndo);
            }
        });  //Definieren einer Action

        //SNACKBAR-SHOW
        sb.show(); //Anzeigen


    }
}
