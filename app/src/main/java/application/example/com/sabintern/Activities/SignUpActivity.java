package application.example.com.sabintern.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import application.example.com.sabintern.AppController;
import application.example.com.sabintern.Database.SQLiteHandler;
import application.example.com.sabintern.R;
import application.example.com.sabintern.ServerConfig;
import application.example.com.sabintern.SessionManager;

/**
 * Created by Dell on 03-12-2017.
 */

public class SignUpActivity extends AppCompatActivity {
    private static final String TAG = SignUpActivity.class.getSimpleName();
    EditText userName;
    EditText userMobile;
    EditText userEmail;
    Button signUpOTP;
    TextView alreadyUser;
    private ProgressDialog pDialog;
    private SessionManager session;
    private SQLiteHandler db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpOTP = findViewById(R.id.sign_up_otp);
        alreadyUser = findViewById(R.id.already_user);
        userName = findViewById(R.id.sign_up_full_name);
        userMobile = findViewById(R.id.signup_contact_no);
        userEmail = findViewById(R.id.sign_up_mail);


        alreadyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userIntent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(userIntent);
            }
        });

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        session = new SessionManager(getApplicationContext());

        db = new SQLiteHandler(getApplicationContext());

        if (session.isLoggedIn()) {
            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        signUpOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = userName.getText().toString().trim();
                String mobile = userMobile.getText().toString().trim();
                String email = userEmail.getText().toString().trim();

                if (!name.isEmpty() && !mobile.isEmpty() && !email.isEmpty()) {
                        registerUser(name, email, mobile);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your details!", Toast.LENGTH_LONG)
                            .show();
                }


            }
        });


    }

    private void registerUser(final String name, final String email, final String mobile) {
        String tag_string_req = "req_register";

        pDialog.setMessage("Registering ...");
        StringRequest strReq = new StringRequest(Request.Method.POST, ServerConfig.URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Register Response: " + response.toString());
                hideDialog();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    boolean error = jsonArray.getBoolean(Integer.parseInt("error"));
                    if (!error) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String id = jsonObject.getString("id");
                            String name = jsonObject.getString("name");
                            String email = jsonObject.getString("email");
                            String mobile = jsonObject.getString("mobile");
                            db.addUser(id, name, email, mobile);

                            Toast.makeText(getApplicationContext(), "User successfully registered. Try login now!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(
                                    SignUpActivity.this,
                                    MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    } else {


                        // Error occurred in registration. Get the error
                        // message
                        String errorMsg = jsonArray.getString(Integer.parseInt("error_msg"));
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }

            }) {
            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", name);
                params.put("email", email);
                params.put("mobile", mobile);

                return params;
            }

        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);

    }



    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }


}
