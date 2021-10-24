package com.example.numad21fa_yongzhengqi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;
import android.view.View.OnClickListener;

public class AtYourServiceActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    int count = 1;
    Button btnJoke;
    private TextView question;
    private TextView joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at_your_service);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        question = findViewById(R.id.question);
        joke = findViewById(R.id.joke);
        new jokeTask().execute();
    }

//    public void getJoke(View view) {
//        jokeTask task = new jokeTask();
//        task.execute();
//    }

    private class jokeTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //inProgress.setTitle(R.string.in_progress);
            question.setText("");
            joke.setText("");
        }

        @Override
        protected String[] doInBackground(Void... voids) {
            String[] results = new String[1];
            URL url;
            try {
                url = new URL("https://v2.jokeapi.dev/joke/Any");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                connection.connect();

                results = new String[2];
                InputStream inStream = connection.getInputStream();
                final String response = convertStreamToString(inStream);

                JSONObject jsonObj = new JSONObject(response);
                results[0] = jsonObj.getString("setup");
                results[1] = jsonObj.getString("delivery");
                return results;

            } catch (MalformedURLException e) {
                System.out.println("MalformedURLException");
                e.printStackTrace();
            } catch (ProtocolException e) {
                System.out.println("ProtocolException");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("IOException");
                e.printStackTrace();
            } catch (JSONException e) {
                System.out.println("JSONException");
                e.printStackTrace();
            }
            results[0] = "Something went wrong";
            return(results);
        }

        @Override
        protected void onPostExecute(String[] s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.GONE);
            question.setText(s[0]);
//            if (s.length == 1) {
//                return;
//            }
            joke.setText(s[1]);
        }
    }

    private String convertStreamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next().replace(",", ",\n") : "";
    }
}