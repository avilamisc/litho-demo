package me.karuppiah7890.lithodemo;

import android.app.LauncherActivity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentInfo;
import com.facebook.litho.LithoView;
import com.facebook.litho.widget.LinearLayoutInfo;
import com.facebook.litho.widget.Recycler;
import com.facebook.litho.widget.RecyclerBinder;
import com.facebook.litho.widget.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ComponentContext context = new ComponentContext(this);

        final RecyclerBinder recyclerBinder = new RecyclerBinder(
                context,
                new LinearLayoutInfo(this, OrientationHelper.VERTICAL,false)
        );

        final Component component = Recycler.create(context)
                .binder(recyclerBinder)
                .build();

        addContent(recyclerBinder,context);

        setContentView(LithoView.create(context, component));
    }

    public static void addContent(RecyclerBinder recyclerBinder, ComponentContext context) {

        for(int i=0;i<32;i++) {
            recyclerBinder.insertItemAt(
                    i,
                    ComponentInfo.create()
                    .component(ListItem.create(context)
                        .color( i%2==0? Color.WHITE : Color.LTGRAY)
                        .title("Hello World" + i)
                        .subtitle("Hey people!")
                        .build())
                    .build()
            );
        }

    }
}
