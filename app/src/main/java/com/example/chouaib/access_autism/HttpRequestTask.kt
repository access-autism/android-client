package com.example.chouaib.access_autism

import android.net.Uri
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by chouaib on 2/15/18.
 */
internal class HttpRequestTask(var bmImage: ImageView) : AsyncTask<URL, Integer, JSONObject>() {

    private lateinit var result: JSONObject

    override fun doInBackground(vararg p0: URL?): JSONObject {
        val builder = Uri.parse("baseURL").buildUpon()

        //Add Request query Parameters (if any)
        val contentType = "application/json"

        // builder.appendQueryParameter("queryName", queryValue)

        val url = builder.toString()

        val path = URL(url)
        val connection = path.openConnection() as HttpURLConnection
        val timeout = 60 * 1000
        connection.readTimeout = timeout // set request timeout
        connection.connectTimeout = timeout
        connection.requestMethod = "GET" //set HTTP method

        //Request query Header (if needed)
        connection.setRequestProperty("contentType", contentType)

        connection.connect()

        if (connection.responseCode !== HttpURLConnection.HTTP_OK) {
            Log.e("####### HTTP_TASK", "##################################### Unable to fetch weather data")
        } else {
            val stream = connection.inputStream
            val br = BufferedReader(InputStreamReader(stream))
            val responseBody = StringBuilder("")
            var line: String? = null
            while ({ line = br.readLine(); line }() != null) {
                responseBody.append(line)
            }
            br.close()
            stream.close()
            result = JSONObject(responseBody.toString())
            try {
                // extract data from API response

                // temp = result.getJSONObject("main").getString("temp")
                // iconID = result.getJSONArray("weather").getJSONObject(0).getString("icon")
                // description = result.getJSONArray("weather").getJSONObject(0).getString("description")
                // val current = Calendar.getInstance().time
                // val formatted = SimpleDateFormat("HH:mm", Locale.US).format(current)

            } catch (t: Throwable){
                Log.e("####### HTTP_TASK", "##################################### Unable to interpret response JSON")
            }
        }

        return result
    }

    override fun onPostExecute(result: JSONObject?) {
        // change UI
        //bmImage.setImageBitmap(result)
    }
}