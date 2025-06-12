package org.l3on1kl.project.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource
import org.l3on1kl.project.MR
import org.l3on1kl.project.core.ui.model.ChronosTab
import org.l3on1kl.project.core.ui.theme.ChronosTheme

@Composable
fun BottomBar(
    currentTab: ChronosTab,
    onTabClick: (ChronosTab) -> Unit,
    onAddClick: () -> Unit
) {
    BottomBarContent(
        currentTab = currentTab,
        onTabClick = onTabClick,
        onAddClick = onAddClick
    )
}


@Composable
fun BottomBarContent(
    currentTab: ChronosTab,
    onTabClick: (ChronosTab) -> Unit,
    onAddClick: () -> Unit
) {
    Box {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(ChronosTheme.colors.surface)
                    .padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            BottomBarItem(
                icon = Icons.AutoMirrored.Filled.List,
                label = stringResource(MR.strings.tasks),
                selected = currentTab == ChronosTab.Tasks,
                onClick = { onTabClick(ChronosTab.Tasks) },
                modifier = Modifier.weight(1f),
            )

            BottomBarItem(
                icon = Icons.Default.CalendarToday,
                label = stringResource(MR.strings.calendar),
                selected = currentTab == ChronosTab.Calendar,
                onClick = { onTabClick(ChronosTab.Calendar) },
                modifier = Modifier.weight(1f),
            )

            Box(
                modifier =
                    Modifier
                        .weight(1f)
                        .height(48.dp),
                contentAlignment = Alignment.Center,
            ) { }

            BottomBarItem(
                icon = Icons.Default.BarChart,
                label = stringResource(MR.strings.statistics),
                selected = currentTab == ChronosTab.Statistics,
                onClick = { onTabClick(ChronosTab.Statistics) },
                modifier = Modifier.weight(1f),
            )

            BottomBarItem(
                icon = Icons.Default.Settings,
                label = stringResource(MR.strings.settings),
                selected = currentTab == ChronosTab.Settings,
                onClick = { onTabClick(ChronosTab.Settings) },
                modifier = Modifier.weight(1f),
            )
        }

        Box(
            modifier =
                Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = (-24).dp)
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(ChronosTheme.colors.primary)
                    .clickable {
                        onAddClick()
                    },
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(MR.strings.create_task),
                tint = ChronosTheme.colors.onPrimary,
            )
        }
    }
}

@Composable
fun BottomBarItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val activeColor = ChronosTheme.colors.primary
    val inactiveColor = ChronosTheme.colors.outline

    Column(
        modifier =
            modifier
                .clickable(onClick = onClick)
                .padding(vertical = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (selected) activeColor else inactiveColor,
        )
        Text(
            text = label,
            style = ChronosTheme.typography.labelSmall,
            color = if (selected) activeColor else inactiveColor,
        )
    }
}
