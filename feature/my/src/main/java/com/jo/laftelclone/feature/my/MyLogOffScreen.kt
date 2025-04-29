package com.jo.laftelclone.feature.my

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.jo.laftelclone.core.designsystem.component.LocalClickHandlers
import com.jo.laftelclone.core.designsystem.theme.LightGrey
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
MY 탭에 있는 화면 중 로그아웃 되었을 때 뜨는 화면
 */
@Composable
internal fun MyLogOffScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGrey)
    ) {
        UserInfoSection()
        Spacer(modifier = Modifier.height(16.dp))
        MenuItem(
            iconRes = R.drawable.ic_membership,
            label = stringResource(R.string.feature_my_logoff_membership)
        )
        Spacer(modifier = Modifier.height(16.dp))
        MenuItem(
            iconRes = R.drawable.ic_setting,
            label = stringResource(R.string.feature_my_logoff_setting)
        )
        MenuItem(
            iconRes = R.drawable.ic_customer_center,
            label = stringResource(R.string.feature_my_logoff_customer_center)
        )
    }
}

@Composable
private fun UserInfoSection() {
    val handlers = LocalClickHandlers.current
    val applicationContext = LocalContext.current.applicationContext
    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .statusBarsPadding()
            .clickable {
                handlers.onNavigateToLogin()
            }
            .padding(top = 60.dp, bottom = 60.dp, start = 20.dp, end = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    stringResource(R.string.feature_my_logoff_login_join),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 22.sp
                )
                Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
            }
            Text(
                stringResource(R.string.feature_my_logoff_welcome),
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_default_avatar),
            contentDescription = "Profile",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
        )
    }
}

@Composable
private fun MenuItem(@DrawableRes iconRes: Int, label: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 20.dp, vertical = 18.dp)
            .clickable { /* TODO */ },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painterResource(id = iconRes),
            contentDescription = label,
            tint = Color.Unspecified,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(label, fontSize = 16.sp)
        Spacer(modifier = Modifier.weight(1f))
        Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
    }
}