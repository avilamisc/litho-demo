package me.karuppiah7890.lithodemo;

import android.graphics.Color;

import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;

/**
 * Created by karuppiah on 13/5/17.
 */

@LayoutSpec
public class ListItemSpec {
    @OnCreateLayout
    static ComponentLayout onCreateLayout(ComponentContext c,
                                          @Prop int color,
                                          @Prop String title,
                                          @Prop String subtitle) {
        return Column.create(c)
                .paddingDip(YogaEdge.ALL,16)
                .backgroundColor(color)
                .child(
                        Text.create(c)
                        .text(title)
                        .textSizeSp(40)
                )
                .child(
                        Text.create(c)
                                .text(subtitle)
                                .textSizeSp(20)
                ).build();

    }
}
