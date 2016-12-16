package com.jbd.Authorization;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class FBGraph {
    @Inject
    LoginFBServlet loginFBServlet;

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    private String accessToken;


    public FBGraph(String accessToken) {
        this.accessToken = accessToken;
    }

    public FBGraph(){};

    public String getFBGraph() {
        String graph = null;
        try {

            String g = "https://graph.facebook.com/v2.8/me?fields=id,first_name,last_name,email&" + accessToken;
            System.out.println("g: " + g);
            URL u = new URL(g);
            System.out.println("u: " + u.toString());
            URLConnection c = u.openConnection();
            System.out.println("c: " + c.toString());
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    c.getInputStream()));
            System.out.println("in getInputStream: " + in.toString());
            String inputLine;
            StringBuffer b = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                System.out.println("input line: " +inputLine);
                b.append(inputLine + "\n");
            }
            in.close();
            graph = b.toString();
            System.out.println("getFBGraph: " + graph);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR in getting FB graph data. " + e);
        }
        return graph;
    }

    public Map<String, String> getGraphData(String fbGraph) {
        Map<String, String> fbProfile = new HashMap<String, String>();
        try {
            JSONObject json = new JSONObject(fbGraph);
            System.out.println("JSON: " +json.toString());
            fbProfile.put("id", json.getString("id"));
            fbProfile.put("first_name", json.getString("first_name"));
            fbProfile.put("last_name", json.getString("last_name"));

            System.out.println("Mapa: " + fbProfile.get("first_name"));
            if (json.has("email"))
                fbProfile.put("email", json.getString("email"));
        } catch (JSONException e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR in parsing FB graph data. " + e);
        }
        return fbProfile;
    }
}
