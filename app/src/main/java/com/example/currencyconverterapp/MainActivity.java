package com.example.currencyconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1,spinner2;
    String spinner1_value,spinner2_value;
    String rate;
    TextView fc,sc,textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fc = (TextView) findViewById(R.id.fc);
        sc = (TextView) findViewById(R.id.sc);
        textView = (TextView) findViewById(R.id.text_view);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        String[] curr_array = new String[] {
                "USD", "EUR","JOD", "IQD","SYP","LBP","YER","AED","KWD","BHD","SAR","OMR","QAR","EGP","MAD","TND","DZD","LYD","SDG","MUR","SOS","DJF","KMF"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, curr_array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
    }


    public void convert(View view) {
        api();
//        spinner1_value = spinner1.getSelectedItem().toString();
//        spinner2_value = spinner2.getSelectedItem().toString();
//        String val = (spinner1_value+"_"+spinner2_value).toString();
//        jdv.setText(val);
    }
    //====================================================================================================================================
    public void api() {
        spinner1_value = spinner1.getSelectedItem().toString();
        spinner2_value = spinner2.getSelectedItem().toString();

        String url = "https://free.currconv.com/api/v7/convert?q="+spinner1_value+"_"+spinner2_value+"&compact=ultra&apiKey=d7877793bebc1e18230e";
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try
                {
                    String val = spinner1_value+"_"+spinner2_value;
                    rate = response.getString(val);
                    float rate_f = Float.parseFloat(rate);

                    String fc_s = fc.getText().toString();
                    String sc_s = sc.getText().toString();

                    float fc_s_to_f = (Float.parseFloat(fc_s)*rate_f);
                    sc.setText(fc_s_to_f+"");

                    textView.setText("1 "+spinner1_value+" = "+rate+" "+spinner2_value);

                }catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }
        );
        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(jor);
    }
    //====================================================================================================================================
    public void clear (View h)
    {
        fc.setText("");
        sc.setText("");
        textView.setText("Updated Rates");
    }

    public void btnClick_delete(View view) {
        if (fc.getText().equals("")) {
            fc.setText(null);
        } else {
            int len = fc.getText().length();
            String s = fc.getText().toString();
            if (s.charAt(len - 1) == '.') {

                fc.setText(fc.getText().subSequence(0, fc.getText().length() - 1));

            } else {
                fc.setText(fc.getText().subSequence(0, fc.getText().length() - 1));
            }
        }
    }

    public void n0(View view) {
        fc.setText(fc.getText().toString()+"0");
    }
    public void n1(View view) {
        fc.setText(fc.getText().toString()+"1");
    }

    public void n2(View view) {
        fc.setText(fc.getText().toString()+"2");
    }
    public void n3(View view) {
        fc.setText(fc.getText().toString()+"3");
    }
    public void n4(View view) {
        fc.setText(fc.getText().toString()+"4");
    }
    public void n5(View view) {
        fc.setText(fc.getText().toString()+"5");
    }
    public void n6(View view) {
        fc.setText(fc.getText().toString()+"6");
    }
    public void n7(View view) {
        fc.setText(fc.getText().toString()+"7");
    }
    public void n8(View view) {
        fc.setText(fc.getText().toString()+"8");
    }
    public void n9(View view) {
        fc.setText(fc.getText().toString()+"9");
    }
    public void dot(View view) {
        fc.setText(fc.getText().toString()+".");
    }
}



//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.icu.math.BigDecimal;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.Volley;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class MainActivity extends AppCompatActivity {
//
//    public double num;
//    public EditText jdv;
//    public EditText euv;
//    public Button convert;
//
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        /////////////////////////////////////////////////
//        num = 0;
//        jdv = (EditText) findViewById(R.id.jdv);
//        euv = (EditText) findViewById(R.id.euv);
//        convert = (Button) findViewById(R.id.convert);
//
//
//    }
//
//    public void convert(View view) {
//
//         api();
//    }
//
//    public void api (){
//        String url = "https://free.currconv.com/api/v7/convert?q=eur_jod&compact=ultra&apiKey=d7877793bebc1e18230e";
//        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try
//                {
//                    String GetRate = response.getString("EUR_JOD");
//                    float rateTOfloate = Float.parseFloat(GetRate);
//
//                    String j = jdv.getText().toString();
//                    String e = euv.getText().toString();
//
//                    if (j.length() >= 1) {
//                        num = Double.parseDouble(j);
//                        num = num / rateTOfloate;
//                        euv.setText(num + "");
//                    }
//                    if (e.length() >= 1) {
//                        num = Double.parseDouble(e);
//                        num = num * rateTOfloate;
//                        jdv.setText(num + "");
//                    }
//
//                    //String floateToString = String.valueOf(rateTOfloate);
//                }
//                catch (JSONException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//            }
//        }
//        );
//        RequestQueue queue= Volley.newRequestQueue(this);
//        queue.add(jor);
//    }
//
//    public void clk (View h)
//    {
//        euv.setText("");
//        jdv.setText("");
//    }
//
//}


//https://free.currconv.com/api/v7/convert?q=eur_jod&compact=ultra&apiKey=d7877793bebc1e18230e
//
//    public void mm(View v) {
//
//        String j = jdv.getText().toString();
//        String e = euv.getText().toString();
//
//        if (j.length() >= 1) {
//            num = Double.parseDouble(j);
//            num = num / 0.84;
//            euv.setText(num + "");
//        }
//        if (e.length() >= 1) {
//            num = Double.parseDouble(e);
//            num = num * 0.84;
//            jdv.setText(num + "");
//        }
//    }

