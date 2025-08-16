package com.opensupport.youropeninfo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstFragment extends Fragment {

    private TextView tvIp, tvHostname, tvCity, tvRegion, tvCountry, tvLoc, tvOrg, tvPostal, tvTimezone;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize TextViews
        tvIp = view.findViewById(R.id.textView4);
        tvHostname = view.findViewById(R.id.textView5);
        tvCity = view.findViewById(R.id.textView6);
        tvRegion = view.findViewById(R.id.textView7);
        tvCountry = view.findViewById(R.id.textView8);
        tvLoc = view.findViewById(R.id.textView9);
        tvOrg = view.findViewById(R.id.textView10);
        tvPostal = view.findViewById(R.id.textView11);
        tvTimezone = view.findViewById(R.id.textView12);

        // Set default text
        tvIp.setText("IP: ");
        tvHostname.setText("Hostname: ");
        tvCity.setText("City: ");
        tvRegion.setText("Region: ");
        tvCountry.setText("Country: ");
        tvLoc.setText("Location: ");
        tvOrg.setText("Organization: ");
        tvPostal.setText("Postal: ");
        tvTimezone.setText("Timezone: ");


        Button getInfoButton = view.findViewById(R.id.button_get_info);
        getInfoButton.setOnClickListener(v -> fetchIpInfo());

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    private void fetchIpInfo() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            // Background work
            String result = null;
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL("https://ipinfo.io/json");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");

                InputStream inputStream = urlConnection.getInputStream();
                StringBuilder buffer = new StringBuilder();
                if (inputStream == null) {
                    // Nothing to do.
                    return;
                }
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line).append("\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return;
                }
                result = buffer.toString();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

            String finalResult = result;
            handler.post(() -> {
                // UI Thread work
                if (finalResult != null) {
                    try {
                        JSONObject jsonObject = new JSONObject(finalResult);
                        tvIp.setText("IP: " + jsonObject.optString("ip"));
                        tvHostname.setText("Hostname: " + jsonObject.optString("hostname"));
                        tvCity.setText("City: " + jsonObject.optString("city"));
                        tvRegion.setText("Region: " + jsonObject.optString("region"));
                        tvCountry.setText("Country: " + jsonObject.optString("country"));
                        tvLoc.setText("Location: " + jsonObject.optString("loc"));
                        tvOrg.setText("Organization: " + jsonObject.optString("org"));
                        tvPostal.setText("Postal: " + jsonObject.optString("postal"));
                        tvTimezone.setText("Timezone: " + jsonObject.optString("timezone"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getContext(), "Failed to parse data", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
