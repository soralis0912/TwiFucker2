package me.swak;

import android.util.Log;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class JsonHooks {
    static boolean LOG;
    static boolean REMOVE_PROMOTED_POSTS = Pref.isHideAdsEnabled();
    static boolean REMOVE_SOCIAL_CONTEXT = Pref.isHideSocialContext();
    static boolean REMOVE_WTF = Pref.isHideWTFEnabled();
    static boolean REMOVE_REC_USERS = Pref.isHideRecAccEnabled();
    static boolean REMOVE_DISCOVER_MORE = Pref.isHideMorePostsEnabled();
    static boolean REMOVE_VFU = Pref.isHideVidCEnabled();

    private static boolean b() {
        return true;
    }

    private static void print(Object obj) {
        Log.d("jsonLog", obj.toString());
    }

    private static JSONObject content(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("tweetResult");
        JSONObject jSONObject3 = jSONObject2.getJSONObject("result");
        if (!jSONObject.isNull("socialContext")) {
            String string = jSONObject.getJSONObject("socialContext").getString("contextType");
            if (!string.equals("Pin") && REMOVE_SOCIAL_CONTEXT) {
                print("Removed contextType: " + string);
                jSONObject.remove("socialContext");
            }
        }
        jSONObject2.put("result", jSONObject3);
        return jSONObject.put("tweetResult", jSONObject2);
    }

    private static JSONObject entry(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("content");
        Object obj = new Object();
        String str = "timelineModule";
        if (!jSONObject2.isNull("content")) {
            obj = REMOVE_SOCIAL_CONTEXT ? content(jSONObject2.getJSONObject("content")) : jSONObject2;
            str = "content";
        } else if (!jSONObject2.isNull("items")) {
            obj = jSONObject2.getJSONArray("items");
            str = "items";
        } else if (jSONObject2.isNull("timelineModule")) {
            str = "0";
        } else {
            obj = jSONObject2.getJSONObject("timelineModule");
        }
        if (!str.equals("0")) {
            jSONObject2.put(str, obj);
        }
        return jSONObject.put("content", jSONObject2);
    }

    private static JSONObject entries(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("entries");
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            String string = jSONObject2.getString("entryId");
            String[] split = string.split("-");
            String str = split[0];
            if (!str.equals("cursor") && !str.equals("Guide") && !str.startsWith("semantic_core")) {
                if (str.equals("promoted") && REMOVE_PROMOTED_POSTS) {
                    print("removed " + string);
                } else if (str.equals("conversationthread") && split.length == 3 && REMOVE_PROMOTED_POSTS) {
                    print("removed " + string);
                } else if (str.equals("tweetdetailrelatedtweets") && REMOVE_DISCOVER_MORE) {
                    print("removed " + string);
                } else if (str.equals("who") && REMOVE_WTF) {
                    print("removed " + string);
                } else if (str.equals("superhero") && REMOVE_PROMOTED_POSTS && jSONObject2.toString().contains("promotedMetadata")) {
                    print("removed " + string);
                } else if (str.equals("tweet") && REMOVE_VFU && jSONObject2.getLong("sortIndex") < 100) {
                    print("removed Vid for you");
                } else {
                    jSONObject2 = entry(jSONObject2);
                }
            }
            jSONArray.put(jSONObject2);
        }
        return jSONObject.put("entries", jSONArray);
    }

    private static JSONObject instructions(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("instructions");
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            if (!jSONObject2.isNull("entry")) {
                jSONObject2.put("entry", entry(jSONObject2.getJSONObject("entry")));
            } else if (!jSONObject2.isNull("entries")) {
                jSONObject2 = entries(jSONObject2);
            } else if (!jSONObject2.isNull("addEntries")) {
                jSONObject2.put("addEntries", entries(jSONObject2.getJSONObject("addEntries")));
            }
            jSONArray.put(jSONObject2);
        }
        return jSONObject.put("instructions", jSONArray);
    }

    private static JSONObject timeline_response(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("timeline_response");
        if (optJSONObject.isNull("timeline")) {
            optJSONObject = instructions(optJSONObject);
        } else {
            optJSONObject.put("timeline", instructions(optJSONObject.optJSONObject("timeline")));
        }
        jSONObject.put("timeline_response", optJSONObject);
        return jSONObject;
    }

    public static String handleJson(String str) throws JSONException {
        if (str.startsWith("[")) {
            return str;
        }
        JSONObject jSONObject = new JSONObject(str);
        new JSONObject();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (str.startsWith("{\"data\":{\"timeline_response\"")) {
                jSONObject.put("data", timeline_response(optJSONObject));
            } else if (str.startsWith("{\"data\":{\"user_result\":{\"result\":{\"timeline_response\"")) {
                JSONObject jSONObject2 = optJSONObject.getJSONObject("user_result");
                jSONObject2.put("result", timeline_response(jSONObject2.getJSONObject("result")));
                optJSONObject.put("user_result", jSONObject2);
                jSONObject.put("data", optJSONObject);
            } else if (str.startsWith("{\"recommended_users\"") && REMOVE_REC_USERS) {
                jSONObject.put("recommended_users", new JSONArray());
                print("removed recommended_users");
            } else if (str.startsWith("{\"globalObjects\":{\"tweets")) {
                jSONObject.put("timeline", instructions(jSONObject.getJSONObject("timeline")));
            } else if (str.startsWith("{\"data\":{\"search\"")) {
                jSONObject.put("search", timeline_response(optJSONObject.getJSONObject("search")));
            }
        } catch (Exception e) {
            print(e.toString());
        }
        return jSONObject.toString();
    }

    private static byte[] str2Bytes(String str) throws UnsupportedEncodingException {
        return str.getBytes("UTF-8");
    }

    private static String streamToString(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    return sb.toString();
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public static InputStream hook(InputStream inputStream) throws IOException, JSONException {
        String streamToString = streamToString(inputStream);
        try {
            streamToString = handleJson(streamToString);
        } catch (Exception e) {
            print(e.toString());
        }
        return new ByteArrayInputStream(str2Bytes(streamToString));
    }
}
