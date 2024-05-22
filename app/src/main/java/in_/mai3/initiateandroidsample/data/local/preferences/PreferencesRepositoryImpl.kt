package in_.mai3.initiateandroidsample.data.local.preferences

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class PreferencesRepositoryImpl(
    private val sharedPreferences: SharedPreferences,
    private val editor: Editor
) : PreferencesRepository {

    override fun getString(key: String, default: String) =
        sharedPreferences.getString(key, default).toString()

    override fun putString(key: String, value: String) = with(editor) {
        putString(key, value)
        apply()
    }

    override fun getBoolean(key: String, default: Boolean) =
        sharedPreferences.getBoolean(key, default)

    override fun putBoolean(key: String, value: Boolean) = with(editor) {
        putBoolean(key, value)
        apply()
    }

    override fun getInt(key: String, default: Int) = sharedPreferences.getInt(key, default)

    override fun putInt(key: String, value: Int) = with(editor) {
        putInt(key, value)
        apply()
    }

}