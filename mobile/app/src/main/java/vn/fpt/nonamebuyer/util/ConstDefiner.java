package vn.fpt.nonamebuyer.util;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Admin on 10/14/2016.
 */

public class ConstDefiner {

    public static final String SCAN_CONTENT = "scanContent";

//    public static final String SERVER_URL = "http://192.168.0.25:8080";
    public static final String SERVER_URL = "http://42.116.255.198:32817";

    public static final long FIXED_ID_SHOP = 1;

    public static final String SCAN_BARCODE_DEMO = "8934588023064";

    public static final boolean PRODUCE_MODE = true;

    public static Gson buildGsonWithDateFormat() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
    }

    public static void setValueToTextview(String value, int id, AppCompatActivity activity) {
        TextView txtTenshop = (TextView) activity.findViewById(id);
        txtTenshop.setText(value);
    }

    public static void showToast(String string, AppCompatActivity activity) {
        Toast toast = Toast.makeText(activity, string, Toast.LENGTH_LONG );
        toast.show();
    }
}
