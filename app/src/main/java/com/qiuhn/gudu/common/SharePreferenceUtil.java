
package com.qiuhn.gudu.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.PreferenceManager;

import java.util.List;
import java.util.Map;

public class SharePreferenceUtil {

    public static final String MAK = "innoview";

    private final int MODE = Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE;

    private final SharedPreferences sharedpreferences;

    public SharePreferenceUtil(Context context, String fileName) {
        sharedpreferences = context.getSharedPreferences(fileName, MODE);
    }

    public SharePreferenceUtil(Context context) {
        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }
    
    public boolean saveNotEncodeSharedPreferences(String key, String value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString(key, value);

        return editor.commit();
    }


    public String loadStringNotDecodeSharedPreference(String key) {
        String str = sharedpreferences.getString(key, null);

        return str;
    }

    public boolean saveSharedPreferences(String key, int value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    public int loadIntSharedPreference(String key) {
        return sharedpreferences.getInt(key, 0);
    }

    public boolean saveSharedPreferences(String key, float value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putFloat(key, value);
        return editor.commit();
    }

    public float loadFloatSharedPreference(String key) {
        return sharedpreferences.getFloat(key, 0f);
    }

    public boolean saveSharedPreferences(String key, Long value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putLong(key, value);
        return editor.commit();
    }

    public Long loadLongSharedPreference(String key) {
        return sharedpreferences.getLong(key, 0l);
    }

    public boolean saveSharedPreferences(String key, Boolean value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    public boolean loadBooleanSharedPreference(String key) {
        return sharedpreferences.getBoolean(key, false);
    }

    public boolean loadBooleanSharedPreferenceDefaultTrue(String key) {
        return sharedpreferences.getBoolean(key, true);
    }

    public boolean loadBooleanSharedPreferenceDefaultFalse(String key) {
        return sharedpreferences.getBoolean(key, false);
    }

    public boolean saveAllSharePreference(String keyName, List<?> list) {
        int size = list.size();
        if (size < 1) {
            return false;
        }
        SharedPreferences.Editor editor = sharedpreferences.edit();
        if (list.get(0) instanceof String) {
            for (int i = 0; i < size; i++) {
                editor.putString(keyName + i, (String)list.get(i));
            }
        } else if (list.get(0) instanceof Long) {
            for (int i = 0; i < size; i++) {
                editor.putLong(keyName + i, (Long)list.get(i));
            }
        } else if (list.get(0) instanceof Float) {
            for (int i = 0; i < size; i++) {
                editor.putFloat(keyName + i, (Float)list.get(i));
            }
        } else if (list.get(0) instanceof Integer) {
            for (int i = 0; i < size; i++) {
                editor.putLong(keyName + i, (Integer)list.get(i));
            }
        } else if (list.get(0) instanceof Boolean) {
            for (int i = 0; i < size; i++) {
                editor.putBoolean(keyName + i, (Boolean)list.get(i));
            }
        }
        return editor.commit();
    }

    public Map<String, ?> loadAllSharePreference(String key) {
        return sharedpreferences.getAll();
    }

    public boolean removeKey(String key) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.remove(key);
        return editor.commit();
    }

    public boolean removeAllKey() {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        return editor.commit();
    }

    public boolean contains(String key) {
        return sharedpreferences.contains(key);
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        sharedpreferences.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        sharedpreferences.unregisterOnSharedPreferenceChangeListener(listener);
    }

    
}
