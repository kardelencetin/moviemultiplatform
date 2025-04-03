package com.kardelencetin.moviekmm.data.util

import platform.Foundation.NSBundle

actual fun getApiKey(): String = NSBundle.mainBundle.objectForInfoDictionaryKey("API_KEY") as? String ?: ""
