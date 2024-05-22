package in_.mai3.initiateandroidsample.data.local.preferences

interface PreferencesRepository {

    fun getString(key: String, default: String = ""): String

    fun putString(key: String, value: String)

    fun getBoolean(key: String, default: Boolean = false): Boolean

    fun putBoolean(key: String, value: Boolean)

    fun getInt(key: String, default: Int = 0): Int

    fun putInt(key: String, value: Int)

}