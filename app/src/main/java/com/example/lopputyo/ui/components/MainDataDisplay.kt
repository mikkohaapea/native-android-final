package com.example.lopputyo.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.lopputyo.R
import com.example.lopputyo.model.LatestValues
import com.example.lopputyo.model.Values

@Composable
fun MainDataDisplay(data: List<LatestValues>, location: String = "") {
    var values: Values?
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(data) { d ->
            values = when (location) {
                "Kevo" -> d.data.kev.copy()
                "Kilpisjärvi" -> d.data.kil.copy()
                "Ivalo" -> d.data.iva.copy()
                "Muonio" -> d.data.muo.copy()
                "Pello" -> d.data.pel.copy()
                "Ranua" -> d.data.ran.copy()
                "Oulujärvi" -> d.data.ouj.copy()
                "Mekrijärvi" -> d.data.mek.copy()
                "Hankasalmi" -> d.data.han.copy()
                "Nurmijärvi" -> d.data.nur.copy()
                "Tartu" -> d.data.tar.copy()
                else -> null
            }
            if (values != null) {
                Text(
                    text = stringResource(R.string.timestamp, values!!.time),
                    modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
                )
                Text(
                    text = stringResource(R.string.station, values!!.station),
                    modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
                )
                Text(
                    text = stringResource(R.string.forecast, values!!.probability),
                    modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
                )
            } else {
                Text(
                    text = stringResource(R.string.invalid_location),
                    modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
                )
            }
        }
    }
}