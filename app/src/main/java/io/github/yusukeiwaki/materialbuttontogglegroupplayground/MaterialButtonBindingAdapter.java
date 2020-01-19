package io.github.yusukeiwaki.materialbuttontogglegroupplayground;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;

import com.google.android.material.button.MaterialButton;

@InverseBindingMethods({
        @InverseBindingMethod(type = MaterialButton.class, attribute = "android:checked"),
})
public class MaterialButtonBindingAdapter {
    @BindingAdapter("android:checked")
    public static void setChecked(MaterialButton view, boolean checked) {
        if (view.isChecked() != checked) {
            view.setChecked(checked);
        }
    }

    @BindingAdapter(value = {"android:checkedAttrChanged"}, requireAll = false)
    public static void setListeners(MaterialButton view, final InverseBindingListener attrChange) {
        if (attrChange != null) {
            // TODO:
            //   丁寧に実装するには、TextViewBindingAdapterのようにListenerUtilというクラスを使って
            //   前回仕掛けたリスナーを明示的に解除する必要がある。
            //   参考: https://android.googlesource.com/platform/frameworks/data-binding/+/master/extensions/baseAdapters/src/main/java/android/databinding/adapters/TextViewBindingAdapter.java
            view.clearOnCheckedChangeListeners();

            view.addOnCheckedChangeListener(new MaterialButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(MaterialButton buttonView, boolean isChecked) {
                    attrChange.onChange();
                }
            });
        }
    }
}
