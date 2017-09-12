package cs.tufts.edu.widgetsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    private boolean FLAG_URG = false;
    private boolean FLAG_ACK = false;
    private boolean FLAG_PSH = false;
    private boolean FLAG_RST = false;
    private boolean FLAG_SYN = false;
    private boolean FLAG_FIN = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        int theCheckbox = view.getId();
        switch (theCheckbox) {
            case R.id.checkboxAck:
                FLAG_ACK = checked;
                break;
            case R.id.checkboxFin:
                FLAG_FIN = checked;
                break;
            case R.id.checkboxPsh:
                FLAG_PSH = checked;
                break;
            case R.id.checkboxRst:
                FLAG_RST = checked;
                break;
            case R.id.checkboxSyn:
                FLAG_SYN = checked;
                break;
            case R.id.checkboxUrg:
                FLAG_URG = checked;
                break;
        }
        TextView theLabel = (TextView) findViewById(R.id.theLabel);
        String theLabelStr = "";
        if (FLAG_ACK) {
            theLabelStr += "ACK ";
        }
        if (FLAG_FIN) {
            theLabelStr += "FIN ";
        }
        if (FLAG_PSH) {
            theLabelStr += "PSH ";
        }
        if (FLAG_RST) {
            theLabelStr += "RST ";
        }
        if (FLAG_SYN) {
            theLabelStr += "SYN ";
        }
        if (FLAG_URG) {
            theLabelStr += "URG ";
        }
        theLabel.setText(theLabelStr);
    }
}
