package com.monofix.mytriponair

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Message
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.monofix.mytriponair.extension.showTwoButtonDialog
import com.monofix.mytriponair.fcm.checkPushLink
import com.monofix.mytriponair.utils.BackPressedHandler
import com.monofix.mytriponair.utils.checkEventPopup
import com.monofix.mytriponair.utils.initRemoteConfig
import kotlinx.android.synthetic.main.activity_main.*


private const val USER_AGENT = "Mozilla/5.0 (iPhone; CPU iPhone OS 6_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10A5376e Safari/8536.25"
private const val MAIN_URL = "https://mytriponair.com/"

class MainActivity : FragmentActivity() {

    private var childWebViews = mutableListOf<WebView>() // 만들어진 popup 용 웹뷰들을 관리하기 위한 리스트.
    private lateinit var parentLayout: ViewGroup
    private lateinit var webViewClient: WebViewClient
    var deepLinkUrl = ""
    var isLaunchByPushMessage = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        parentLayout = findViewById(R.id.parent_layout)

        // Status Bar
        setStatusBar()

        // DynamicLink
        checkPushLink(this.intent)

        // Remote Config
        initRemoteConfig()

        // WebView
        initWebView()
    }

    private fun setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        } else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.status_bar_color)
            }
        }
    }

    private fun initWebView() {
        configureWebView(webMain)

        webMain.webChromeClient = ParentWebChromeClient(parentLayout, this)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)

                    if (deepLinkUrl.isNotBlank() or deepLinkUrl.isNotEmpty()) {
                        view?.loadUrl(deepLinkUrl)
                        deepLinkUrl = ""
                        return
                    }

                    if (view == webMain) {
                        if (!webMain.canGoBack()) {
                            if (deepLinkUrl.isEmpty() && isLaunchByPushMessage) {
                                checkEventPopup()
                                isLaunchByPushMessage = false
                            }
                        }
                    }

                    progressMain.visibility = View.GONE
                }

                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    progressMain.visibility = View.VISIBLE
                }

                override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                    val url = request?.url.toString()

                    if (url == MAIN_URL) {
                        if (deepLinkUrl.isEmpty() && isLaunchByPushMessage) {
                            checkEventPopup()
                            isLaunchByPushMessage = false
                        }
                    }

                    if (arrayOf("http", "https").contains(request?.url?.scheme))
                        return false // http, https 주소는 웹뷰가 직접 load 한다.

                    // javascript uri intent 를 parsing 한다. 반드시 해당 flag 를 줘야 함.
                    val intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME)

                    // 실행 가능한 앱이 있으면 실행한다.
                    if (intent.resolveActivity(packageManager) != null) {
                        startActivity(intent)
                        return true
                    }
                    // 실행 가능한 앱이 없으면 인텐트에 fallback  url 값이 있는지 체크한다.
                    if (!resortToFallbackUrl(view!!, intent)) {
                        // fallback url 이 없는 경우, market 으로 보내지 않고 유저에게 실행불가능 설명.
                        Toast.makeText(applicationContext, getString(R.string.toast_not_found_application), Toast.LENGTH_LONG).show()
                    }

                    return false
                    // return super.shouldOverrideUrlLoading(view, request)
                }
            }
        } else {
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)

                    if (deepLinkUrl.isNotBlank() or deepLinkUrl.isNotEmpty()) {
                        view?.loadUrl(deepLinkUrl)
                        deepLinkUrl = ""
                        return
                    }

                    if (view == webMain) {
                        if (!webMain.canGoBack()) {
                            if (deepLinkUrl.isEmpty() && isLaunchByPushMessage) {
                                checkEventPopup()
                                isLaunchByPushMessage = false
                            }
                        }
                    }

                    progressMain.visibility = View.GONE
                }

                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    progressMain.visibility = View.VISIBLE
                }

                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    val loadURL = url ?: ""
                    if (url == MAIN_URL) {
                        if (deepLinkUrl.isEmpty() && isLaunchByPushMessage) {
                            checkEventPopup()
                            isLaunchByPushMessage = false
                        }
                    }

                    if (arrayOf("http", "https").contains(url))
                        return false // http, https 주소는 웹뷰가 직접 load 한다.

                    // javascript uri intent 를 parsing 한다. 반드시 해당 flag 를 줘야 함.
                    val intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME)

                    // 실행 가능한 앱이 있으면 실행한다.
                    if (intent.resolveActivity(packageManager) != null) {
                        startActivity(intent)
                        return true
                    }

                    // 실행 가능한 앱이 없으면 인텐트에 fallback  url 값이 있는지 체크한다.
                    if (!resortToFallbackUrl(view!!, intent)) {
                        Toast.makeText(applicationContext, getString(R.string.toast_not_found_application), Toast.LENGTH_LONG)
                            .show() // fallback url 이 없는 경우, market 으로 보내지 않고 유저에게 실행불가능 설명.
                    }

                    return false
                    // return super.shouldOverrideUrlLoading(view, url)
                }
            }
        }

        webMain.webViewClient = webViewClient
        webMain.loadUrl(MAIN_URL)
    }

    /**
     * 웹뷰 기본 설정 메소드
     */
    @SuppressLint("SetJavaScriptEnabled")
    private fun configureWebView(webView: WebView) {
        val settings = webView.settings
        settings.setGeolocationEnabled(true)
        settings.javaScriptEnabled = true // 자바스크립트 실행 가능하여야 한다.
        settings.setSupportMultipleWindows(true) // 팝업을 허용하기 위해 꼭 해줘야 하는 설정. 설정하지 않으면 WebChromeClient#onCreateWindow() 호출이 되지 않음.
        settings.domStorageEnabled = true
        settings.javaScriptCanOpenWindowsAutomatically = true
        settings.userAgentString = USER_AGENT
    }

    /**
     * 팝업 처리를 해주기 위하여 필요한 WebChromeClient 상속체
     */
    private inner class ParentWebChromeClient(val parent: ViewGroup, val context: Context) : WebChromeClient() {
        /**
         * Javascript 상에서 window.open() 호출 시 호출되는 메소드. 팝업 용 웹뷰를 만들고 parent view group 에 추가해야 한다.
         * WebViewTransport 를 통하여 parent 웹뷰에 child 웹뷰를 전달해야 함.
         */
        @SuppressLint("SetJavaScriptEnabled")
        override fun onCreateWindow(view: WebView?, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message?): Boolean {
            // 팝업을 위한 웹뷰를 만든다.
            val targetWebView = WebView(context)
            targetWebView.settings.javaScriptEnabled = true

            // 팝업 웹뷰 layout 설정. parent 와 동일해야 함.
            targetWebView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT)
            targetWebView.settings.userAgentString = USER_AGENT

            // 팝업을 위한 웹뷰를
            parent.addView(targetWebView)
            childWebViews.add(targetWebView)

            // WebViewTransport 를 통하여 팝업용 웹뷰 전달.
            val transport = resultMsg!!.obj as WebView.WebViewTransport
            transport.webView = targetWebView
            resultMsg.sendToTarget()

            // 팝업용 웹뷰 설정
            // 부모 웹뷰와 같은 WebViewClient 를 사용. (URL 처리는 동일하기 때문)
            targetWebView.webViewClient = webViewClient

            // window.close() 가 호출될 때 parent view group 에서 삭제하고 childWebView 리스트에서 삭제하여야 함.
            targetWebView.webChromeClient = object : WebChromeClient() {
                override fun onCloseWindow(window: WebView?) {
                    super.onCloseWindow(window)
                    parent.removeView(targetWebView)
                    childWebViews.remove(targetWebView)
                }
            }
            return true
        }

        override fun onGeolocationPermissionsHidePrompt() {
            super.onGeolocationPermissionsHidePrompt()
        }

        override fun onGeolocationPermissionsShowPrompt(origin: String?, callback: GeolocationPermissions.Callback?) {
            super.onGeolocationPermissionsShowPrompt(origin, callback)
            val permission = Manifest.permission.ACCESS_FINE_LOCATION

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M || ContextCompat.checkSelfPermission(applicationContext, permission) == PackageManager.PERMISSION_GRANTED) {
                // we're on SDK < 23 OR user has already granted permission
                callback?.invoke(origin, true, false)
            } else {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this@MainActivity, permission)) {
                    showTwoButtonDialog(this@MainActivity, getString(R.string.dialog_location_title), getString(R.string.dialog_location_message),
                        getString(R.string.dialog_location_confirm), getString(R.string.dialog_location_cancel), confirmListener = {
                            val intent = Intent()
                            intent.action = android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                            intent.data = Uri.fromParts("package", packageName, null)
                            startActivity(intent)
                            callback?.invoke(origin, false, false)
                        },
                        cancelListener = {
                            callback?.invoke(origin, false, false)
                        })
//                    callback?.invoke(origin, true, false);
                } else {
                    // permission 허용하지 않은 경우
                    ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permission), 100)
                }
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String?>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MY_PERMISSION_REQUEST_LOCATION) {
            // 수락 시
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initWebView()
            }

            // 거절 시
            if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                initWebView()
            }
        }
    }

        /**
     * 브라우저에서 들어온 intent 에서 browser_fallback_url 을 찾아서 실행시키는 메소드
     * fallback url validation 은 따로하지 않는데, 필요하면 해야함.
     *
     * @return true if webView loaded fallback url, false otherwise
     */
    private fun resortToFallbackUrl(webView: WebView, intent: Intent): Boolean {
        val fallbackUrl = intent.getStringExtra("browser_fallback_url")
        if (fallbackUrl != null) {
            webView.loadUrl(fallbackUrl)
            return true
        }
        return false
    }


    override fun onBackPressed() {
        // 팝업용 웹뷰가 있을 시 닫아주는 코드 구현
        childWebViews.firstOrNull {
            if (it.canGoBack()) {
                it.goBack()
                return
            }
            parentLayout.removeView(it)
            childWebViews.remove(it)
            return
        }
        // 부모 웹뷰의 백버튼 구현
        if (webMain.canGoBack()) {
            webMain.goBack()
            return
        }

        // 액티비티 종료
        BackPressedHandler.onBackPressedKillProcess(this)
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
