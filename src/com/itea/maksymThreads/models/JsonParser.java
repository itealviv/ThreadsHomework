package com.itea.maksymThreads.models;

import com.itea.maksymThreads.resource.Users;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParser {
        private String json;

    public JsonParser(String json){
        this.json = json;
    }

    public void fillArray() {
        JSONObject jsonObj = new JSONObject(json);
        JSONArray arr = jsonObj.getJSONArray("data");

        for (int i = 0; i < arr.length(); i++)
        {
            int id = arr.getJSONObject(i).getInt("id");
            String email = arr.getJSONObject(i).getString("email");
            String firstName = arr.getJSONObject(i).getString("first_name");
            String lastName = arr.getJSONObject(i).getString("last_name");
            String avatar = arr.getJSONObject(i).getString("avatar");
            Users.users.add(new User(id,email,firstName,lastName,avatar));
        }
    }
}
