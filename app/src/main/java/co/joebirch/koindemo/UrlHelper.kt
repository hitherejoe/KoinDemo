package co.joebirch.koindemo

import android.content.Context
import android.net.Uri
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat

class UrlHelper(private val baseUrl: String) {

    fun launchCurrencyUrl(context: Context, slug: String) {
        launchUrl(context, Uri.parse(baseUrl + slug))
    }

    fun launchUrl(context: Context, uri: Uri) {
        val customTabsIntent = CustomTabsIntent.Builder()
                .addDefaultShareMenuItem()
                .setToolbarColor(
                        ContextCompat.getColor(context, R.color.colorPrimary))
                .setShowTitle(true)
                .build()
        customTabsIntent.launchUrl(context, uri)
    }

}